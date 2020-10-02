package es.app.weightTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.app.weightTracker.entity.Role;
import es.app.weightTracker.enums.EnumRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(EnumRole name);

}
