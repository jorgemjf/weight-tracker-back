package es.app.weightTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.app.weightTracker.entity.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
	
	Optional<List<Tracking>> findByUserId(Long userId);

}
