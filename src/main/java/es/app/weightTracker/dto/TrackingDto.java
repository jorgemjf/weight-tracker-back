package es.app.weightTracker.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrackingDto {
	
	private Long chest;
	private Double weight;
	private Long bicep;
	private Long waist;
	private Long hips;
	private Long thigh;
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "es_ES", timezone = "Europe/Madrid")
	private Date date;
	private UserInfoDto user;

}
