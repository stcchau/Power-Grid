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
	
	public final String CITY_NAME;
	
	private final int STEP_1_PRICE = 10;
	private final int STEP_2_PRICE = 15;
	private final int STEP_3_PRICE = 20;
	
	private boolean step1vacant = true;
	private boolean step2vacant = true;
	private boolean step3vacant = true;
	
	private City[] connections;
	private int[] tolls;
	
	public City(String name) {
		CITY_NAME = name;
	}
	
	public void connectCities(City[] c, int[] t) {
		connections = c;
		tolls = t;
	}
	
	public City[] getConnections() {
		return connections;
	}
	
	public int getTollTo(City c) {
		int toll = 0;
		for(int i = 0; i < tolls.length; i++) {
			if(connections[i] == c) {
				toll = tolls[i];
			}
		}
		return toll;
	}
	
	public boolean isVacant(int num) {
		switch(num) {
			case 1:
				return step1vacant;
			case 2:
				return step2vacant;
			default:
				return step3vacant;
		}
	}
	
	public void setToOwned(int num) {
		switch(num) {
			case 1:
				step1vacant = false;
				break;
			case 2:
				step2vacant = false;
				break;
			case 3:
				step3vacant = false;
				break;
		}
	}
	
	public boolean isOwned(int step) {
		switch(step) {
			case 1:
				return step1vacant;
			case 2:
				return step2vacant;
			default:
				return step3vacant;
		}
	}
	
	public int getPrice(int num) {
		switch(num) {
			case 1:
				return STEP_1_PRICE;
			case 2:
				return STEP_2_PRICE;
			default:
				return STEP_3_PRICE;
		}
	}
	
	public void displayInfo() {
		System.out.printf("City: %s\nStep 1 Vacancy: %s\nStep 2 Vacancy: %s\nStep 3 Vacancy: %s", CITY_NAME, step1vacant, step2vacant, step3vacant);
	}
}
