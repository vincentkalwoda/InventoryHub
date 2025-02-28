package at.kalwodaknezevic.inventoryhub.assertions;

public class Assertions extends org.assertj.core.api.Assertions {
    public static ArticleAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Article actual) {
        return new ArticleAssert(actual);
    }

    public static OrderAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Order actual) {
        return new OrderAssert(actual);
    }

    public static OrderItemAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.OrderItem actual) {
        return new OrderItemAssert(actual);
    }

    public static OrderStatusAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.OrderStatus actual) {
        return new OrderStatusAssert(actual);
    }

    public static SupplierAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Supplier actual) {
        return new SupplierAssert(actual);
    }

    public static EmployeeAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Employee actual) {
        return new EmployeeAssert(actual);
    }

    public static CategoryAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Category actual) {
        return new CategoryAssert(actual);
    }

    public static CountryAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Country actual) {
        return new CountryAssert(actual);
    }

    public static PhoneNumberAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.PhoneNumber actual) {
        return new PhoneNumberAssert(actual);
    }

    public static NameAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Name actual) {
        return new NameAssert(actual);
    }

    public static PhoneTypeAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.PhoneType actual) {
        return new PhoneTypeAssert(actual);
    }

    public static AddressAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Address actual) {
        return new AddressAssert(actual);
    }

    public static EmailAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.Email actual) {
        return new EmailAssert(actual);
    }

    public static AddressTypeAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.AddressType actual) {
        return new AddressTypeAssert(actual);
    }

    public static ApiKeyAssert assertThat(at.kalwodaknezevic.inventoryhub.domain.ApiKey actual) {
        return new ApiKeyAssert(actual);
    }
}
