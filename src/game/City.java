/**
 * Please do not steal.
 */
package game;

import java.util.ArrayList;

/**
 * @author San Chau
 *
 */
public class City {
	
	private final int step1price = 10;
	private final int step2price = 15;
	private final int step3price = 20;
	
	private boolean step1owned = false;
	private boolean step2owned = false;
	private boolean step3owned = false;
	
	private ArrayList<City> connections = new ArrayList<City>();
	private ArrayList<Integer> tolls = new ArrayList<Integer>();
	
	public void connectCities(City[] c, int[] t) {
		for(int i = 0; i < c.length; i++) {
			connections.add(c[i]);
			tolls.add(t[i]);
		}
	}
	
	public int getToll(City c) {
		int toll = tolls.get(connections.indexOf(c));
		return toll;
	}
	
	public boolean isOwned(int num) {
		switch(num) {
			case 1:
				return step1owned;
			case 2:
				return step2owned;
			default:
				return step3owned;
		}
	}
	
	public void setToOwned(int num) {
		switch(num) {
			case 1:
				step1owned = true;
				break;
			case 2:
				step2owned = true;
				break;
			case 3:
				step3owned = true;
				break;
		}
	}
	
	public int getPrice(int num) {
		switch(num) {
			case 1:
				return step1price;
			case 2:
				return step2price;
			default:
				return step3price;
		}
	}
}
