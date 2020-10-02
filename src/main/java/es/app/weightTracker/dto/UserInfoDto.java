package es.app.weightTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
	
	private Long id;
	private String name;
	private String surname;
	private Long edad;
	private Long height;

}
