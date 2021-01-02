package springBoot.practice.service;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.transaction.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.querydsl.jpa.impl.*;

import springBoot.practice.entity.*;

@Service
public class ActorService {
	
	@Autowired
	EntityManager em;
	
	public List<Actor> getAllActors(){
		JPAQueryFactory query = new JPAQueryFactory(em);
		QActor actor = QActor.actor;
		List<Actor> result = query.selectFrom(actor).fetch();
		return result;
	}
	
	public Actor getActor(int actorId){
		JPAQueryFactory query = new JPAQueryFactory(em);
		QActor actor = QActor.actor;
		Actor result = query.selectFrom(actor).where(actor.actorId.eq(actorId)).fetchOne();
		return result;
	}
	
	@Transactional
	public void insert(){
		JPAQueryFactory query = new JPAQueryFactory(em);
		QActor actor = QActor.actor;
		int year, month, day;
		int length = this.getAllActors().size();
		for(int i=1; i<length+1; i++) {
			year = (int) (Math.random()*73)+1930;
			month = (int) (Math.random()*12)+1;
			day = (int) (Math.random()*31)+1;
			if(month == 2) {
				day = (int) (Math.random()*28)+1;
			} else if(month == 4 || month == 6 || month == 9 || month == 11) {
				day = (int) (Math.random()*30)+1;
			}
			LocalDate date = LocalDate.of(year, month, day);
			query.update(actor).set(actor.birthDate, date).where(actor.actorId.eq(i)).execute();
		}
	}

}
