package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Name;
import org.assertj.core.api.AbstractAssert;

public class NameAssert extends AbstractAssert<NameAssert, Name> {
    public NameAssert(Name name) {
        super(name, NameAssert.class);
    }

    public static NameAssert assertThat(Name actual) {
        return new NameAssert(actual);
    }

    public NameAssert hasValidFirstname() {
        if (actual.firstname() == null) {
            failWithMessage("Expected name to have a valid firstname, but was null");
        }
        return this;
    }

    public NameAssert hasValidLastname() {
        if (actual.lastname() == null) {
            failWithMessage("Expected name to have a valid lastname, but was null");
        }
        return this;
    }
}
