package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RequiredArgsConstructor

@Controller
@RequestMapping(SupplierController.BASE_URL)
public class SupplierController implements ControllerSupport {
    private final SupplierService supplierService;

    public static final String BASE_URL = "/suppliers";
    public static final String PATH_VAR_ID = "/{apiKey}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var suppliers = supplierService.getAll();

        model.addAttribute("suppliers", suppliers);
        return "suppliers/index";

    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable String apiKey) {
        return supplierService.getSupplier(apiKey)
                .map(supplier -> model.addAttribute("supplier", supplier))
                .map(__ -> "suppliers/show")
                .orElse("suppliers/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newSupplier", new CreateSupplierForm());
        return "suppliers/create";
    }

    @GetMapping(ROUTE_EDIT)
    public String showEditForm(Model model, @PathVariable String apiKey) {
        return supplierService.getSupplier(apiKey)
                .map(supplier ->
                        model.addAttribute("editSupplier", new EditSupplierForm(supplier)))
                .map(__ -> "suppliers/edit")
                .orElse("suppliers/index");
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newSupplier") CreateSupplierForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "suppliers/create";

        supplierService.createSupplier(form);
        return redirect(BASE_URL);
    }

    @PostMapping(value = ROUTE_EDIT)
    public String handleEditForm(@Valid @ModelAttribute("editSupplier") EditSupplierForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "suppliers/edit";
        }

        supplierService.updateSupplier(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable String apiKey) {
        supplierService.deleteSupplier(apiKey);
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
