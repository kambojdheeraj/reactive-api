package com.example.api.reactive.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.reactive.dto.Ingredient;
import com.example.api.reactive.repository.IngredientRepository;

import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * DesignTacoController is used to sample out code b/w MVC and WebFlux difference
 */

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

	private final IngredientRepository ingredientRepo;

	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	/*
	 * recentIngredientRegular() represent single thread per request traditional approach.
	 */
	
	@GetMapping("/recent")
	public Iterable<Ingredient> recentIngredientRegular() {
		return ingredientRepo.findAll();
	}
	
	/*
	 * recentIngredientFlux() represent asynchronous web framework approach.
	 * Flux is used as part of reactive core api. Below still doesn't represent end to end reactive application as Repository is still using single
	 * thread feature.
	 */
	@GetMapping("/recentFlux")
	public Flux<Ingredient> recentIngredientFlux() {
		return Flux.fromIterable(ingredientRepo.findAll()).take(12);
	}

}
