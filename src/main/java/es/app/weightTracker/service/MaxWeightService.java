package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import es.app.weightTracker.entity.MaxWeight;

public interface MaxWeightService {
	
	Optional<List<MaxWeight>> findAllMaxWeightByUserId(Long userId);
	
	Optional<MaxWeight> findMaxWeightById(Long id);
	
	void createMaxWeight(MaxWeight maxWeight);
	
	void updateMaxWeight(MaxWeight maxWeight);

}
