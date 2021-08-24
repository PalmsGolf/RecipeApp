package mike.springstart.recipeapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Category {
    @Id
    private String id;
    private String description;

    @DBRef
    private Recipe recipe;

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }
}
