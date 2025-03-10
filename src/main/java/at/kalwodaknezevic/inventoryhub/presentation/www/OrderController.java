package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RequiredArgsConstructor

@Controller
public class OrderController implements ControllerSupport {
    private final OrderService orderService;

    public static final String BASE_URL = "/orders";
    public static final String PATH_VAR_ID = "/{id}";
    public static final String ROUTE_INDEX = "/";
    public static final String ROUTE_SHOW = "/show" + PATH_VAR_ID;
    public static final String ROUTE_NEW = "/new";
    public static final String ROUTE_EDIT = "/edit" + PATH_VAR_ID;
    public static final String ROUTE_DELETE = "/delete" + PATH_VAR_ID;

    @GetMapping({"", ROUTE_INDEX})
    public String index(Model model) {
        var orders = orderService.getAll();

        if (orders.size() == 1) {
            model.addAttribute("orders", orders.get(0));
            return "orders/show";
        } else {
            model.addAttribute("orders", orders);
            return "orders/index";
        }
    }

    @GetMapping(ROUTE_SHOW)
    public String show(Model model, @PathVariable Long id) {
        return orderService.getOrder(id)
                .map(order -> model.addAttribute("order", order))
                .map(__ -> "orders/show")
                .orElse("orders/index");
    }

    @GetMapping(ROUTE_NEW)
    public String showCreateForm(Model model) {
        model.addAttribute("newOrder", new CreateOrderForm());
        return "orders/create";
    }

    @PostMapping(value = ROUTE_NEW)
    public String handleCreateForm(@Valid @ModelAttribute("newOrder") CreateOrderForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "orders/create";

        orderService.createOrder(form);
        return redirect(BASE_URL);
    }

    @GetMapping(ROUTE_DELETE)
    public String delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
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
