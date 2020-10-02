package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import es.app.weightTracker.entity.Tracking;

public interface TrackingService {
	
	Optional<List<Tracking>> findAllTrackingByUserId(Long userId);
	
	Optional<Tracking> findTrackingById(Long id);
	
	void createTracking(Tracking tracking);
	
	void updateTracking(Tracking tracking);

}
