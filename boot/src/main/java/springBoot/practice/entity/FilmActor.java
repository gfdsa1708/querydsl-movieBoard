package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class FilmActor {
	@Id
	@GeneratedValue
	private Integer actorId;
	
	private Integer filmId;
	private LocalDateTime lastUpdate;
}
