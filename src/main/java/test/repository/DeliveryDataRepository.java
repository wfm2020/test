package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.entity.Customer;
import test.entity.DeliveryData;

@Repository
public interface DeliveryDataRepository extends JpaRepository<DeliveryData, Long> {
}
