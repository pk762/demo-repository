package whz.pti.eva.pizzaService.pizza.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ordered {

	@Id @GeneratedValue
	private Long id; 
	private int numberOfItems;
	private String userId;
	
	@OneToMany
	private List<OrderedItem> orderedItems;

	public Ordered(int numberOfItems, String userId, List<OrderedItem> orderedItems) {

		this.numberOfItems = numberOfItems;
		this.userId = userId;
		this.orderedItems = orderedItems;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public List<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

}
