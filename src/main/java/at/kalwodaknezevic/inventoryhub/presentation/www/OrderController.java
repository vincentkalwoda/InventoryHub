package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.OrderStatus;
import at.kalwodaknezevic.inventoryhub.service.ArticleService;
import at.kalwodaknezevic.inventoryhub.service.EmployeeService;
import at.kalwodaknezevic.inventoryhub.service.OrderService;
import at.kalwodaknezevic.inventoryhub.service.SupplierService;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Arrays;

@RequiredArgsConstructor

@Controller
@RequestMapping(OrderController.BASE_URL)
public class OrderController implements ControllerSupport {
    private final OrderService orderService;
    private final SupplierService supplierService;
    private final EmployeeService employeeService;

    public static final String BASE_URL = "/orders";
    public static final String PATH_VAR_ID = "/{apiKey}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;
    private final ArticleService articleService;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var orders = orderService.getAll();

        model.addAttribute("orders", orders);
        return "orders/index";
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable String apiKey) {
        return orderService.getOrder(apiKey)
                .map(order -> model.addAttribute("order", order))
                .map(__ -> "orders/show")
                .orElse("orders/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        CreateOrderForm form = new CreateOrderForm();
        form.getOrderItems().add(new OrderItemForm());
        model.addAttribute("newOrder", form);
        var suppliers = supplierService.getAll();
        var employees = employeeService.getAll();
        var articles = articleService.getAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("employees", employees);
        model.addAttribute("articles", articles);
        model.addAttribute("orderStatus", Arrays.asList(OrderStatus.values()));

        return "orders/create";
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newOrder") CreateOrderForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "orders/create";
        }

        orderService.createOrder(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable String apiKey) {
        orderService.deleteOrder(apiKey);
        return redirect(BASE_URL);
    }

    @GetMapping("/duration")
    public String handleDurationSubmission(@RequestParam Duration value) {
        return redirect(BASE_URL);
    }

    @GetMapping("/addOrderItem")
    @HxRequest
    public String addOrderItem(Model model, @RequestParam int index) {
        model.addAttribute("orderItem", new OrderItemForm());
        model.addAttribute("articles", articleService.getAll());
        model.addAttribute("index", index);
        return "orders/orderItemForm";
    }

    @Override
    public String getTemplateBaseDir() {
        return BASE_URL;
    }
}
