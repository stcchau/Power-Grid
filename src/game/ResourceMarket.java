/**
 * Please do not steal.
 */
package game;

/**
 * @author San Chau
 *
 */
public class ResourceMarket {
	
	private final int NUM_PLAYERS;
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
		NUM_PLAYERS = playerList.length;
	}
	
	//replenishes resources depending on # of players and current step #
	public void replenish(int step) {
		step -= 1;
		int[] playercogu = {0,0,0,0};
		for(Player player : playerList) {
			playercogu[0] += player.getPlayerResources(0);
			playercogu[1] += player.getPlayerResources(1);
			playercogu[2] += player.getPlayerResources(2);
			playercogu[3] += player.getPlayerResources(3);
		}
		for(int i = 0; i < 4; i++) {
			if(i == 3 && marketStock[i] + playercogu[i] + coguReplen[i][NUM_PLAYERS][step] > uMaxStock)
				marketStock[i] += uMaxStock - marketStock[i] + playercogu[i];
			if(i != 3 && marketStock[i] + playercogu[i] + coguReplen[i][NUM_PLAYERS][step] > cogMaxStock)
				marketStock[i] += cogMaxStock - marketStock[i] + playercogu[i];
			else
				marketStock[i] += coguReplen[i][NUM_PLAYERS][step];
		}
	}
	
	//decreases resource stock and uses recursion to calculate resource cost
	public static int getRCost(int rType, int rAmount) {
		int cost = 0;
		int temp = marketStock[rType];
		while(rAmount > 0) {
			temp -= 1;
			rAmount -= 1;
			if(rType == 3)
				cost += uPrice[temp];
			else
				cost += cogPrice[temp / 3];
		}
		return cost;
	}
	
	//add resources to a resource stock
	public static void addResources(int rType, int rAmount) {
		marketStock[rType] += rAmount;
	}
	
	//displays market stock info
	public void displayInfo() {
		System.out.printf("Coal: %d\tOil: %d\t\tGarbage: %d\tUranium: %d\n", marketStock[0], marketStock[1], marketStock[2], marketStock[3]);
	}
}
