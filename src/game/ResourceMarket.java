/**
 * Please do not steal.
 */
package game;

/**
 * @author San Chau
 *
 */
public class ResourceMarket {
	
	private static int numPlayers;
	private static Player[] playerList;
	public static int[] marketStock = {24,18,6,2};
	
	//max stock of coal, oil, and garbage
	private final static int cogMaxStock = 24;
	
	//max stock of uranium
	private final static int uMaxStock = 12;
	
	//price of coal, oil, and garbage depending on stock
	private final static int[] cogPrice = {8,7,6,5,4,3,2,1};
	
	//price of uranium depending on stock
	private final static int[] uPrice = {16,14,12,10,8,7,6,5,4,3,2,1};
	
	//3d array of replenishing values that vary depending on # of players and current step #
	private final static int[][][] coguReplen = {
			{{3,4,3},{4,5,3},{5,6,4},{5,7,5},{7,9,6}}, 
			{{2,2,4},{2,3,4},{3,4,5},{4,5,6},{5,6,7}}, 
			{{1,2,3},{1,2,3},{2,3,4},{3,3,5},{3,5,6}}, 
			{{1,1,1},{1,1,1},{1,2,2},{2,3,2},{2,3,3}}};
	
	public ResourceMarket(Player[] playerList) {
		this.playerList = playerList;
		this.numPlayers = playerList.length;
	}
	
	//replenishes resources depending on # of players and current step #
	public static void replenish(int step) {
		step -= 1;
		int[] playercogu = {0,0,0,0};
		for(Player player : playerList) {
			playercogu[0] += player.getPlayerResources(0);
			playercogu[1] += player.getPlayerResources(1);
			playercogu[2] += player.getPlayerResources(2);
			playercogu[3] += player.getPlayerResources(3);
		}
		for(int i = 0; i < 4; i++) {
			if(i == 3 && marketStock[i] + playercogu[i] + coguReplen[i][numPlayers][step] > uMaxStock)
				marketStock[i] += uMaxStock - marketStock[i] + playercogu[i];
			if(marketStock[i] + playercogu[i] + coguReplen[i][numPlayers][step] > cogMaxStock)
				marketStock[i] += cogMaxStock - marketStock[i] + playercogu[i];
			else
				marketStock[i] += coguReplen[i][numPlayers][step];
		}
	}
	
	//decreases resource stock and uses recursion to calculate resource cost
	public static int rCost(int rType, int rAmount) {
		if(rAmount > 0) {
			marketStock[rType] -= 1;
			rAmount -= 1;
			if(rType == 3)
				return uPrice[marketStock[rType]] + rCost(rType, rAmount);
			else
				return cogPrice[marketStock[rType] / 3] + rCost(rType, rAmount);
		}
		return 0;
	}
}
