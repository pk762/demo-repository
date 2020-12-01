package whz.pti.eva.pizzaService.pizza.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import whz.pti.eva.pizzaService.config.BaseEntity;

@Entity
public class Cart extends BaseEntity<UUID> {
	   
	private int quantity;
	private UUID userId;
	
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
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Cart addItem(Item item) {
		items.add(item);
		return this;
	}
}
