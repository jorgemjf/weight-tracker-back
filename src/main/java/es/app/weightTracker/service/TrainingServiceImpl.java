package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.app.weightTracker.entity.Training;
import es.app.weightTracker.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	TrainingRepository trainingRepo;

	@Override
	public Optional<List<Training>> findAllTrainingByUserId(Long userId) {
		return trainingRepo.findByUserId(userId);
	}

	@Override
	public Optional<Training> findTrainingById(Long id) {
		return trainingRepo.findById(id);
	}

	@Override
	public void createTraining(Training training) {
		trainingRepo.save(training);
	}

	@Override
	public void updateTraining(Training training) {
		Training t = trainingRepo.getOne(training.getId());
		if (training.getMinutesWod() != null) {
			t.setMinutesWod(training.getMinutesWod());
		}
		if (training.getTimes() != null) {
			t.setTimes(training.getTimes());
		}
		if (training.getTypeWod() != null) {
			t.setTypeWod(training.getTypeWod());
		}
		if (training.getWod() != null) {
			t.setWod(training.getWod());
		}
		if (training.getDate() != null) {
			t.setDate(training.getDate());
		}
		if (training.getAdditionalWod() != null) {
			t.setAdditionalWod(training.getAdditionalWod());
		}
		trainingRepo.save(t);
		
	}

}
