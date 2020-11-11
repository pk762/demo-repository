package whz.pti.eva.pizzaService.pizza.domain;

public class Odered {

	private int numberOfItems;
	private String userId;
	
	public Odered (String userId, int number) {
		this.userId = userId;
		this.numberOfItems = number;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
	
}
