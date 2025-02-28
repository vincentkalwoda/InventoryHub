package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import org.assertj.core.api.AbstractAssert;

public class ApiKeyAssert extends AbstractAssert<ApiKeyAssert, ApiKey> {
    public ApiKeyAssert(ApiKey apiKey) {
        super(apiKey, ApiKeyAssert.class);
    }

    public static ApiKeyAssert assertThat(ApiKey actual) {
        return new ApiKeyAssert(actual);
    }

    public ApiKeyAssert isValidApiKey() {
        isNotNull();
        if (actual == null) {
            failWithMessage("Expected apiKey to be not null but was null");
        }
        return this;
    }
}
