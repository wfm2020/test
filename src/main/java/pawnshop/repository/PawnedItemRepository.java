package pawnshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawnshop.entity.PawnedItem;

@Repository
public interface PawnedItemRepository extends JpaRepository<PawnedItem, Long> {
}
