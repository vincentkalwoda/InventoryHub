package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Email;
import org.assertj.core.api.AbstractAssert;

public class EmailAssert extends AbstractAssert<EmailAssert, Email> {
    public EmailAssert(Email email) {
        super(email, EmailAssert.class);
    }

    public static EmailAssert assertThat(Email actual) {
        return new EmailAssert(actual);
    }

    public EmailAssert isValidEmail() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected email to be not null but was null");
        }
        return this;
    }
}
