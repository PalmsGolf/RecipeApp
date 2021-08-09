package mike.springstart.recipeapp.services;

import mike.springstart.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
