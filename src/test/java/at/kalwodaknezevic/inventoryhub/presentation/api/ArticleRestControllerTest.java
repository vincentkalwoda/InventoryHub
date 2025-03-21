package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.commands.ArticleCommands.CreateArticleCommand;
import at.kalwodaknezevic.inventoryhub.domain.Category;
import at.kalwodaknezevic.inventoryhub.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static at.kalwodaknezevic.inventoryhub.FixturesFactory.article;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ArticleService articleService;


    @BeforeEach
    void setUp() {
        assumeThat(articleService).isNotNull();
        assumeThat(mockMvc).isNotNull();
    }

    @Test
    void getAllArticles_returnsListOfArticles() throws Exception {
        var request = get("/api/articles").accept(MediaType.APPLICATION_JSON);
        when(articleService.getAll()).thenReturn(List.of(article()));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Article 1"))
                .andExpect(jsonPath("$[0].description").value("Article 1"))
                .andDo(print());
    }

    @Test
    void getArticle_returnsArticle() throws Exception {
        var request = get("/api/articles/a_8z912hujqaiA7Hx2").accept(MediaType.APPLICATION_JSON);
        when(articleService.getArticle("a_8z912hujqaiA7Hx2")).thenReturn(Optional.ofNullable(article()));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Article 1"))
                .andExpect(jsonPath("$.description").value("Article 1"))
                .andExpect(jsonPath("$.category").value(Category.OTHER.name()))
                .andExpect(jsonPath("$.price").value(10.0))
                .andExpect(jsonPath("$.quantity").value(100))
                .andDo(print());
    }

    @Test
    void getArticle_returnsNotFound() throws Exception {
        var request = get("/api/articles/a_8z912hujqaiA7Hx2").accept(MediaType.APPLICATION_JSON);
        when(articleService.getArticle("a_8z912hujqaiA7Hx2")).thenReturn(Optional.empty());

        mockMvc.perform(request)
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void createArticle_returnsCreatedArticle() throws Exception {
        var request = post("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(article()));

        when(articleService.createArticle(any(CreateArticleCommand.class))).thenReturn(article());

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Article 1"))
                .andExpect(jsonPath("$.description").value("Article 1"))
                .andExpect(jsonPath("$.category").value(Category.OTHER.name()))
                .andExpect(jsonPath("$.price").value(10.0))
                .andExpect(jsonPath("$.quantity").value(100))
                .andDo(print());
    }

}