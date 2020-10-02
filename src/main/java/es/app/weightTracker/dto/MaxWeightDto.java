package es.app.weightTracker.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaxWeightDto {
	
	private String exercice;
	private Double weight;
	private Date date;
	private UserInfoDto user;

}
