package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.entity.PawnData;

@Repository
public interface PawnDataRepository extends JpaRepository<PawnData, Long> {
}
