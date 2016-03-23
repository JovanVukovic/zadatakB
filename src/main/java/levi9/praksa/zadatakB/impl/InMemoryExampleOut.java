package levi9.praksa.zadatakB.impl;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import levi9.praksa.zadatakB.model.ErrorJSON;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.service.ExampleOutService;

public class InMemoryExampleOut implements ExampleOutService {

	public boolean writeAll(ExampleOut exampleOut, String path) {
		ObjectMapper mapper = new ObjectMapper();

		ExampleOut staff = exampleOut;

		try {
			mapper.setSerializationInclusion(Include.NON_NULL);
			// Convert object to JSON string and save into a file directly
			if (path == null)
				mapper.writeValue(new File("D:\\out.json"), staff);
			else
				mapper.writeValue(new File(path), staff);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public String writeNoMach(String noMatch) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.setSerializationInclusion(Include.NON_NULL);
			// Convert object to JSON string and save into a file directly

			mapper.writeValue(new File("D:\\out.json"), noMatch);

			// Convert object to JSON string
			// String jsonInString = mapper.writeValueAsString(staff);
			// System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			// jsonInString =
			// mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			// System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public boolean writeError(ErrorJSON error, String outFile){
		
		ObjectMapper mapper = new ObjectMapper();		
		ErrorJSON errorJson = error;

		try {
			mapper.setSerializationInclusion(Include.NON_NULL);
			// Convert object to JSON string and save into a file directly
			if (errorJson != null) {
				if (outFile != null) {
					mapper.writeValue(new File(outFile), errorJson);
				} else {
					mapper.writeValue(new File("D:\\out.json"), errorJson);
				}
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}

	public ExampleOut writeAll(ExampleOut eOut, ErrorJSON error, String outFile) {

		ObjectMapper mapper = new ObjectMapper();

		ExampleOut staff = eOut;
		ErrorJSON errorJson = error;

		try {
			mapper.setSerializationInclusion(Include.NON_NULL);
			// Convert object to JSON string and save into a file directly
			if (errorJson != null) {
				if (outFile != null) {
					mapper.writeValue(new File(outFile), errorJson);
				} else {
					mapper.writeValue(new File("D:\\out.json"), errorJson);
				}
			} else {
				if (outFile != null) {
					mapper.writeValue(new File(outFile), staff);
				} else {
					mapper.writeValue(new File("D:\\out.json"), staff);
				}

			}

			// Convert object to JSON string
			// String jsonInString = mapper.writeValueAsString(staff);
			// System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			// jsonInString =
			// mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			// System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*private ExampleOut createDummyObject() {

		BetOffer betOfer = new BetOffer("01", "Djokas-Raonic", new Double("1.3"), new Double("3.2"),
				new Double("1000.00"));
		BetOffer betOfer2 = new BetOffer("02", "Nadal-Federer", new Double("1.3"), new Double("3.2"),
				new Double("1000.00"));

		List<BetOffer> betOffers = new ArrayList<BetOffer>();
		betOffers.add(betOfer);
		betOffers.add(betOfer2);

		List<BetOffer> betOffers2 = new ArrayList<BetOffer>();
		betOffers2.add(betOfer);
		betOffers2.add(betOfer2);

		ExampleOut out = new ExampleOut();
		out.setCalculatedProfit(new Double("5000.00"));

		Booky booky = new Booky();
		booky.setId("BK6");
		booky.setName("BookeJovan");
		booky.setBetOffers(betOffers);

		Booky booky2 = new Booky();
		booky2.setId("BK26");
		booky2.setName("B2Jovan");

		PlacedBet placedBet = new PlacedBet();
		placedBet.setBookieId(booky.getId());
		placedBet.setBetHome(betOfer.getOddsHome());

		PlacedBet placedBet2 = new PlacedBet();
		placedBet2.setBookieId(booky2.getId());
		placedBet2.setBetAway(betOfer2.getOddsAway());

		List<PlacedBet> placedBets = new ArrayList<PlacedBet>();
		placedBets.add(placedBet);
		placedBets.add(placedBet2);

		Match match = new Match();
		match.setId(betOfer.getId());
		match.setName(betOfer.getName());
		match.setPlacedBets(placedBets);
		List<Match> matches = new ArrayList<Match>();
		matches.add(match);
		out.setMatches(matches);

		return out;

	}*/

}
