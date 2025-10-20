package com.da17.my_pet_health.entity;

import com.da17.my_pet_health.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Message extends BaseEntity {
    private String content;
    @Builder.Default
    private MessageType type = MessageType.isRequest;
}

