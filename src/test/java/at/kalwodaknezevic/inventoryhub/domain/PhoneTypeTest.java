package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTypeTest {

    @Test
    void testPhoneTypeAssertions() {
        PhoneType phoneType = PhoneType.MOBILE;

        assertNotNull(phoneType);
    }
}