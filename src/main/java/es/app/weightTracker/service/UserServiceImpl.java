package es.app.weightTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.app.weightTracker.entity.User;
import es.app.weightTracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Optional<List<User>> findAllUsers() {
		return Optional.of(userRepo.findAll());
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public void updateUser(User user) {
		// Solo se permite actualizar el nombre, apellidos, edad, altura
		User u = userRepo.getOne(user.getId());
		if (user.getName() != null) {
			u.setName(user.getName());
		}
		if (user.getSurname() != null) {
			u.setSurname(user.getSurname());
		}
		if (user.getEdad() != null) {
			u.setEdad(user.getEdad());
		}
		if (user.getHeight() != null) {
			u.setHeight(user.getHeight());
		}
		userRepo.save(u);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
		
	}

}
