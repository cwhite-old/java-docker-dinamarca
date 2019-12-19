package com.celsia.dinamarca.domain.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class TransformableTest {

    private static final String JOHN_DOE = "John Doe";
    private static final String JANE_DOE = "Jane Doe";

    private static final class Source {

        private String name;

        Source(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private static final class Destination {

        private String description;

        Destination(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

    }

    @Test
    public void shouldThrowExceptionWhenCollectionIsNull() {
        assertThrows(NullPointerException.class, () -> Transformable.transform(null, source -> new Destination(JANE_DOE)));
    }

    @Test
    public void shouldThrowExceptionWhenMappingFunctionIsNull() {
        assertThrows(NullPointerException.class, () -> Transformable.transform(Collections.singletonList(new Source(JANE_DOE)), null));
    }

    @Test
    public void shouldThrowExceptionWhenCollectionAndMappingFunctionAreNull() {
        assertThrows(NullPointerException.class, () -> Transformable.transform(null, null));
    }

    @Test
    public void shouldTranslateSourceIntoDestination() {
        Transformable<Source, Destination> translator = source -> new Destination(source.getName());
        Destination actual = translator.transform(new Source(JANE_DOE));
        assertNotNull(actual);
        assertEquals(JANE_DOE, actual.getDescription());
    }

    @Test
    public void shouldTranslateSourceIntoDestinationArray() {
        Transformable<Source, Destination> translator = source -> new Destination(source.getName());
        List<Destination> actual = translator.transform(Arrays.asList(new Source(JANE_DOE), new Source(JOHN_DOE)));
        assertNotNull(actual);
        assertIterableEquals(Arrays.asList(JANE_DOE, JOHN_DOE), actual.stream().map(Destination::getDescription).collect(Collectors.toList()));
    }

    @Test
    public void shouldTranslateSourceIntoDestinationArrayUsingCustomTranslator() {
        List<Destination> actual = Transformable.transform(Arrays.asList(new Source(JANE_DOE), new Source(JOHN_DOE)), source -> new Destination(source.getName()));
        assertNotNull(actual);
        assertIterableEquals(Arrays.asList(JANE_DOE, JOHN_DOE), actual.stream().map(Destination::getDescription).collect(Collectors.toList()));
    }

}
