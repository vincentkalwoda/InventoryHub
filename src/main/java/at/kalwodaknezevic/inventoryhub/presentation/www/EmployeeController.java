package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RequiredArgsConstructor

@Controller
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController implements ControllerSupport {
    private final EmployeeService employeeService;

    public static final String BASE_URL = "/employees";
    public static final String PATH_VAR_ID = "/{apiKey}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var employees = employeeService.getAll();

        model.addAttribute("employees", employees);
        return "employees/index";
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable String apiKey) {
        return employeeService.getEmployee(apiKey)
                .map(employee -> model.addAttribute("employee", employee))
                .map(__ -> "employees/show")
                .orElse("employees/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newEmployee", new CreateEmployeeForm());
        return "employees/create";
    }

    @GetMapping(ROUTE_EDIT)
    public String showEditForm(Model model, @PathVariable String apiKey) {
        return employeeService.getEmployee(apiKey)
                .map(employee ->
                        model.addAttribute("editEmployee", new EditEmployeeForm(employee)))
                .map(__ -> "employees/edit")
                .orElse("employees/index");
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newEmployee") CreateEmployeeForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "employees/create";
        }

        employeeService.createEmployee(form);
        return redirect(BASE_URL);
    }

    @PostMapping(value = ROUTE_EDIT)
    public String handleEditForm(@Valid @ModelAttribute("editEmployee") EditEmployeeForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "employees/edit";
        }

        employeeService.updateEmployee(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable String apiKey) {
        employeeService.deleteEmployee(apiKey);
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
