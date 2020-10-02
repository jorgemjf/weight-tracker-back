package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import es.app.weightTracker.entity.Training;

public interface TrainingService {
	
	Optional<List<Training>> findAllTrainingByUserId(Long userId);
	
	Optional<Training> findTrainingById(Long id);
	
	void createTraining(Training training);
	
	void updateTraining(Training training);

}
