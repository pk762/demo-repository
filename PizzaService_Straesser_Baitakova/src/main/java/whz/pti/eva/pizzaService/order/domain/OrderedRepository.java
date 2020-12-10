package whz.pti.eva.pizzaService.order.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<Ordered, Long> {
	Optional<List<Ordered>> findAllByUserId(Long userId);
	}
