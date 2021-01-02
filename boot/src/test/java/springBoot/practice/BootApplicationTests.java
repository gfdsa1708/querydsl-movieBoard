package springBoot.practice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import javax.persistence.*;
import javax.transaction.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.jdbc.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import com.querydsl.jpa.impl.*;

import springBoot.practice.entity.*;
import springBoot.practice.repository.*;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace=Replace.NONE)
class BootApplicationTests {

	@Autowired
	ActorRepository repo;
	
	@Autowired
	EntityManager em;
	//@Test
	void contextLoads() {
	}
	
	@Test
	void findAll() {
		JPAQueryFactory query = new JPAQueryFactory(em);
		QActor actor = QActor.actor;
		QFilmActor filmActor = QFilmActor.filmActor;
		QFilm film = QFilm.film;
		QFilmCategory filmCategory = QFilmCategory.filmCategory;
		QFilmText filmText = QFilmText.filmText;
		QCategory category = QCategory.category;
		
		List<Actor> result = query.selectFrom(actor)
							.join(filmActor)
							.on(actor.actorId.eq(filmActor.actorId))
							.where(actor.actorId.eq(1)).fetch();
		assertThat(result.size()).isEqualTo(20);
		
	}
}
