package springBoot.practice.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import springBoot.practice.entity.*;
import springBoot.practice.service.*;

@Controller
public class ActorController {
	
	@Autowired
	ActorService actorService;
	
	@GetMapping("/actors")
	@ResponseBody
	public List<Actor> getAllActors() {
		return actorService.getAllActors();
	}
	
	@GetMapping("/actor/{actorId}")
	@ResponseBody
	public Actor getAllActors(@PathVariable int actorId) {
		return actorService.getActor(actorId);
	}
	
}
