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
public class EmployeeController implements ControllerSupport {
    private final EmployeeService employeeService;

    public static final String BASE_URL = "/employees";
    public static final String PATH_VAR_ID = "/{id}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var employees = employeeService.getAll();

        if (employees.size() == 1) {
            model.addAttribute("employees", employees.get(0));
            return "employees/show";
        } else {
            model.addAttribute("employees", employees);
            return "employees/index";
        }
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable Long id) {
        return employeeService.getEmployee(id)
                .map(employee -> model.addAttribute("employee", employee))
                .map(__ -> "employees/show")
                .orElse("employees/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newEmployee", new CreateEmployeeForm());
        return "employees/create";
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newEmployee") CreateEmployeeForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "employees/create";

        employeeService.createEmployee(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
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
