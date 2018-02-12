/**
 * Please do not steal.
 */
package game;

/**
 * @author San Chau
 *
 */
public class PowerPlantCard {
	
	private final int minPrice;
	private final int cardType;
	private final int rUsage;
	private final int power;
	
	public PowerPlantCard(int minPrice, int cardType, int rUsage, int power) {
		this.minPrice = minPrice;
		this.cardType = cardType;
		this.rUsage = rUsage;
		this.power = power;
	}
	
	public int getMinPrice() {
		return minPrice;
	}
	
	public int getCardType() {
		return cardType;
	}
	
	public int getRUsage() {
		return rUsage;
	}
	
	public int getPower() {
		return power;
	}
}
