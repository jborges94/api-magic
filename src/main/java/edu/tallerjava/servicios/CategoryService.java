package edu.tallerjava.servicios;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.modelo.CategoryMeliDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryMeliDTO> GetAll();
    public Category GetById(Long id);
    public Category Post(Category category);
    public List<Category> GetByCodeAndName(String code, String name);
    public List<Category> GetByCode(String code);
    public List<Category> GetByName(String name);
}
