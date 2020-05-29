package pawnshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pawnshop.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Find the customer by email
     *
     * @param email the emial of the customer
     * @return the customer
     */
    @Query("SELECT c FROM Customer c WHERE c.email=?1")
    Customer findByEmail(String email);
}
