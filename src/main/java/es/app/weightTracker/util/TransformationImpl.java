package es.app.weightTracker.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import es.app.weightTracker.dto.MaxWeightDto;
import es.app.weightTracker.dto.TrackingDto;
import es.app.weightTracker.dto.TrainingDto;
import es.app.weightTracker.dto.UserFullInfoDto;
import es.app.weightTracker.entity.MaxWeight;
import es.app.weightTracker.entity.Tracking;
import es.app.weightTracker.entity.Training;
import es.app.weightTracker.entity.User;

@Component
public class TransformationImpl implements Transformation{
	
	private ModelMapper mapper;
	
	public TransformationImpl() {
		mapper = new ModelMapper();
	}
	
	@Override
	public List<UserFullInfoDto> listUserEntity_userFullInfoDto(List<User> users) {
		return mapper.map(users, new TypeToken<List<UserFullInfoDto>>() {
		}.getType());
	}

	@Override
	public UserFullInfoDto userEntity_UserFullInfoDto(User user) {
		return mapper.map(user, UserFullInfoDto.class);
	}
	
	@Override
	public List<TrainingDto> listTrainingrEntity_trainingDto(List<Training> trainings) {
		return mapper.map(trainings, new TypeToken<List<TrainingDto>>() {
		}.getType());
	}

	@Override
	public TrainingDto trainingEntity_trainingDto(Training training) {
		return mapper.map(training, TrainingDto.class);
	}

	@Override
	public Training trainingDto_trainingEntity(TrainingDto training) {
		return mapper.map(training, Training.class);
	}
	
	@Override
	public List<TrackingDto> listTrackingEntity_trackingDto(List<Tracking> trackings) {
		return mapper.map(trackings, new TypeToken<List<TrackingDto>>() {
		}.getType());
	}

	@Override
	public Tracking trackingDto_trackingEntity(TrackingDto tracking) {
		// TODO Auto-generated method stub
		return mapper.map(tracking, Tracking.class);
	}

	@Override
	public TrackingDto trackingEntity_trackingDto(Tracking tracking) {
		// TODO Auto-generated method stub
		return mapper.map(tracking, TrackingDto.class);
	}

	@Override
	public List<MaxWeightDto> listMaxWeightEntity_maxWeightDto(List<MaxWeight> maxWeights) {
		return mapper.map(maxWeights, new TypeToken<List<MaxWeightDto>>() {
		}.getType());
	}

	@Override
	public MaxWeight maxWeightDto_maxWeightEntity(MaxWeightDto maxWeight) {
		return mapper.map(maxWeight, MaxWeight.class);
	}

	@Override
	public MaxWeightDto maxWeightEntity_maxWeightDto(MaxWeight maxWeight) {
		return mapper.map(maxWeight, MaxWeightDto.class);
	}

}
