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

import es.app.weightTracker.dto.MaxWeightDto;
import es.app.weightTracker.entity.MaxWeight;
import es.app.weightTracker.service.MaxWeightService;
import es.app.weightTracker.util.ManagerException;
import es.app.weightTracker.util.Transformation;

@RestController
@RequestMapping(value = "/maxWeight")
@CrossOrigin(origins = "http://localhost:4200")
public class MaxWeightController {
	
	@Autowired
	MaxWeightService maxWeightService;
	
	@Autowired
	private ManagerException managerException;

	@Autowired
	private Transformation transform;
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> getAllMaxWeightByUser(@PathVariable(value = "id") Long userId) {

		List<MaxWeightDto> maxWeightDto = null;

		try {

			Optional<List<MaxWeight>> maxWeights = maxWeightService.findAllMaxWeightByUserId(userId);

			if (maxWeights.isPresent()) {
				maxWeightDto = transform.listMaxWeightEntity_maxWeightDto(maxWeights.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(maxWeightDto);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getMaxWeight(@PathVariable(value = "id") Long id) {

		MaxWeightDto maxWeightDto = null;

		try {

			Optional<MaxWeight> maxWeight = maxWeightService.findMaxWeightById(id);

			if (maxWeight.isPresent()) {
				maxWeightDto = transform.maxWeightEntity_maxWeightDto(maxWeight.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(maxWeightDto);
	}
	
	@PostMapping("")
	ResponseEntity<?> createMaxWeight(@RequestBody MaxWeightDto maxWeight) {

		try {

			maxWeightService.createMaxWeight(transform.maxWeightDto_maxWeightEntity(maxWeight));

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}
	
	@PutMapping(value = "/{id}")
	ResponseEntity<?> updateMaxWeight(
			@RequestBody MaxWeight maxWeight,
			@PathVariable(value = "id") Long id) {
		
		MaxWeight m = new MaxWeight();
		m.setId(id);
		m.setExercice(maxWeight.getExercice());
		m.setWeight(maxWeight.getWeight());
		m.setDate(maxWeight.getDate());

		try {

			maxWeightService.updateMaxWeight(m);

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}

}
