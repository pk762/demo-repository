package whz.pti.eva.pizzaService.config;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.cart.domain.CartRepository;
import whz.pti.eva.pizzaService.order.domain.OrderedItemRepository;
import whz.pti.eva.pizzaService.order.domain.OrderedRepository;
import whz.pti.eva.pizzaService.pizza.domain.ItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;
import whz.pti.eva.pizzaService.security.domain.Role;
import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.domain.CustomerRepository;
@Component
public class InitializeDB {

	@Autowired
	PizzaRepository pizzaRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderedRepository orderedRepo;
	
	@Autowired
	OrderedItemRepository orderedItemRepo;
	
	@Autowired
	CustomerRepository userRepository;
	
	@PostConstruct
	private void init() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		Customer user = new Customer();
        user.setFirstName("foo");
        user.setLastName("bar");
        user.setLoginName("admin");
        user.setPasswordHash(passwordEncoder.encode("a1"));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
        Cart cartA = new Cart(user);
        cartRepo.save(cartA);
        
        Customer userBnutz = new Customer();
        userBnutz.setFirstName("B");
        userBnutz.setLastName("Nutz");
        userBnutz.setLoginName("bnutz");
        userBnutz.setPasswordHash(passwordEncoder.encode("n1"));
        userBnutz.setRole(Role.USER);
        userRepository.save(userBnutz);
        Cart cartB = new Cart(userBnutz);
        cartRepo.save(cartB);
       
        Customer userCnutz = new Customer();
        userCnutz.setFirstName("C");
        userCnutz.setLastName("Nutz");
        userCnutz.setLoginName("cnutz");
        userCnutz.setPasswordHash(passwordEncoder.encode("n2"));
        userCnutz.setRole(Role.USER);
        userRepository.save(userCnutz);
        Cart cartC = new Cart(userCnutz);
        cartRepo.save(cartC);
        
		Pizza pizza1 = new Pizza("Margherita", new BigDecimal(20), new BigDecimal(15), new BigDecimal(5));
		pizzaRepo.save(pizza1);
		Pizza pizza2 = new Pizza("Tonno", new BigDecimal(17), new BigDecimal(12), new BigDecimal(3));
		pizzaRepo.save(pizza2);
		Pizza pizza3 = new Pizza("Napoli", new BigDecimal(22), new BigDecimal(17), new BigDecimal(6));
		pizzaRepo.save(pizza3);
	}
}
