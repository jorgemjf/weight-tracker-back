package es.app.weightTracker.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = true, length = 20)
	private String name;
	
	@Column(nullable = true, length = 20)
	private String surname;
	
	@Column(nullable = true)
	private Long edad;
	
	@Column(nullable = true)
	private Long height;
	
	@Column(nullable = false)
	private String email;
	
	@Column(unique = true, nullable = false, length = 20)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Training> training;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Tracking> tracking;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MaxWeight> maxWeight;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "user_role", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public User(String name, String surname, Long edad, Long height, String email, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.edad = edad;
		this.height = height;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	

	
}
