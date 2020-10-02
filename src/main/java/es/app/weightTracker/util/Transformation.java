package es.app.weightTracker.util;

import java.util.List;

import es.app.weightTracker.dto.MaxWeightDto;
import es.app.weightTracker.dto.TrackingDto;
import es.app.weightTracker.dto.TrainingDto;
import es.app.weightTracker.dto.UserFullInfoDto;
import es.app.weightTracker.entity.MaxWeight;
import es.app.weightTracker.entity.Tracking;
import es.app.weightTracker.entity.Training;
import es.app.weightTracker.entity.User;

public interface Transformation {
	
	List<UserFullInfoDto> listUserEntity_userFullInfoDto(List<User> users);
	
	UserFullInfoDto userEntity_UserFullInfoDto(User user);
	
	List<TrainingDto> listTrainingrEntity_trainingDto(List<Training> trainings);
	
	TrainingDto trainingEntity_trainingDto(Training training);
	
	Training trainingDto_trainingEntity(TrainingDto training);
	
	List<TrackingDto> listTrackingEntity_trackingDto(List<Tracking> trackings);
	
	Tracking trackingDto_trackingEntity(TrackingDto tracking);
	
	TrackingDto trackingEntity_trackingDto(Tracking tracking);
	
	List<MaxWeightDto> listMaxWeightEntity_maxWeightDto(List<MaxWeight> maxWeights);
	
	MaxWeight maxWeightDto_maxWeightEntity(MaxWeightDto maxWeight);
	
	MaxWeightDto maxWeightEntity_maxWeightDto(MaxWeight maxWeight);

}
