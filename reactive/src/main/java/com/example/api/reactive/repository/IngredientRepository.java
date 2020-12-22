package com.example.api.reactive.repository;

import com.example.api.reactive.dto.Ingredient;

public interface IngredientRepository {
	
	Iterable<Ingredient> findAll();
	Ingredient findOne(String id);
	Ingredient save(Ingredient ingredient);
	
}
