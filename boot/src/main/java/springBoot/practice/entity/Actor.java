package springBoot.practice.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Actor {
	@Id
	@GeneratedValue
	private Integer actorId;
	
	private String firstName;
	private String lastName;
	private LocalDateTime lastUpdate;
	private LocalDate birthDate;
}
