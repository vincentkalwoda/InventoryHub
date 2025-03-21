package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.dtos.ArticleDto;
import at.kalwodaknezevic.inventoryhub.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(ApiConstants.API+"/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    @GetMapping()
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAll()
                .stream()
                .map(ArticleDto::new)
                .toList());
    }

    @GetMapping("/{apiKey}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable String apiKey) {
        return articleService.getArticle(apiKey)
                .map(ArticleDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
