package sk.vlcik.booky.domain.entity;

import java.util.Arrays;

public enum Status {
    READ(1), UNREAD(2), PARTLY(3);

    private int value;

    Status(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status createStatus(int value){
        return Arrays
                .stream(values())
                .filter(status -> value == status.getValue())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
