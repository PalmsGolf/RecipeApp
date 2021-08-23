package mike.springstart.recipeapp.repositories;

import mike.springstart.recipeapp.domain.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE r.cookTime < 100")
    Collection<Recipe> findAllEasyRecipes();
}
