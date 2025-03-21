package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RequiredArgsConstructor

@Controller
@RequestMapping(CountryController.BASE_URL)
public class CountryController implements ControllerSupport {
    private final CountryService countryService;

    public static final String BASE_URL = "/countries";
    public static final String PATH_VAR_ID = "/{apiKey}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var countries = countryService.getAll();

        model.addAttribute("countries", countries);
        return "countries/index";
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable String apiKey) {
        return countryService.getCountry(apiKey)
                .map(country -> model.addAttribute("country", country))
                .map(__ -> "countries/show")
                .orElse("countries/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newCountry", new CreateCountryForm());
        return "countries/create";
    }

    @GetMapping(ROUTE_EDIT)
    public String showEditForm(Model model, @PathVariable String apiKey) {
        return countryService.getCountry(apiKey)
                .map(country -> model.addAttribute("editCountry", new EditCountryForm(country)))
                .map(__ -> "countries/edit")
                .orElse("countries/index");
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newCountry") CreateCountryForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "countries/create";

        countryService.createCountry(form);
        return redirect(BASE_URL);
    }

    @PostMapping(value = ROUTE_EDIT)
    public String handleEditForm(@Valid @ModelAttribute("editCountry") EditCountryForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "countries/edit";

        countryService.updateCountry(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable String apiKey) {
        countryService.deleteCountry(apiKey);
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
