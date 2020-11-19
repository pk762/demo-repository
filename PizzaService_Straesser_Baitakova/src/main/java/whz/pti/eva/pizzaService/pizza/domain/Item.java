package whz.pti.eva.pizzaService.pizza.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	private String itemId; 
	private int quantity;
	
	@ManyToOne	
	private Pizza pizza;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	
	public Item() {}
	
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


	public Pizza getPizza() {
		return pizza;
	}


	public Item withPizza(Pizza pizza) {
		this.pizza = pizza;
		return this;
	}


	public PizzaSize getSize() {
		return size;
	}


	public void setSize(PizzaSize size) {
		this.size = size;
	}
}
