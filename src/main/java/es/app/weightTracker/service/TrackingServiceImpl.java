package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.app.weightTracker.entity.Tracking;
import es.app.weightTracker.repository.TrackingRepository;

@Service
public class TrackingServiceImpl implements TrackingService{
	
	@Autowired
	TrackingRepository trackingRepo;

	@Override
	public Optional<List<Tracking>> findAllTrackingByUserId(Long userId) {
		return trackingRepo.findByUserId(userId);
	}

	@Override
	public Optional<Tracking> findTrackingById(Long id) {
		return trackingRepo.findById(id);
	}

	@Override
	public void createTracking(Tracking tracking) {
		trackingRepo.save(tracking);
		
	}

	@Override
	public void updateTracking(Tracking tracking) {
		Tracking t = trackingRepo.getOne(tracking.getId());
		if (tracking.getChest() != null) {
			t.setChest(tracking.getChest());
		}
		if (tracking.getWeight() != null) {
			t.setWeight(tracking.getWeight());
		}
		if (tracking.getBicep() != null) {
			t.setBicep(tracking.getBicep());
		}
		if (tracking.getWaist() != null) {
			t.setWaist(tracking.getWaist());
		}
		if (tracking.getHips() != null) {
			t.setHips(tracking.getHips());
		}
		if (tracking.getThigh() != null) {
			t.setThigh(tracking.getThigh());
		}
		if (tracking.getDate() != null) {
			t.setDate(tracking.getDate());
		}
		trackingRepo.save(t);
		
	}

}
