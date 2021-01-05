package springBoot.practice.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import springBoot.practice.dto.FilmDto;
import springBoot.practice.entity.Film;
import springBoot.practice.entity.QCategory;
import springBoot.practice.entity.QFilm;
import springBoot.practice.entity.QFilmCategory;

@Service
@Slf4j
public class FilmService {
	
	@Autowired
	private EntityManager em;
	
	QFilm film = QFilm.film;
	QFilmCategory filmCategory = QFilmCategory.filmCategory;
	QCategory category = QCategory.category;
	
	public List<FilmDto> filmList(int pageNo, Integer categoryId){
		JPAQueryFactory query = new JPAQueryFactory(em);
		int viewPerPage = 10;
		BooleanBuilder builder = new BooleanBuilder();
		if(categoryId != null){
            builder.and(category.categoryId.eq(categoryId));
        }
		List<FilmDto> filmList = query.select(Projections.fields(FilmDto.class
											, film.title
											, category.name
											, film.length))
										.from(film)
										.innerJoin(filmCategory)
										.on(film.filmId.eq(filmCategory.filmId))
										.innerJoin(category)
										.on(filmCategory.categoryId.eq(category.categoryId))
										.where(builder)
										.limit(viewPerPage)
										.offset(pageNo*viewPerPage)
										.fetch();
		return filmList;
	}
}
