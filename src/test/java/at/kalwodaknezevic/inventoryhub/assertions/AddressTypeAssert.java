package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.AddressType;
import org.assertj.core.api.AbstractAssert;

public class AddressTypeAssert extends AbstractAssert<AddressTypeAssert, AddressType> {
    public AddressTypeAssert(AddressType addressType) {
        super(addressType, AddressTypeAssert.class);
    }

    public static AddressTypeAssert assertThat(AddressType actual) {
        return new AddressTypeAssert(actual);
    }

    public AddressTypeAssert isValidAddressType() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected address type to be not null but was null");
        }
        return this;
    }
}
