package com.celsia.dinamarca.api.rest.transform;

import com.celsia.dinamarca.api.rest.entity.QRContent;
import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.fixture.ModelFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public final class QRContentMapperTest {

    private final QRContentMapper mapper = new QRContentMapper();

    @Test
    void shouldReturnNullWhenTransformingNullEntity() {
        assertNull(mapper.transform((QRModel) null));
    }

    @Test
    void shouldReturnQRContentWhenTransformingAnyEntity() {
        QRModel model = ModelFactory.create();
        QRContent content = mapper.transform(model);
        assertNotNull(content);
        assertEquals(model.getContent(), content.getContent());
        assertEquals(model.getImei(), content.getImei());
        assertEquals(model.getLocation(), content.getLocation());
    }

}
