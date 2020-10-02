package es.app.weightTracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.app.weightTracker.dto.TrainingDto;
import es.app.weightTracker.entity.Training;
import es.app.weightTracker.service.TrainingService;
import es.app.weightTracker.util.ManagerException;
import es.app.weightTracker.util.Transformation;

@RestController
@RequestMapping(value = "/training")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingController {
	
	@Autowired
	TrainingService trainingService;
	
	@Autowired
	private ManagerException managerException;

	@Autowired
	private Transformation transform;
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> getAllTrainingsByUser(@PathVariable(value = "id") Long userId) {

		List<TrainingDto> trainingDto = null;

		try {

			Optional<List<Training>> trainings = trainingService.findAllTrainingByUserId(userId);

			if (trainings.isPresent()) {
				trainingDto = transform.listTrainingrEntity_trainingDto(trainings.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(trainingDto);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getTraining(@PathVariable(value = "id") Long id) {

		TrainingDto trainingDto = null;

		try {

			Optional<Training> training = trainingService.findTrainingById(id);

			if (training.isPresent()) {
				trainingDto = transform.trainingEntity_trainingDto(training.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(trainingDto);
	}
	
	@PostMapping("")
	ResponseEntity<?> createTraining(@RequestBody TrainingDto trainingDto) {

		try {

			trainingService.createTraining(transform.trainingDto_trainingEntity(trainingDto));;

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}
	
	@PutMapping(value = "/{id}")
	ResponseEntity<?> updateTraining(
			@RequestBody Training training,
			@PathVariable(value = "id") Long id) {
		
		Training t = new Training();
		t.setId(id);
		t.setMinutesWod(training.getMinutesWod());
		t.setTypeWod(training.getTypeWod());
		t.setTimes(training.getTimes());
		t.setWod(training.getWod());
		t.setDate(training.getDate());
		t.setAdditionalWod(training.getAdditionalWod());
		
		

		try {

			trainingService.updateTraining(t);

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}

}
