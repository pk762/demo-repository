package whz.pti.eva.pizzaService.pizza.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id @GeneratedValue
	private Long id; 
	
	private int quantity;
	private String userId;
	
	@OneToMany
	private List <Item> items; 
	
//	public Cart() {
//		
//	}
	
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
	


	public void putinCart(Item item) {
		
	}
	public void makeOrder() {
		
	}
}
