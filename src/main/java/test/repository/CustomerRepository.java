package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.entity.Customer;
import test.entity.PawnData;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
