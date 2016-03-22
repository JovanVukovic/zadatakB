package levi9.praksa.zadatakB.controller;

import java.util.ArrayList;
import java.util.List;

import levi9.praksa.zadatakB.impl.InMemoryExampleInput;
import levi9.praksa.zadatakB.model.BetOffer;
import levi9.praksa.zadatakB.model.ErrorJSON;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.model.Match;
import levi9.praksa.zadatakB.model.PlacedBet;
import levi9.praksa.zadatakB.service.ExamleInputService;
import levi9.praksa.zadatakB.service.ExampleOutService;

public class Controller {

	private ExampleOutService exampleOutService;

	private ExamleInputService exampleInputService;

	public boolean goodMatch(Double odd1, Double odd2) {

		if ((odd1 >= new Double("1.2") && odd1 < new Double("1.3")) && odd2 > new Double("6")) {

			return true;

		} else if ((odd1 >= new Double("1.3") && odd1 < new Double("1.4")) && odd2 > new Double("4.33")) {

			return true;

		} else if ((odd1 >= new Double("1.4") && odd1 < new Double("1.5")) && odd2 > new Double("3.5")) {

			return true;

		} else if ((odd1 >= new Double("1.5") && odd1 < new Double("1.6")) && odd2 > new Double("3")) {

			return true;

		} else if ((odd1 >= new Double("1.6") && odd1 < new Double("1.7")) && odd2 > new Double("2.66")) {

			return true;

		} else if ((odd1 >= new Double("1.7") && odd1 < new Double("1.8")) && odd2 > new Double("2.42")) {

			return true;

		} else if ((odd1 >= new Double("1.8") && odd1 < new Double("1.9")) && odd2 > new Double("2.25")) {

			return true;

		} else if ((odd1 >= new Double("1.9") && odd1 <= new Double("2.0")) && odd2 > new Double("2.11")) {

			return true;

		} else if (odd1 > new Double("2.0") && odd2 > new Double("2.00")) {

			return true;
			/////////////////////
		} else if ((odd2 >= new Double("1.2") && odd2 < new Double("1.3")) && odd1 > new Double("6")) {

			return true;

		} else if ((odd2 >= new Double("1.3") && odd2 < new Double("1.4")) && odd1 > new Double("4.33")) {

			return true;

		} else if ((odd2 >= new Double("1.4") && odd2 < new Double("1.5")) && odd1 > new Double("3.5")) {

			return true;

		} else if ((odd2 >= new Double("1.5") && odd2 < new Double("1.6")) && odd1 > new Double("3")) {

			return true;

		} else if ((odd2 >= new Double("1.6") && odd2 < new Double("1.7")) && odd1 > new Double("2.66")) {

			return true;

		} else if ((odd2 >= new Double("1.7") && odd2 < new Double("1.8")) && odd1 > new Double("2.42")) {

			return true;

		} else if ((odd2 >= new Double("1.8") && odd2 < new Double("1.9")) && odd1 > new Double("2.25")) {

			return true;

		} else if ((odd2 >= new Double("1.9") && odd2 < new Double("2.0")) && odd1 > new Double("2.11")) {

			return true;

		} else if (odd2 >= new Double("2.0") && odd1 > new Double("2.0")) {

			return true;

		}

		return false;

	}
	
	public ErrorJSON error(){
		ErrorJSON error = new ErrorJSON();
		error.setError_code(1);
		error.setError_description("Bad JSON file. There is only one Booky!");
		
		return error;
	}

	public ExampleOut findOdds(ExampleInput input) {

		// InMemoryExampleInput inMemInput = new InMemoryExampleInput();
		ExampleInput inputObject = input;

		if (inputObject.getBookies().size() < 2) {
			System.out.println("Maanje od 2");
			error();

		} else {
			List<BetOffer> betOffer1 = inputObject.getBookies().get(0).getBetOffers();
			List<BetOffer> betOffer2 = inputObject.getBookies().get(1).getBetOffers();

			List<Match> matches = new ArrayList<Match>();

			ExampleOut exampleOut = new ExampleOut();
			Double end_profit = null;
			for (int i = 0; i < betOffer1.size(); i++) {
				for (int j = 0; j < betOffer2.size(); j++) {
					if (betOffer1.get(i).getId().equals(betOffer2.get(j).getId())) {
						boolean matcOdd = goodMatch(betOffer1.get(i).getOddsHome(), betOffer2.get(j).getOddsAway());
						boolean matcOdd2 = goodMatch(betOffer1.get(i).getOddsAway(), betOffer2.get(j).getOddsHome());
						if (matcOdd) {
							System.out.println(betOffer1.get(i).getId());
							Double calcArb = calcArb(betOffer1.get(i).getOddsHome(), betOffer2.get(j).getOddsAway());
							Double profit = profit(inputObject.getBudget(), calcArb);
							end_profit=profit;
							Double individual1 = individual(inputObject.getBudget(), betOffer1.get(i).getOddsHome(), calcArb);
							Double individual2 = individual(inputObject.getBudget(), betOffer2.get(j).getOddsAway(), calcArb);
							
							System.out.println("Budzet "+inputObject.getBudget()+", calcArb "+calcArb+" profit "+profit);
							
							if (individual1>betOffer1.get(i).getMaxBet() || individual2> betOffer1.get(j).getMaxBet()) {
								break;
							}
							
							PlacedBet placedBet1 = new PlacedBet();
							PlacedBet placedBet2 = new PlacedBet();

							placedBet1.setBookieId(inputObject.getBookies().get(0).getId());
							placedBet1.setBetHome(betOffer1.get(i).getOddsHome());

							placedBet2.setBookieId(inputObject.getBookies().get(1).getId());
							placedBet2.setBetAway(betOffer2.get(j).getOddsAway());

							List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
							placedBets.add(placedBet1);
							placedBets.add(placedBet2);

							Match match = new Match();

							match.setId(betOffer1.get(i).getId());
							match.setName(betOffer1.get(i).getName());
							match.setPlacedBets(placedBets);

							matches.add(match);

						} else if (matcOdd2) {
							System.out.println(betOffer1.get(i).getId());

							PlacedBet placedBet1 = new PlacedBet();
							PlacedBet placedBet2 = new PlacedBet();

							placedBet1.setBookieId(inputObject.getBookies().get(0).getId());
							placedBet1.setBetHome(betOffer1.get(i).getOddsHome());

							placedBet2.setBookieId(inputObject.getBookies().get(1).getId());
							placedBet2.setBetAway(betOffer2.get(j).getOddsAway());

							List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
							placedBets.add(placedBet1);
							placedBets.add(placedBet2);

							Match match = new Match();

							match.setId(betOffer1.get(i).getId());
							match.setName(betOffer1.get(i).getName());
							match.setPlacedBets(placedBets);

							matches.add(match);

						}

					}
				}

			}
			exampleOut.setCalculatedProfit(end_profit);
			exampleOut.setMatches(matches);
			return exampleOut;

		}

		return null;
	}

	public Double calcArb(Double odd1, Double odd2) {
		System.out.println("odd1 "+odd1+" odd2 "+odd2);
		Double calcArb = ((1 / odd1) + (1 / odd2));
		return calcArb;

	}

	public Double profit(Double investment, Double calcArb) {
		Double profit = (investment / calcArb) - investment;
		return profit;

	}

	public Double individual(Double investment, Double odd, Double calcArb) {
		Double individual = (investment/odd)/calcArb;
		return individual;
	}

}
