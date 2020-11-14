package whz.pti.eva.pizzaService.pizza.domain;

public class Item {

	private String itemId; 
	private int quantity;
	
	public Item() {
		
	}
	
	public Item (String nameId, int quantity) {
		this.setItemId(nameId);
		this.setQuantity(quantity);
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
