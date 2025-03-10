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
public class SupplierController implements ControllerSupport {
    private final SupplierService supplierService;

    public static final String BASE_URL = "/suppliers";
    public static final String PATH_VAR_ID = "/{id}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var suppliers = supplierService.getAll();

        if (suppliers.size() == 1) {
            model.addAttribute("suppliers", suppliers.get(0));
            return "suppliers/show";
        } else {
            model.addAttribute("suppliers", suppliers);
            return "suppliers/index";
        }
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable Long id) {
        return supplierService.getSupplier(id)
                .map(supplier -> model.addAttribute("supplier", supplier))
                .map(__ -> "suppliers/show")
                .orElse("suppliers/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newSupplier", new CreateSupplierForm());
        return "suppliers/create";
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newSupplier") CreateSupplierForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "suppliers/create";

        supplierService.createSupplier(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
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
