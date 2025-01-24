package at.kalwodaknezevic.inventoryhub;

import at.kalwodaknezevic.inventoryhub.domain.*;

import java.time.LocalDate;

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

    public static Name articleName() {
        return new Name("Article 1");
    }

    public static PhoneNumber mobilePhone() {
        return new PhoneNumber(43, 1, "4567890", 0, PhoneType.MOBILE);
    }

    public static Employee johnDoeEmployee(Address address) {
        return Employee.builder()
                .firstname(new Name("John"))
                .lastname(new Name("Doe"))
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
                .firstname(new Name("John"))
                .lastname(new Name("Doe"))
                .birthdate(LocalDate.of(1990, 1, 1))
                .email(new Email("john.doe@spg.at"))
                .phoneNumber(mobilePhone())
                .address(address)
                .companyName("SPG")
                .build();
    }

    public static Order order(Supplier supplier, Employee employee) {
        return Order.builder()
                .orderDate(LocalDate.now())
                .deliveryDate(LocalDate.now().plusDays(5))
                .orderStatus(OrderStatus.PENDING)
                .supplier(supplier)
                .employees(employee)
                .build();
    }

    public static OrderItem orderItem(Article article) {
        return new OrderItem(article, 5);
    }

    public static Article article() {
        return Article.builder()
                .name(articleName())
                .description("Article 1")
                .price(10f)
                .build();
    }
}
