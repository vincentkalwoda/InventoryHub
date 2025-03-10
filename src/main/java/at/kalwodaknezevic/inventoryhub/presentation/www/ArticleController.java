package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RequiredArgsConstructor

@Controller
public class ArticleController implements ControllerSupport {
    private final ArticleService articleService;

    public static final String BASE_URL = "/articles";
    public static final String PATH_VAR_ID = "/{id}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var articles = articleService.getAll();

        if (articles.size() == 1) {
            model.addAttribute("article", articles.get(0));
            return "articles/show";
        } else {
            model.addAttribute("articles", articles);
            return "articles/index";
        }
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable Long id) {
        return articleService.getArticle(id)
                .map(article -> model.addAttribute("article", article))
                .map(__ -> "articles/show")
                .orElse("articles/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newArticle", new CreateArticleForm());
        return "articles/create";
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newArticle") CreateArticleForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "articles/create";

        articleService.createArticle(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return redirect(BASE_URL);
    }

    @GetMapping("/duration")
    public String handleDurationSubmission(@RequestParam Duration value) {
        return redirect(BASE_URL);
    }

    @Override
    public String getTemplateBaseDir() {
        return BASE_URL;
    }
}
