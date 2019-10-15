/**
 * Please do not steal.
 */
package game;

import java.util.ArrayList;

/**
 * @author San Chau
 *
 */
public class Player {
	
	//player's name
	public final String PLAYER_NAME;
	
	//array of cards that player currently possesses
	public PowerPlantCard[] cards = {new PowerPlantCard(0,0,0,0), new PowerPlantCard(0,0,0,0), new PowerPlantCard(0,0,0,0)};
	
	//player's network of connected houses
	private ArrayList<City> network = new ArrayList<City>();
	
	//player's available cities to own given current network
	private ArrayList<City> buyableCities = new ArrayList<City>();
	
	//player's currency
	private int electros = 50;
	
	//player's max capacity of coal, oil, garbage, uranium, and hybrid
	private int[] coguMax = {0,0,0,0,0};
	
	//player's current amount of coal, oil, garbage, and uranium
	private int[] playerResources = {0,0,0,0};
	
	public Player(String name) {
		PLAYER_NAME = name;
	}
	
	public int getHouses() {
		return network.size();
	}
	
	public int getElectros() {
		return electros;
	}
	
	public int getPlayerResources(int i) {
		return playerResources[i];
	}
	
	//decreases player's electros and increases player resources
	public void rBuy(int rType, int rAmount) {
		if(ResourceMarket.getRCost(rType, rAmount) <= electros && rAmount <= ResourceMarket.marketStock[rType] && rAmount <= coguMax[rType]) {
			electros -= ResourceMarket.getRCost(rType, rAmount);
			playerResources[rType] += rAmount;
		}
	}
	
	//buys power plants***NOT DONE***
	public void ppBuy(PowerPlantCard card, int cost) {
		if(cards[2].getMinPrice() == 0) {
			//will ask for what card to replace and trash
			int trash = 0;//not done
			cards[trash] = card;
		}
		else {
			for(int i = 0; i < 3; i++) {
				if(cards[i].getMinPrice() == 0) {
					cards[i] = card;
					break;
				}
			}
		}
		for(int i = 0; i < cards.length; i++) {
			for(int j = 0; j < cards.length; j++){
				if(cards[i].getMinPrice() > cards[j].getMinPrice()) {
					PowerPlantCard temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}
	}
	
	//adds cities to network***NOT DONE***
	public void addCity(City oldCity, City newCity) {
		if(Board.getCityCost(oldCity, newCity) <= electros && isBuyable(newCity)) {
			electros -= Board.getCityCost(oldCity, newCity);
			network.add(newCity);
			for(int i = 0; i < network.size(); i++) {
				for(int j = 0; j < newCity.getConnections().length; j++) {
					if(newCity.getConnections()[j] != network.get(i)) {
						for(int k = 1; k < 4; k++) {
							if(!newCity.getConnections()[j].isOwned(k)) {
								buyableCities.add(newCity.getConnections()[j]);
							}
						}
					}
				}
			}
		}
	}
	
	//determines whether the city is in reach and can be bought***NOT DONE***
	public boolean isBuyable(City c) {
		return true;
	}
	
	//displays player info
	public void displayInfo() {
		System.out.printf("Player: %s\nElectros: %d\nHouses: %d\nResources:\nCoal: %d\tOil: %d\tGarbage: %d\tUranium: %d\nCard 1 Price: %d\nCard 2 Price: %d\nCard 3 Price: %d\n", PLAYER_NAME, electros, getHouses(), playerResources[0], playerResources[1], playerResources[2], playerResources[3], cards[0].getMinPrice(), cards[1].getMinPrice(), cards[2].getMinPrice());
	}
}
