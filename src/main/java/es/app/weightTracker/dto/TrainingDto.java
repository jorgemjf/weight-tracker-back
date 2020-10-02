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
public class TrainingDto {
	
	private Long minutesWod;
	private Long times;
	private String typeWod;
	private String wod;
	private String AdditionalWod;
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "es_ES", timezone = "Europe/Madrid")
	private Date date;
	private UserInfoDto user;

}
