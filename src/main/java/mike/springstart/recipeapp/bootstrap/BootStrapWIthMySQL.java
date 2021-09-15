package mike.springstart.recipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import mike.springstart.recipeapp.domain.Category;
import mike.springstart.recipeapp.domain.UnitOfMeasure;
import mike.springstart.recipeapp.repositories.CategoryRepository;
import mike.springstart.recipeapp.repositories.UnitOfMeasureRepository;
import mike.springstart.recipeapp.util.ApplicationProfiles;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * Responsible for loading missing DB data.
 */
@Slf4j
@Component
@Profile({ApplicationProfiles.SQL_PROFILE})
public class BootStrapWIthMySQL implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private List<String> categoriesDescription = Arrays.asList("American", "Italian", "Mexican");
    private List<String> unitsOfMeasureDescription = Arrays.asList("Teaspoon", "Tablespoon", "Cup", "Pinch",
            "Each", "Pint", "Ounce");

    public BootStrapWIthMySQL(CategoryRepository categoryRepository,
                              UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        boolean isSomethingLoaded = false;

        if (categoryRepository.count() == 0L) {
            loadCategories();
            log.debug("Loaded Categories.");
            isSomethingLoaded = true;
        }

        if (unitOfMeasureRepository.count() == 0L) {
            loadUom();
            log.debug("Loaded UOMs.");
            isSomethingLoaded = true;
        }

        if (isSomethingLoaded) {
            log.debug("Loaded BootStrap data for MySQL.");
        }
    }

    private void loadCategories() {
        for (String categoryDescription : categoriesDescription) {
            Category category = new Category();
            category.setDescription(categoryDescription);
            categoryRepository.save(category);
        }
    }

    private void loadUom() {
        for (String unitOfMeasureDescription : unitsOfMeasureDescription) {
            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setDescription(unitOfMeasureDescription);
            unitOfMeasureRepository.save(unitOfMeasure);
        }
    }
}