package domain.model.vo;

public record Address(String value) {
    public Address {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }

    }
}
