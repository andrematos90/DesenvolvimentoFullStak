package com.todolist.list.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, String> {
    @Override
    public String convertToDatabaseColumn(Duration duration) {
        if (duration == null) {
            return null;
        }
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60; // Calcula os minutos restantes após as horas
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public Duration convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(":");
        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);
        return Duration.ofHours(hours).plusMinutes(minutes);
    }
}