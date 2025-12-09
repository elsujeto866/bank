package domain.model.vo;

public record Password(String value) {
    public Password{
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if(value.length() < 4) {
            throw new IllegalArgumentException("Password must be at least 4 characters");
        }
    }
}
