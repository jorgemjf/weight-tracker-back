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
public class UserFullDto {
	
	private String name;
	private String surname;
	private Long edad;
	private Long heihgt;
	private String email;
	private String username;
	private Set<RoleDto> roles;
	
	// añadir en un futuro training, tracking etc con sus dto
	

}
