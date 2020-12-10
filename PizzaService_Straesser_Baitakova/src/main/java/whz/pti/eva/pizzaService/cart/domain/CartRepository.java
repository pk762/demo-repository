package whz.pti.eva.pizzaService.cart.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {
	Optional<Cart> findByUserId(Long userID);
}
