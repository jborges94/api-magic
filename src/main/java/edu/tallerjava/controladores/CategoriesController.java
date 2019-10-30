package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.modelo.CategoryMeliDTO;
import edu.tallerjava.servicios.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/categories")
    public List<CategoryMeliDTO> getCategories(){

        return categoryService.GetAll();
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id){
        Category category = categoryService.GetById(id);

        if(category == null){

            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @PostMapping(path = "/categories")
    public Category newCategory(@RequestBody Category category){
        return categoryService.Post(category);
    }

    @GetMapping(path = "categoriesByCodeAndName/{code}/{name}")
    public List<Category> getCategory(@PathVariable String code, @PathVariable String name) {
        return categoryService.GetByCodeAndName(code,name);
    }


    @GetMapping(path = "categoriesByCode/{code}")
    public List<Category> getCategory(@PathVariable String code) {
        return categoryService.GetByCode(code);
    }

    @GetMapping(path = "categoriesByName/{name}")
    public List<Category> getCategoryPorNombre(@PathVariable String name) {
        return categoryService.GetByName(name);
    }

}
