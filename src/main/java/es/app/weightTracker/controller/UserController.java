package es.app.weightTracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.app.weightTracker.dto.UserFullInfoDto;
import es.app.weightTracker.entity.User;
import es.app.weightTracker.service.UserService;
import es.app.weightTracker.util.ManagerException;
import es.app.weightTracker.util.Transformation;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userServive;
	
	@Autowired
	ManagerException managerException;
	
	@Autowired
	Transformation transform;
	
	@GetMapping("")
	ResponseEntity<?> getAllUser() {

		List<UserFullInfoDto> userDto = null;

		try {

			Optional<List<User>> users = userServive.findAllUsers();

			if (users.isPresent()) {
				userDto = transform.listUserEntity_userFullInfoDto(users.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping("/fullUser/{id}")
	ResponseEntity<?> getFullUser(@PathVariable(value = "id") Long id) {

		UserFullInfoDto userDto = null;

		try {

			Optional<User> user = userServive.findUserById(id);

			if (user.isPresent()) {
				userDto = transform.userEntity_UserFullInfoDto(user.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.ok(userDto);
	}
	
	@PutMapping(value = "/{id}")
	ResponseEntity<?> updateUser(
			@RequestBody User userfull,
			@PathVariable(value = "id") Long id) {
		
		User user = new User();
		user.setId(id);
		user.setName(userfull.getName());
		user.setSurname(userfull.getSurname());
		user.setEdad(userfull.getEdad());
		user.setHeight(userfull.getHeight());
		

		try {

			userServive.updateUser(user);

		} catch (DataAccessException e) {
			e.printStackTrace();
			return managerException.getExceptionDto(e);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}

}
