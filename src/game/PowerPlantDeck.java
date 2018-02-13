/**
 * Please do not steal.
 */
package game;

/**
 * @author San Chau
 *
 */
import java.util.LinkedList;

public class PowerPlantDeck extends LinkedList<PowerPlantCard>{
	
	//creates a linked list of cards
	public PowerPlantDeck() {
		add(new PowerPlantCard(11,4,1,2));
		add(new PowerPlantCard(12,2,2,2));
		add(new PowerPlantCard(14,3,2,2));
		add(new PowerPlantCard(15,0,2,3));
		add(new PowerPlantCard(16,1,2,3));
		add(new PowerPlantCard(17,4,1,2));
		add(new PowerPlantCard(18,5,0,2));
		add(new PowerPlantCard(19,3,2,3));
		add(new PowerPlantCard(20,0,3,5));
		add(new PowerPlantCard(21,2,2,4));
		add(new PowerPlantCard(22,5,0,2));
		add(new PowerPlantCard(23,4,1,3));
		add(new PowerPlantCard(24,3,2,4));
		add(new PowerPlantCard(25,0,2,5));
		add(new PowerPlantCard(26,1,2,5));
		add(new PowerPlantCard(27,5,0,3));
		add(new PowerPlantCard(28,4,1,4));
		add(new PowerPlantCard(29,2,1,4));
		add(new PowerPlantCard(30,3,3,6));
		add(new PowerPlantCard(31,0,3,6));
		add(new PowerPlantCard(32,1,3,6));
		add(new PowerPlantCard(33,5,0,4));
		add(new PowerPlantCard(34,4,1,5));
		add(new PowerPlantCard(35,1,1,5));
		add(new PowerPlantCard(36,0,3,7));
		add(new PowerPlantCard(37,5,0,4));
		add(new PowerPlantCard(38,3,3,7));
		add(new PowerPlantCard(39,4,1,6));
		add(new PowerPlantCard(40,1,2,6));
		add(new PowerPlantCard(42,0,5,6));
		add(new PowerPlantCard(44,5,0,5));
		add(new PowerPlantCard(46,2,3,7));
		add(new PowerPlantCard(50,5,0,6));
		
		//Shuffles deck
		for(int i = 0; i < size(); i++) {
			int r = (int)(Math.random() * 33);
			PowerPlantCard temp = get(r);
			set(r, get(i));
			set(i, temp);
		}
		
		//puts first clean energy card on top
		add(new PowerPlantCard(13,5,0,1));
	}
}
