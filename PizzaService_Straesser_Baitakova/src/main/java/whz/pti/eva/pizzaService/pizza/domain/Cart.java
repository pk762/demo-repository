package whz.pti.eva.pizzaService.pizza.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	private Long id; 
	
	private int quantity;
	private String userId;
	
	@OneToMany
	private List <Item> items; 
	
	public Cart() {
		this.items = new ArrayList<Item>();
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

	public Cart addItem(Item item) {
		items.add(item);
		return this;
	}
}
