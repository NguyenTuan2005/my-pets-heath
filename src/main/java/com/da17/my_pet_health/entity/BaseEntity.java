package com.da17.my_pet_health.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class BaseEntity {

    private Long id;
    @Builder.Default
    private Boolean isActive = true;
    @Builder.Default
    private Long createAt = Instant.now().toEpochMilli();
    @Builder.Default
    private Long updateAt = Instant.now().toEpochMilli();

    public void onUpdate() {
        this.updateAt = Instant.now().toEpochMilli();
    }

    public void toggleActive() {
        this.isActive = !this.isActive;
    }

    public LocalDateTime getUpdateAtAsLocalDateTime() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(updateAt), ZoneId.systemDefault());
    }

}
