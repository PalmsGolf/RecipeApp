package mike.springstart.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import mike.springstart.recipeapp.domain.Recipe;
import mike.springstart.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl( RecipeRepository recipeService) {
        this.recipeRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(String recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] imageBlob = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()){
                imageBlob[i++] = b;
            }

            recipe.setImage(imageBlob);

            recipeRepository.save(recipe);
        } catch (IOException ex) {
            log.error("Error occurred.", ex);
        }
    }
}