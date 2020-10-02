package es.app.weightTracker.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "training")
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String typeWod;
	
	@Column(nullable = false)
	private Long minutesWod;
	
	@Column(nullable = false)
	private Long times;
	
	@Column(nullable = false)
	private String wod;
	
	@Column
	private String AdditionalWod;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne
	private User user;

}
