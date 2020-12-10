package whz.pti.eva.pizzaService.order.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import whz.pti.eva.pizzaService.common.BaseEntity;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

@Entity
public class OrderedItem extends BaseEntity<UUID>{

	private Long pizzaId;
	private String name;
	private int quantity;
	private Long userId;
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	
	public OrderedItem() {
		 
	}
	public Long getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Long pizzaId) {
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setSize(PizzaSize size) {
		this.size = size;
	}

	public PizzaSize getSize() {
		return size;
	}
}
