package levi9.praksa.zadatakB.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import levi9.praksa.zadatakB.model.BetOffer;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.model.Match;
import levi9.praksa.zadatakB.model.PlacedBet;
import levi9.praksa.zadatakB.service.ExamleInputService;


public class InMemoryExampleInput implements ExamleInputService {

	double calculatedProfit = 0;

	public ExampleInput findAll(String path) {

		ObjectMapper mapper = new ObjectMapper();
		ExampleInput inputObject = null;

		try {
			// Convert JSON string from file to Object
			// inputObject = mapper.readValue(new
			// File("D:\\JovanVukovic\\praksa\\zadatak-b\\test1-happy-flow.json"),
			// ExampleInput.class);
			inputObject = mapper.readValue(new File(path), ExampleInput.class);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputObject;

	}

	public List<Match> findMatches(ExampleInput exampleInput) {

		List<BetOffer> betOffers1 = exampleInput.getBookies().get(0).getBetOffers();
		List<BetOffer> betOffers2 = exampleInput.getBookies().get(1).getBetOffers();
		List<Match> matches = new ArrayList<Match>();

		calculatedProfit = exampleInput.getDesiredProfit();

		for (int i = 0; i < betOffers1.size(); i++) {
			for (int j = 0; j < betOffers2.size(); j++) {
				if (betOffers1.get(i).getId().equals(betOffers2.get(j).getId())) {
					boolean matcOdd = goodMatch(betOffers1.get(i).getOddsHome(), betOffers2.get(j).getOddsAway());
					boolean matcOdd2 = goodMatch(betOffers1.get(i).getOddsAway(), betOffers2.get(j).getOddsHome());
					if (matcOdd) {

						PlacedBet placedBet1 = new PlacedBet();
						PlacedBet placedBet2 = new PlacedBet();

						double p1 = 1 / betOffers1.get(i).getOddsHome();
						double p2 = 1 / betOffers2.get(j).getOddsAway();
						double bet1 = (exampleInput.getBudget() * p1) / (p1 + p2);
						double bet2 = (exampleInput.getBudget() * p2) / (p1 + p2);

						if (exampleInput.getDesiredProfit() > bet1 * betOffers1.get(i).getOddsHome()) {
							System.out.println("Non reachable profit1");
							//return null;
						}

						placedBet1.setBookieId(exampleInput.getBookies().get(0).getId());
						// placedBet1.setBetHome(betOffers1.get(i).getOddsHome());
						placedBet1.setBetHome(bet1);

						placedBet2.setBookieId(exampleInput.getBookies().get(1).getId());
						// placedBet2.setBetAway(betOffers2.get(j).getOddsAway());
						placedBet2.setBetAway(bet2);

						List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
						placedBets.add(placedBet1);
						placedBets.add(placedBet2);

						Match match = new Match();

						match.setId(betOffers1.get(i).getId());
						match.setName(betOffers1.get(i).getName());
						match.setPlacedBets(placedBets);

						if (betOffers1.get(i).getMaxBet() > bet1 && betOffers1.get(i).getMaxBet()> bet2) {
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
							System.out.println("Non reachable profit2");
							//return null;
						}

						placedBet1.setBookieId(exampleInput.getBookies().get(0).getId());
						// placedBet1.setBetAway(betOffers1.get(i).getOddsAway());
						placedBet1.setBetAway(bet1);

						placedBet2.setBookieId(exampleInput.getBookies().get(1).getId());
						// placedBet2.setBetHome(betOffers2.get(j).getOddsHome());
						placedBet2.setBetAway(bet2);

						List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
						placedBets.add(placedBet1);
						placedBets.add(placedBet2);

						Match match = new Match();

						match.setId(betOffers1.get(i).getId());
						match.setName(betOffers1.get(i).getName());
						match.setPlacedBets(placedBets);

						matches.add(match);

					}
				}
			}
		}

		return matches;

	}

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

	public ExampleOut findExampleOut(String path) {

		ExampleInput exampleInput = findAll(path);

		if (exampleInput.getBookies().size() < 2) {
			return null;
		} else {
			List<Match> matches = findMatches(exampleInput);
			ExampleOut exampleOut = new ExampleOut();
			exampleOut.setCalculatedProfit(calculatedProfit);
			exampleOut.setMatches(matches);

			return exampleOut;
		}
	}

	/*
	 * public ExampleInput findAll(String filePath) {
	 * 
	 * ObjectMapper mapper = new ObjectMapper(); ExampleInput inputObject =
	 * null;
	 * 
	 * try {
	 * 
	 * // Convert JSON string from file to Object //inputObject =
	 * mapper.readValue(new
	 * File("D:\\JovanVukovic\\praksa\\zadatak-b\\test1-happy-flowBadFIle.json")
	 * , ExampleInput.class); inputObject = mapper.readValue(new File(filePath),
	 * ExampleInput.class);
	 * 
	 * // Convert JSON string to Object //String jsonInString =
	 * "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
	 * //ExampleInput staff1 = mapper.readValue(jsonInString,
	 * ExampleInput.class); //System.out.println(staff1);
	 * 
	 * //Pretty print //String prettyStaff1 =
	 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
	 * //System.out.println(prettyStaff1);
	 * 
	 * } catch (JsonGenerationException e) { e.printStackTrace(); } catch
	 * (JsonMappingException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * return inputObject; }
	 */
}
