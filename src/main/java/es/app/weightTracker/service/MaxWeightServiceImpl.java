package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.app.weightTracker.entity.MaxWeight;
import es.app.weightTracker.repository.MaxWeightRepository;

@Service
public class MaxWeightServiceImpl implements MaxWeightService{
	
	@Autowired
	MaxWeightRepository maxWeightRepo;

	@Override
	public Optional<List<MaxWeight>> findAllMaxWeightByUserId(Long userId) {
		return maxWeightRepo.findByUserId(userId);
	}

	@Override
	public Optional<MaxWeight> findMaxWeightById(Long id) {
		return maxWeightRepo.findById(id);
	}

	@Override
	public void createMaxWeight(MaxWeight maxWeight) {
		maxWeightRepo.save(maxWeight);
		
	}

	@Override
	public void updateMaxWeight(MaxWeight maxWeight) {
		MaxWeight m = maxWeightRepo.getOne(maxWeight.getId());
		if (maxWeight.getExercice() != null) {
			m.setExercice(maxWeight.getExercice());
		}
		if (maxWeight.getWeight() != null) {
			m.setWeight(maxWeight.getWeight());
		}
		if (maxWeight.getDate() != null) {
			m.setDate(maxWeight.getDate());
		}
		
		maxWeightRepo.save(m);		
	}

}
