package application;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class locationTester {

	@Test
	void getLocationCandidatesTest() {
		Location lone = new Location();
		Location ltwo = new Location();
		Location lthree = new Location();
		Location lfour = new Location();
		Location lfive = new Location();
		
		HashMap<Integer, String> answer1 = lone.getLocationCandidates("11787");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Integer, String> answer2 = ltwo.getLocationCandidates("Empire State Building");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Integer, String> answer3 = lthree.getLocationCandidates("1600 Pennsylvania Ave NW");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Integer, String> answer4 = lfour.getLocationCandidates("Denver, CO");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Integer, String> answer5 =  lfive.getLocationCandidates("");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(5, answer1.size());
		assertEquals(2, answer2.size());
		assertEquals(10, answer3.size());
		assertEquals(4, answer4.size());
		assertEquals(null, answer5);
		
		lone.parseAddress(2);
		ltwo.parseAddress(1);
		lthree.parseAddress(4);
		lfour.parseAddress(2);
		
		assertEquals("Hauppauge, Hauppauge, Suffolk County, New York, 11787, USA", lone.getDisplayName());
		assertEquals("40.843", lone.getLatitude());
		assertEquals("-73.20", lone.getLongitude());
		assertEquals("Empire State Building, 350, 5th Avenue, Korea Town, Manhattan, New York, New York County, New York, 10001, USA", ltwo.getDisplayName());
		assertEquals("-73.98", ltwo.getLongitude());
		assertEquals("40.748", ltwo.getLatitude());
		assertEquals("Pennsylvania Avenue Northwest, West End, Penn Quarter, Washington D.C., Washington, Washington, D.C., 20037, USA", lthree.getDisplayName());
		assertEquals("38.902", lthree.getLatitude());
		assertEquals("-77.05", lthree.getLongitude());
		assertEquals("Denver County, Colorado, USA", lfour.getDisplayName());
		assertEquals("-104.9", lfour.getLongitude());
		assertEquals("39.734", lfour.getLatitude());
		
		
	}


}
