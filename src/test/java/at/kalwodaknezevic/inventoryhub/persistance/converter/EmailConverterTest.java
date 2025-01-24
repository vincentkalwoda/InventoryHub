package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Email;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailConverterTest {

    private EmailConverter emailConverter = new EmailConverter();

    @Test
    void when_convert_a_valid_email_to_db_data_returns_content() {
        // arrange
        String emailValue = "kal210629@spengergasse.at";
        Email email = new Email(emailValue);

        // act
        var convertedValue = emailConverter.convertToDatabaseColumn(email);

        // assert
        assertThat(convertedValue).isEqualTo(emailValue);
    }

    @Test
    void when_convert_a_null_email_to_db_data_returns_null() {
        // expect
        assertThat(emailConverter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void when_convert_a_valid_email_value_to_a_email_instance() {
        // arrange
        String emailValue = "kal210629@spengergasse.at";

        // act
        var convertedValue = emailConverter.convertToEntityAttribute(emailValue);

        // assert
        assertThat(convertedValue.value()).isEqualTo(emailValue);
    }

    @Test
    void when_convert_a_null_email_value_to_a_email_returns_null() {
        // expect
        assertThat(emailConverter.convertToEntityAttribute(null)).isNull();
    }
}