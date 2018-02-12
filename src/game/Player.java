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
	
	public String name;
	public PowerPlantCard[] cards = new PowerPlantCard[3]; //max # of cards player can possess
	private ArrayList<City> network = new ArrayList<City>(); //player's network of connected houses
	private int electros = 50; //player's currency
	private int[] coguMax = {0,0,0,0,0}; //player's max capacity of coal oil garbage uranium hybrid
	private int[] playerResources = {0,0,0,0}; //player's current resources
	
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
	
	public void rBuy(int rType, int rAmount) { //buys resources
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
