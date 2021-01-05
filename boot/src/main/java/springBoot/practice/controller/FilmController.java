package springBoot.practice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springBoot.practice.service.FilmService;

@Controller
public class FilmController {
	
	@Autowired
	FilmService filmService;
	
	@GetMapping("/film")
	@ResponseBody
	public ResponseEntity<?> filmList(int pageNo,Integer categoryId) {
		ResponseEntity<?> result = this.getResponseData(filmService.filmList(pageNo,categoryId));
		return result;
	}
	
	public ResponseEntity<?> getResponseData(Object data){
		HttpHeaders header = new HttpHeaders();
		header.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return ResponseEntity.ok().headers(header).body(data);
	}
}
