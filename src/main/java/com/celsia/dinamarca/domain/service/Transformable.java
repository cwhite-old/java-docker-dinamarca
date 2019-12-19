package com.celsia.dinamarca.domain.service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
public interface Transformable<T, R> {

    R transform(T t);

    default List<R> transform(List<T> collection) {
        return transform(collection, this::transform);
    }

    static <T, R> List<R> transform(List<T> collection, Function<T, R> transformer) {
        Objects.requireNonNull(collection);
        Objects.requireNonNull(transformer);
        return collection.stream()
                .map(transformer)
                .collect(Collectors.toList());
    }

}
