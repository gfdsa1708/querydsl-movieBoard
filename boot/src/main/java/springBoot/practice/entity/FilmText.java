package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
public class FilmText {
	@Id
	@GeneratedValue
	private Integer filmId;
	
	private String title;
	private String description;
}
