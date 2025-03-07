package at.kalwodaknezevic.inventoryhub;

import at.kalwodaknezevic.inventoryhub.commands.ArticleCommands.CreateArticleCommand;
import at.kalwodaknezevic.inventoryhub.commands.CountryCommands.CreateCountryCommand;
import at.kalwodaknezevic.inventoryhub.commands.EmployeeCommands.CreateEmployeeCommand;
import at.kalwodaknezevic.inventoryhub.commands.OrderCommands.CreateOrderCommand;
import at.kalwodaknezevic.inventoryhub.commands.SupplierCommands;
import at.kalwodaknezevic.inventoryhub.commands.SupplierCommands.CreateSupplierCommand;
import at.kalwodaknezevic.inventoryhub.domain.*;

import java.time.LocalDate;
import java.util.List;

public class FixturesFactory {

    public static Country austria() {
        return Country.builder()
                .name("Austria")
                .areaCode(43)
                .iso2Code("AT")
                .iso3Code("AUT")
                .build();
    }

    public static Address spengergasse20(Country country) {
        return new Address("Spengergasse 20", "Wien", "1050", country, AddressType.SHIPPING);
    }

    public static Email email() {
        return new Email("john.doe@spg.at");
    }

    public static String articleName() {
        return "Article 1";
    }

    public static PhoneNumber mobilePhone() {
        return new PhoneNumber(43, 1, "4567890", 0, PhoneType.MOBILE);
    }

    public static Employee johnDoeEmployee(Address address) {
        return Employee.builder()
                .name(new Name("John", "Doe"))
                .birthdate(LocalDate.of(1990, 1, 1))
                .email(email())
                .phoneNumber(mobilePhone())
                .address(address)
                .department("IT")
                .position("Developer")
                .salary(5000f)
                .build();
    }

    public static Supplier johnDoeSupplier(Address address) {
        return Supplier.builder()
                .name(new Name("John", "Doe"))
                .birthdate(LocalDate.of(1990, 1, 1))
                .email(new Email("john.doe@spg.at"))
                .phoneNumber(mobilePhone())
                .address(address)
                .companyName("SPG")
                .build();
    }

    public static Order order(Supplier supplier, Employee employee, Article article) {
        return Order.builder()
                .orderDate(LocalDate.now())
                .deliveryDate(LocalDate.now().plusDays(5))
                .orderStatus(OrderStatus.PENDING)
                .supplier(supplier)
                .employee(employee)
                .orderItems(List.of(orderItem(article)))
                .build();
    }

    public static OrderItem orderItem(Article article) {
        return new OrderItem(article, 5);
    }

    public static Article article() {
        return Article.builder()
                .name(articleName())
                .description("Article 1")
                .category(Category.OTHER)
                .price(10f)
                .quantity(100)
                .build();
    }

    public static CreateArticleCommand createArticleCommand(Article article) {
        return new CreateArticleCommand(
                article.getName(),
                article.getDescription(),
                article.getCategory().name(),
                article.getPrice(),
                article.getQuantity()
        );
    }

    public static CreateCountryCommand createCountryCommand(Country country) {
        return new CreateCountryCommand(
                country.getName(),
                country.getIso2Code(),
                country.getIso3Code(),
                country.getAreaCode()
        );
    }

    public static CreateEmployeeCommand createEmployeeCommand(Employee employee) {
        return new CreateEmployeeCommand(
                employee.getName(),
                employee.getBirthdate(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getAddress(),
                employee.getDepartment(),
                employee.getPosition(),
                employee.getSalary()
        );
    }

    public static CreateOrderCommand createOrderCommand(Order order) {
        return new CreateOrderCommand(
                order.getOrderItems(),
                order.getSupplier(),
                order.getOrderDate(),
                order.getDeliveryDate(),
                order.getOrderStatus(),
                order.getEmployee()
        );
    }

    public static CreateSupplierCommand createSupplierCommand(Supplier supplier) {
        return new SupplierCommands.CreateSupplierCommand(
                supplier.getName(),
                supplier.getBirthdate(),
                supplier.getEmail(),
                supplier.getPhoneNumber(),
                supplier.getAddress(),
                supplier.getCompanyName()
        );
    }
}
