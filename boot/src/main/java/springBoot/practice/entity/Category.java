package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	private String name;
	private LocalDateTime lastUpdate;
}
