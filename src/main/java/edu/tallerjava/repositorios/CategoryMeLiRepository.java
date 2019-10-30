package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.modelo.CategoryMeliDTO;

import java.util.List;

public interface CategoryMeLiRepository {
    public List<CategoryMeliDTO> findAll();
}
