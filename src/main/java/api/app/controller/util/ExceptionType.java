package api.app.controller.util;

public enum ExceptionType {

    ADDED("added"),
    UPDATED("updated"),
    DELETED("deleted");

    String value;
    ExceptionType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
