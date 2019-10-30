package edu.tallerjava.servicios;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.modelo.CategoryMeliDTO;
import edu.tallerjava.repositorios.CategoryMeLiRepository;
import edu.tallerjava.repositorios.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private CategoryMeLiRepository categoryMeLiRepository;

    @Override
    public List<CategoryMeliDTO> GetAll() {
        List<CategoryMeliDTO> categories = categoryMeLiRepository.findAll();
        return categories;
    }

    @Override
    public Category GetById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public Category Post(Category category) {
        Category c = null;

        c = categoryRepository.save(category);

        return c;
    }

    @Override
    public List<Category> GetByCodeAndName(String code, String name) {
        List<Category> categories = categoryRepository.findAll();

        return  categories.stream().filter(c -> name.equals(c.getNombre()) && code.equals(c.getCodigo())).collect(Collectors.toList());
    }

    @Override
    public List<Category> GetByCode(String code) {
        List<Category> categories = categoryRepository.findAll();;
        return categories.stream().filter(c -> code.equals(c.getCodigo())).collect(Collectors.toList());
    }

    @Override
    public List<Category> GetByName(String name) {
        List<Category> categories = categoryRepository.findAll();;
        return categories.stream().filter(c -> name.equals(c.getNombre())).collect(Collectors.toList());
    }
}
