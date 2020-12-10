package whz.pti.eva.pizzaService.pizza.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

	Optional<Pizza> findByPizzaName(String name);
	
}
