package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.PhoneType;
import org.assertj.core.api.AbstractAssert;

public class PhoneTypeAssert extends AbstractAssert<PhoneTypeAssert, PhoneType> {
    public PhoneTypeAssert(PhoneType phoneType) {
        super(phoneType, PhoneTypeAssert.class);
    }

    public static PhoneTypeAssert assertThat(PhoneType actual) {
        return new PhoneTypeAssert(actual);
    }

    public PhoneTypeAssert isValidPhoneType() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected phone type to be not null but was null");
        }
        return this;
    }
}
