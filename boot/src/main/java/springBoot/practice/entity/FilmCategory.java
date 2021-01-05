package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class FilmCategory {
	@Id
	@GeneratedValue
	private Integer filmId;
	
	private Integer categoryId;
	private LocalDateTime lastUpdate;
}
