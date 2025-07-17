package com.match.matchodds.mapper;

import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class OptionalUtils {

    public static <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

}
