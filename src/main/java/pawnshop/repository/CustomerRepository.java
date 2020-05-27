package pawnshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawnshop.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
