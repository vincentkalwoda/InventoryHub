package at.kalwodaknezevic.inventoryhub.foundation;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class JavaTimeFactory {

    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    public LocalDate today() {
        return LocalDate.now();
    }

    public LocalTime currentTime() {
        return LocalTime.now();
    }
}
