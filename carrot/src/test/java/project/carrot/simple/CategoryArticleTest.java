package project.carrot.simple;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryArticleTest {

    @Autowired
    EntityManager em;

//    @Test
//    public void categoryArticle() {
//        Article article = new Article(1L);
//
//        Category category1 = new Category(1L, "의류");
//        em.persist(category1);
//
//        Category category2 = new Category(2L, "음식");
//        em.persist(category2);
//
//    }
}
