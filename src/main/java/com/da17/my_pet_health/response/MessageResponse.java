package com.da17.my_pet_health.response;

import com.da17.my_pet_health.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageResponse {
    private Boolean success;
    private Message message;
    private LocalDateTime timestamp;
}
