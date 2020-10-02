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
@Table(name = "tracking")
public class Tracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private Long chest;
	
	@Column(nullable = false)
	private Double weight;
	
	@Column(nullable = false)
	private Long bicep;
	
	@Column(nullable = false)
	private Long waist;
	
	@Column(nullable = false)
	private Long hips;
	
	@Column(nullable = false)
	private Long thigh;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne
	private User user;

}
