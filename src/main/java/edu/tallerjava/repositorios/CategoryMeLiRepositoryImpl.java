package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.modelo.CategoryMeliDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Function;

@Repository
public class CategoryMeLiRepositoryImpl implements CategoryMeLiRepository {


    private final String BASE_URL = "https://api.mercadolibre.com/sites";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<CategoryMeliDTO> findAll() {
        List<CategoryMeliDTO> categoryMeliDtos = restTemplate.getForObject(BASE_URL + "/MLA/categories", List.class);
        return categoryMeliDtos;
    }
}
