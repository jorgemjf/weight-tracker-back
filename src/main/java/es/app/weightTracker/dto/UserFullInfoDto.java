package es.app.weightTracker.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFullInfoDto {
	
	private String name;
	private String surname;
	private Long edad;
	private Long height;
	private String email;
	private String username;
	private Set<RoleDto> roles;

}
