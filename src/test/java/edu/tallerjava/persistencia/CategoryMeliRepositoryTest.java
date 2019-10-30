package edu.tallerjava.persistencia;

import edu.tallerjava.modelo.CategoryMeliDTO;
import edu.tallerjava.repositorios.CategoryMeLiRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMeliRepositoryTest {

    @Autowired
    private CategoryMeLiRepository categoryMeLiRepository;

    @Test
    public void findAllMeli(){
        List<CategoryMeliDTO> categoryMeliDtos = categoryMeLiRepository.findAll();
        Assert.assertEquals(categoryMeliDtos.size(), 30);
    };
}
