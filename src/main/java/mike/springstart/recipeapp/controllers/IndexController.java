package mike.springstart.recipeapp.controllers;

import mike.springstart.recipeapp.domain.Recipe;
import mike.springstart.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        Set<Recipe> recipes = recipeService.getRecipes();
        List<Recipe> recipesList = recipes.stream().collect(Collectors.toList());
        Collections.sort(recipesList, (o1, o2) -> o1.getId().compareTo(o2.getId()));

        for(Recipe recipe : recipes) {
            System.out.println(recipe.getId());
        }

        model.addAttribute("recipes", recipesList);
        return "index";
    }
}
