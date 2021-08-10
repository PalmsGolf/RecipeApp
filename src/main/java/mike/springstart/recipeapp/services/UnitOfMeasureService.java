package mike.springstart.recipeapp.services;

import mike.springstart.recipeapp.comands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}