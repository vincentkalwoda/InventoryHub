package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;

public class Supplier {
    @EmbeddedId
    private SupplierId supplierId;
    private String name;
    private Address address;
    private Email email;
    private String phone;

    @Embeddable
    public record SupplierId(@GeneratedValue @NotNull Long id){}
}
