package levi9.praksa.zadatakB.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import levi9.praksa.zadatakB.ErrorCodes;
import levi9.praksa.zadatakB.Main;
import levi9.praksa.zadatakB.exception.ZadatakBException;
import levi9.praksa.zadatakB.model.BetOffer;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.model.Match;
import levi9.praksa.zadatakB.model.PlacedBet;
import levi9.praksa.zadatakB.repository.ExampleInputRepository;
import levi9.praksa.zadatakB.repository.ExampleOutRepository;
import levi9.praksa.zadatakB.service.ExamleInputService;

@Service
public class ExampleInputServiceImpl implements ExamleInputService {

	final static Logger logger = LogManager.getLogger(Main.class);

	@Autowired
	private ExampleInputRepository exampleInputRepository;

	@Autowired
	private ExampleOutRepository exampleOutRepository;

	/**
	 * Returns List of Match if there are good odds and  if calculated bet is less than max bet on match.
	 * 
	 * @param exampleInput
	 * @return List of Match.
	 */
	private List<Match> findMatches(ExampleInput exampleInput) {

		List<BetOffer> betOffers1 = exampleInput.getBookies().get(0).getBetOffers();
		List<BetOffer> betOffers2 = exampleInput.getBookies().get(1).getBetOffers();
		List<Match> matches = new ArrayList<Match>();

		for (int i = 0; i < betOffers1.size(); i++) {
			for (int j = 0; j < betOffers2.size(); j++) {
				if (betOffers1.get(i).getId().equals(betOffers2.get(j).getId())) {
					// check if home odd of first bookie and away odd of second
					// bookie are good
					boolean matcOdd = goodMatch(betOffers1.get(i).getOddsHome(), betOffers2.get(j).getOddsAway());
					// check if away odd of first bookie and home odd of second
					// bookie are good
					boolean matcOdd2 = goodMatch(betOffers1.get(i).getOddsAway(), betOffers2.get(j).getOddsHome());
					if (matcOdd) {
						PlacedBet placedBet1 = new PlacedBet();
						PlacedBet placedBet2 = new PlacedBet();

						double p1 = 1 / betOffers1.get(i).getOddsHome();
						double p2 = 1 / betOffers2.get(j).getOddsAway();
						double bet1 = (exampleInput.getBudget() * p1) / (p1 + p2);
						double bet2 = (exampleInput.getBudget() * p2) / (p1 + p2);

						if (exampleInput.getDesiredProfit() > bet1 * betOffers1.get(i).getOddsHome()) {
							throw new ZadatakBException(ErrorCodes.NON_REACHABLE_PROFIT, "Non reachable profit!");
						}

						placedBet1.setBookieId(exampleInput.getBookies().get(0).getId());
						placedBet1.setBetHome(bet1);
						placedBet2.setBookieId(exampleInput.getBookies().get(1).getId());
						placedBet2.setBetAway(bet2);

						List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
						placedBets.add(placedBet1);
						placedBets.add(placedBet2);

						Match match = new Match();
						match.setId(betOffers1.get(i).getId());
						match.setName(betOffers1.get(i).getName());
						match.setPlacedBets(placedBets);
					
						if (bet1<betOffers1.get(i).getMaxBet() && bet2<betOffers2.get(j).getMaxBet()) {
							matches.add(match);
						}						
					} else if (matcOdd2) {
						PlacedBet placedBet1 = new PlacedBet();
						PlacedBet placedBet2 = new PlacedBet();

						double p1 = 1 / betOffers1.get(i).getOddsAway();
						double p2 = 1 / betOffers2.get(j).getOddsHome();
						double bet1 = (exampleInput.getBudget() * p1) / (p1 + p2);
						double bet2 = (exampleInput.getBudget() * p2) / (p1 + p2);

						if (exampleInput.getDesiredProfit() > bet1 * betOffers1.get(i).getOddsAway()) {
							throw new ZadatakBException(ErrorCodes.NON_REACHABLE_PROFIT, "Non reachable profit!");
						}

						placedBet1.setBookieId(exampleInput.getBookies().get(0).getId());
						placedBet1.setBetAway(bet1);

						placedBet2.setBookieId(exampleInput.getBookies().get(1).getId());
						placedBet2.setBetHome(bet2);

						List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
						placedBets.add(placedBet1);
						placedBets.add(placedBet2);

						Match match = new Match();

						match.setId(betOffers1.get(i).getId());
						match.setName(betOffers1.get(i).getName());
						match.setPlacedBets(placedBets);
						
						if (bet1<betOffers1.get(i).getMaxBet() && bet2<betOffers2.get(j).getMaxBet()) {
							matches.add(match);
						}
					}
				}
			}
		}
		return matches;
	}

	/**
	 * Finds arbitrage bets. (Finding arbitrage bets
	 * <a href="http://www.sportsbettingworm.com/arbitrage-calculations/">http:/
	 * /www.sportsbettingworm.com/arbitrage-calculations/</a>)
	 * 
	 * @param odd1
	 * @param odd2
	 * @return Returns true if odd1 and odd2 are valid arbitrage odds.
	 */
	public boolean goodMatch(Double odd1, Double odd2) {
		if (odd1 == null || odd2 == null) {
			logger.error("Bad JSON, missing odds!");
			throw new ZadatakBException(ErrorCodes.BAD_JSON_MISSING_CODE, "Bad JSON, missing odds");
		}
		if (((1 / odd1) + (1 / odd2)) < 1) {
			return true;
		}

		return false;
	}

	/**
	 * Returns ExampleOut object based on ExampleInput and saves both objects to database.
	 * If ExampleInput exists in database, ExampleOut is read from database, and will not be saved to database. 
	 * 
	 * @param exampleInput
	 * @return Returns ExampleOut object based on ExampleInput.
	 */
	public ExampleOut processInput(ExampleInput exampleInput) {
		if (exampleInput.getBookies().size() < 2) {
			logger.error("Bad JSON, only one Bookie!");
			throw new ZadatakBException(ErrorCodes.BAD_JSON_ONLY_ONE_BOOKIE, "Bad JSON, only one Bookie!");
		} else {

			List<ExampleInput> exampleInputList = exampleInputRepository
					.findByBudgetAndDesiredProfit(exampleInput.getBudget(), exampleInput.getDesiredProfit());
			if (exampleInputList!=null) {
				for (int i = 0; i < exampleInputList.size(); i++) {
					if (exampleInput.equals(exampleInputList.get(i))) {
						return exampleOutRepository.findOne(exampleInputList.get(i).getId());
					}
				}
			}

			List<Match> matches = findMatches(exampleInput);
			if (matches.size() == 0) {
				logger.info("There is no match!");
				throw new ZadatakBException(ErrorCodes.NO_MATCH, "There is no match!");
			}
			ExampleOut exampleOut = new ExampleOut();
			exampleOut.setCalculatedProfit(exampleInput.getDesiredProfit());
			exampleOut.setMatches(matches);

			exampleInputRepository.save(exampleInput);
			exampleOutRepository.save(exampleOut);

			return exampleOut;
		}
	}
}
