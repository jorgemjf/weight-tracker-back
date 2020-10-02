package es.app.weightTracker.payload.request;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {
	
	private String username;
	
	private String Email;
	
	private Set<String> role;
	
	private String password;
	
	private String name;
	
	private String surname;
	
	private Long edad;
	
	private Long height;

}
