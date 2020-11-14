package whz.pti.eva.pizzaService.pizza.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	private String itemId; 
	private int quantity;
	
	@OneToMany
	
	private List<Pizza> pizza;
	private PizzaSize size;
	
	public Item() {
		
	}
		
	public Item(String itemId, int quantity, List<Pizza> pizza, PizzaSize size) {
		this.itemId = itemId;
		this.quantity = quantity;
		this.pizza = pizza;
		this.size = size;
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


	public List<Pizza> getPizza() {
		return pizza;
	}


	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}


	public PizzaSize getSize() {
		return size;
	}


	public void setSize(PizzaSize size) {
		this.size = size;
	}
	
	
}
