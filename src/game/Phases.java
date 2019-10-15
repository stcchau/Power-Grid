/**
 * Please do not steal.
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author San Chau
 *
 */
public class Phases {
	
	public static Player[] playerList;
	public static ResourceMarket rMarket;
	public static Board board = new Board();
	public static PowerPlantMarket ppMarket = new PowerPlantMarket();
	public static int step = 1;
	
	public static void phase1(Player[] playerList) {
	    for(int i = 0; i < playerList.length; i++) {
	        for(int j = 0; j < playerList.length; j++) {
	            if(playerList[i].getHouses() > playerList[j].getHouses()) {
	                Player temp = playerList[i];
	                playerList[i] = playerList[j];
	                playerList[j] = temp;
	            }
	            else if(playerList[i].getHouses() == playerList[j].getHouses()) {
	                try {
	                    if(playerList[i].cards[0].getMinPrice() > playerList[j].cards[0].getMinPrice()) {
	                        Player temp = playerList[i];
	                        playerList[i] = playerList[j];
	                        playerList[j] = temp;
	                    }
	                }
	                catch(Exception e) {
	                }
	            }
	        }
	    }
	}
	
	public static void phase2() {
		ArrayList<Player> inAuction = new ArrayList<Player>(Arrays.asList(playerList));
		while(!inAuction.isEmpty()) {
			
		}
	}
	
	public static void phase3() {
		for(Player player : playerList) {
			
		}
	}
	
	public static void main(String[] args) {
		Player san = new Player("San");
		Player adithyan = new Player("Adithyan");
		Player abel = new Player("Abel");
		Player tarana = new Player("Tarana");
		playerList = new Player[4];
		playerList[0] = abel;
		playerList[1] = adithyan;
		playerList[2] = san;
		playerList[3] = tarana;
		ResourceMarket rMarket = new ResourceMarket(playerList);
		ppMarket.displayInfo();
	}
}
