/**
 * Please do not steal.
 */
package game;

import java.util.ArrayList;

/**
 * @author San Chau
 *
 */
public class PowerPlantMarket extends ArrayList<PowerPlantCard> {
	
	private PowerPlantDeck deck = new PowerPlantDeck();
	
	//initial power plant card market
	public PowerPlantMarket() {
			add(new PowerPlantCard(3,1,2,1));
			add(new PowerPlantCard(4,0,2,1));
			add(new PowerPlantCard(5,2,2,1));
			add(new PowerPlantCard(6,3,1,1));
			add(new PowerPlantCard(7,1,3,2));
			add(new PowerPlantCard(8,0,3,2));
			add(new PowerPlantCard(9,1,1,1));
			add(new PowerPlantCard(10,0,2,2));
	}
	
	//draws top card of deck ***NOT DONE***
	public void draw() {
		add(deck.removeLast());
	}
}