package whz.pti.eva.pizzaService.pizza.domain;

public class OderedItem {

	private long pizzaId;
	private String name;
	private int quantity;
	private String userId;
	
	public OderedItem(long pizzaId, String pizzaName, int quantity, String userId) {
		this.pizzaId =  pizzaId;
		this.name = pizzaName;
		this.quantity = quantity;
		this.userId =  userId;
	}
	public long getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
