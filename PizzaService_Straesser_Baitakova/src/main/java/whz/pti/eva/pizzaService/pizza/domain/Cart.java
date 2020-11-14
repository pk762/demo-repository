package whz.pti.eva.pizzaService.pizza.domain;

public class Cart {

	private int quantity;
	private String userId;
	
	public Cart() {
		
	}
	
	public Cart(String userId, int quantitiy) {
		this.userId = userId;
		this.quantity = quantitiy;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
