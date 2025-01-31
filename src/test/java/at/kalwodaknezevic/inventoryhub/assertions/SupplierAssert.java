package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import org.assertj.core.api.AbstractAssert;

public class SupplierAssert extends AbstractAssert<SupplierAssert, Supplier> {
    public SupplierAssert(Supplier supplier) {
        super(supplier, SupplierAssert.class);
    }

    public static SupplierAssert assertThat(Supplier actual) {
        return new SupplierAssert(actual);
    }

    public SupplierAssert hasValidCompanyName() {
        isNotNull();
        if (actual.getCompanyName() == null || actual.getCompanyName().isEmpty()) {
            failWithMessage("Expected supplier's company name to be not null and not empty but was <%s>", actual.getCompanyName());
        }
        return this;
    }

    public SupplierAssert hasValidSupplierId() {
        isNotNull();
        if (actual.getSupplierId() == null || actual.getSupplierId().id() == null) {
            failWithMessage("Expected supplier's ID to be not null but was <%s>", actual.getSupplierId());
        }
        return this;
    }

    public SupplierAssert hasValidFirstname() {
        isNotNull();
        if (actual.getFirstname() == null || actual.getFirstname().toString().isEmpty()) {
            failWithMessage("Expected supplier's first name to be not null and not empty but was <%s>", actual.getFirstname());
        }
        return this;
    }

    public SupplierAssert hasValidLastname() {
        isNotNull();
        if (actual.getLastname() == null || actual.getLastname().toString().isEmpty()) {
            failWithMessage("Expected supplier's last name to be not null and not empty but was <%s>", actual.getLastname());
        }
        return this;
    }

    public SupplierAssert hasValidEmail() {
        isNotNull();
        if (actual.getEmail() == null || actual.getEmail().toString().isEmpty()) {
            failWithMessage("Expected supplier's email to be not null and not empty but was <%s>", actual.getEmail());
        }
        return this;
    }

    public SupplierAssert hasValidPhoneNumber() {
        isNotNull();
        if (actual.getPhoneNumber() == null || actual.getPhoneNumber().toString().isEmpty()) {
            failWithMessage("Expected supplier's phone number to be not null and not empty but was <%s>", actual.getPhoneNumber());
        }
        return this;
    }

    public SupplierAssert hasValidAddress() {
        isNotNull();
        if (actual.getAddress() == null) {
            failWithMessage("Expected supplier's address to be not null but was <%s>", actual.getAddress());
        }
        return this;
    }
}