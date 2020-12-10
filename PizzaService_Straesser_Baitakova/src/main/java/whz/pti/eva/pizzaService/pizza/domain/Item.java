package whz.pti.eva.pizzaService.pizza.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import whz.pti.eva.pizzaService.common.BaseEntity;

@Entity
public class Item extends BaseEntity<Long>{

	private int quantity;
	
	@ManyToOne	
	private Pizza pizza;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	
	public Item() {}

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
	
	public BigDecimal getPrice() {
		if(size == PizzaSize.SMALL) {
			return pizza.getPriceSmall().multiply(BigDecimal.valueOf(quantity)); 
		}
		else if(size == PizzaSize.MEDIUM) {
			return pizza.getPriceMedium().multiply(BigDecimal.valueOf(quantity)); 
		}
		return pizza.getPriceLarge().multiply(BigDecimal.valueOf(quantity));
	}
}
