package com.da17.my_pet_health.dto;

import com.da17.my_pet_health.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DoctorMessage extends Message {
    private String doctorName;

    @Override
    public Boolean isRequest() {
        return false;
    }

    @Override
    public Boolean isResponse() {
        return true;
    }
}
