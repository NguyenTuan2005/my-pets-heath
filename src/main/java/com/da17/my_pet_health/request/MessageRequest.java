package com.da17.my_pet_health.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageRequest {
    private Long chatId;
    private String messageContent;
}
