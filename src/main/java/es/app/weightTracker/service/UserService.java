package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import es.app.weightTracker.entity.User;

public interface UserService {
	
	Optional<List<User>> findAllUsers();
	
	Optional<User> findUserById(Long id);
	
	void updateUser(User user);
	
	void deleteUserById(Long id);

}
