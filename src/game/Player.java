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
	public String name;
	
	//array of cards that player currently possesses
	public PowerPlantCard[] cards = new PowerPlantCard[3];
	
	//player's network of connected houses
	private ArrayList<City> network = new ArrayList<City>();
	
	//player's currency
	private int electros = 50;
	
	//player's max capacity of coal, oil, garbage, uranium, and hybrid
	private int[] coguMax = {0,0,0,0,0};
	
	//player's current amount of coal, oil, garbage, and uranium
	private int[] playerResources = {0,0,0,0};
	
	public Player(String name) {
		this.name = name;
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
		electros -= ResourceMarket.rCost(rType, rAmount);
		playerResources[rType] += rAmount;
	}
	
	//buys power plants***NOT DONE***
	public void ppBuy(PowerPlantCard card, int amount) {
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
		electros -= Board.cityCost(oldCity, newCity);
		network.add(newCity);
	}
}
