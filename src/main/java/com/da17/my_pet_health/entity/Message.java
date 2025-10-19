package com.da17.my_pet_health.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Message extends BaseEntity {
    private String content;

    public Boolean isRequest() {
        return true;
    }

    public Boolean isResponse() {
        return false;
    }
}

