package domain.model.vo;

public record Identification(String value) {
    public Identification{
        if(value ==  null || value.isBlank()) {
            throw new IllegalArgumentException("Identification cannot be empty");
        }
        if(value.length() != 10) {
            throw new IllegalArgumentException("Identification length must be 10 digits");
        }
        if(!value.matches("[0-9]+")) {
            throw new IllegalArgumentException("Identification number must be a positive integer");
        }
    }
}
