package pawnshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawnshop.entity.DeliveryData;

@Repository
public interface DeliveryDataRepository extends JpaRepository<DeliveryData, Long> {
}
