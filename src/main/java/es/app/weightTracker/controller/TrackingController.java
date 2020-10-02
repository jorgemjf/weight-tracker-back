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

import es.app.weightTracker.dto.TrackingDto;
import es.app.weightTracker.entity.Tracking;
import es.app.weightTracker.service.TrackingService;
import es.app.weightTracker.util.ManagerException;
import es.app.weightTracker.util.Transformation;

@RestController
@RequestMapping(value = "/tracking")
@CrossOrigin(origins = "http://localhost:4200")
public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;
	
	@Autowired
	private ManagerException managerException;

	@Autowired
	private Transformation transform;
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> getAllTrackingsByUser(@PathVariable(value = "id") Long userId) {

		List<TrackingDto> trackingDto = null;

		try {

			Optional<List<Tracking>> trackings = trackingService.findAllTrackingByUserId(userId);

			if (trackings.isPresent()) {
				trackingDto = transform.listTrackingEntity_trackingDto(trackings.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(trackingDto);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getTracking(@PathVariable(value = "id") Long id) {

		TrackingDto trackingDto = null;

		try {

			Optional<Tracking> tracking = trackingService.findTrackingById(id);

			if (tracking.isPresent()) {
				trackingDto = transform.trackingEntity_trackingDto(tracking.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(trackingDto);
	}
	
	@PostMapping("")
	ResponseEntity<?> createTraining(@RequestBody TrackingDto trackingDto) {

		try {

			trackingService.createTracking(transform.trackingDto_trackingEntity(trackingDto));

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}
	
	@PutMapping(value = "/{id}")
	ResponseEntity<?> updateTraining(
			@RequestBody Tracking tracking,
			@PathVariable(value = "id") Long id) {
		
		Tracking t = new Tracking();
		t.setId(id);
		t.setChest(tracking.getChest());
		t.setWeight(tracking.getWeight());
		t.setBicep(tracking.getBicep());
		t.setWaist(tracking.getWaist());
		t.setHips(tracking.getHips());
		t.setThigh(tracking.getThigh());
		t.setDate(tracking.getDate());		

		try {

			trackingService.updateTracking(t);

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}

}
