package es.app.weightTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.app.weightTracker.entity.MaxWeight;

public interface MaxWeightRepository extends JpaRepository<MaxWeight, Long> {
	
	Optional<List<MaxWeight>> findByUserId(Long userId);

}
