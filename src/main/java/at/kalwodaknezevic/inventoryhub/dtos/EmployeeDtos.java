package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Name;

public class EmployeeDtos {
    public record Minimal(Name firstname, Name lastname) {

    }
}
