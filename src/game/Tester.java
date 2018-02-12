/**
 * Please do not steal.
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author San Chau
 *
 */
public class Tester {
	
	private static Player[] playerList;
	private static ResourceMarket rMarket;
	private static Board board = new Board();
	private static PowerPlantDeck deck = new PowerPlantDeck();
	private static int step = 1;

	public static void phase1() {
		DeterminePlayerOrder.determinePlayerOrder(playerList);
	}
	
	public static void phase2() {
		ArrayList<Player> inAuction = new ArrayList<Player>(Arrays.asList(playerList));
		ArrayList<Player> outAuction = new ArrayList<Player>();
		while(!inAuction.isEmpty()) {
			
		}
	}
	
	public static void phase3() {
		for(Player player : playerList) {
			player.rBuy(0, 0);
		}
	}
	
	public static void main(String[] args) {
		Player san = new Player("San");
		Player[] playerList = {san};
		ResourceMarket rMarket = new ResourceMarket(playerList);
		san.rBuy(0, 13);
		System.out.println(san.getElectros());
		System.out.println(san.getPlayerResources(0));
		System.out.println(rMarket.marketStock[0]);
	}
}
