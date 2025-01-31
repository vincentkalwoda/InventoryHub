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
}
