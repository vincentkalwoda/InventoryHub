package at.kalwodaknezevic.inventoryhub.domain;

import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class AddressTypeTest {

    @Test
    void testAddressTypeAssertions() {
        AddressType addressType = AddressType.BILLING;

        assertThat(addressType)
                .isValidAddressType();
    }

}