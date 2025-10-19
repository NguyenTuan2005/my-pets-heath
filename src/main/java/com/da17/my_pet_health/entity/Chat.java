package com.da17.my_pet_health.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Chat extends BaseEntity {
    private String userName;
    private List<Message> messages;
    private Integer unreadCount;
}
