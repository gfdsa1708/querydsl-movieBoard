package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Film {
	@Id
	@GeneratedValue
	private Integer filmId;
	
	private String titie;
	private String description;
	private LocalDateTime lastUpdate;
	private int length;
}
