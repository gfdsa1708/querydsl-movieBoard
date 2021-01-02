package springBoot.practice.repository;

import org.springframework.data.jpa.repository.*;

import springBoot.practice.entity.*;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

}
