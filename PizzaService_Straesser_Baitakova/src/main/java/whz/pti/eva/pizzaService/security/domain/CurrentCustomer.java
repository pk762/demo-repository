package whz.pti.eva.pizzaService.security.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


public class CurrentCustomer extends User{

	private Customer customer;
	
	public CurrentCustomer(Customer customer) {
		super(customer.getLoginName(), customer.getPasswordHash(), AuthorityUtils.createAuthorityList(customer.getRole().toString()));
		this.customer = customer;
	}
	
    public Customer getUser() {
        return customer;
    }

    public Long getId() {
        return customer.getId();
    }

    public String getLoginName() {
        return customer.getLoginName();
    }

    public Role getRole() {
    	return customer.getRole();
    }
    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + customer +
                "} " + super.toString();
    }
}
