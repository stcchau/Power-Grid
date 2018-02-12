/**
 * Please do not steal.
 */
package game;

/**
 * @author San Chau
 *
 */
public class DeterminePlayerOrder {
	
	public static void determinePlayerOrder(Player[] playerList) {
	    for(int i = 0; i < playerList.length; i++) {
	        for(int j = 0; i < playerList.length; i++) {
	            if(playerList[i].getHouses() > playerList[j].getHouses()) {
	                Player temp = playerList[i];
	                playerList[i] = playerList[j];
	                playerList[j] = temp;
	            }
	            if(playerList[i].getHouses() == playerList[j].getHouses()) {
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
}
