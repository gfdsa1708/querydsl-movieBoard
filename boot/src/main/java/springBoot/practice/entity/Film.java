package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Film {
	@Id
	@GeneratedValue
	private Integer filmId;
	
	private String title;
	private String description;
	private LocalDateTime lastUpdate;
	private int length;
}
