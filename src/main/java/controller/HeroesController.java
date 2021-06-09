package controller;

import document.Heroes;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.HeroesRepository;
import service.HeroesService;

import static constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@RequestMapping(HEROES_ENDPOINT_LOCAL)
public class HeroesController {

    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final Logger log = LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItens(){
        log.info("requesting the list off all heroes");
        return heroesService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable("id") String id){
        log.info("requesting the hero with id {}",id);
        return heroesService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes){
        log.info("creating a hero");
        return heroesService.create(heroes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByIdHero(@PathVariable("id") String id){
        log.info("deleting a hero with id {}", id);
        heroesService.deleteByIdHero(id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
