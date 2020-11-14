package whz.pti.eva.pizzaService.pizza.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderedItem {

	@Id @GeneratedValue
	private Long id; 
	
	private long pizzaId;
	private String name;
	private int quantity;
	private String userId;
	
	private PizzaSize size;
	
	public OrderedItem(long pizzaId, String pizzaName, int quantity, String userId, PizzaSize size) {
		this.pizzaId =  pizzaId;
		this.name = pizzaName;
		this.quantity = quantity;
		this.userId =  userId;
		this.size = size; 
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
