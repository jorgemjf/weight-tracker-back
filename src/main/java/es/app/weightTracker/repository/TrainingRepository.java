package es.app.weightTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.app.weightTracker.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
	
	Optional<List<Training>> findByUserId(Long userId);

}
