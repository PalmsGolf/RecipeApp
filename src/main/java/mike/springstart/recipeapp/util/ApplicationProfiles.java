package mike.springstart.recipeapp.util;

public class ApplicationProfiles {
    public static final String H2_PROFILE = "h2";
    public static final String SQL_PROFILE = "sql";

    private ApplicationProfiles() {
        throw new IllegalStateException("Utility class");
    }
}
