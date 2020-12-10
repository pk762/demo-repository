package whz.pti.eva.pizzaService.security.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findOneByLoginName(String loginName);
    boolean existsByLoginName(String loginName);
    List<Customer>findAllByOrderByLastNameAsc();
}
