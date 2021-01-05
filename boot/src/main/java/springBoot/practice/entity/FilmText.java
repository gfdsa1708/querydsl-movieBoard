package springBoot.practice.entity;


import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class FilmText {
	@Id
	@GeneratedValue
	private Integer filmId;
	
	private String title;
	private String description;
}
