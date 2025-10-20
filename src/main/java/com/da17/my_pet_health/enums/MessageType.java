package com.da17.my_pet_health.enums;

public enum MessageType {
    isRequest,
    isResponse;

    public Boolean isRequest() {
        return this == isRequest;
    }

    public Boolean isResponse() {
        return this == isResponse;
    }
}
