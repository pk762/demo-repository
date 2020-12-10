package whz.pti.eva.pizzaService.cart.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import whz.pti.eva.pizzaService.common.BaseEntity;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.security.domain.Customer;

@Entity
public class Cart extends BaseEntity<Long> {
	   
	private int quantity;
	private Long userId;
	
	@OneToMany(mappedBy= "itemId", cascade = CascadeType.ALL)
	private List<Item> items;
	
	@OneToOne
	private Customer customer;
	
	public Cart() {
		items = new ArrayList<Item>();
	}
	
	public Cart(Customer customer) {
		items = new ArrayList<Item>();
		this.customer = customer;
		setUserId(customer.getId());
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userID) {
		this.userId = userID;
	}

	public Cart addItem(Item item) {
		this.items.add(item);
		System.out.println("ADD: " + items);
		return this;
	}
	
	public List<Item> getItemList(){
		System.out.println("GET: " + items);
		return items;
	}
}
