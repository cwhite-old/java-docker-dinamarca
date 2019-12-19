package com.celsia.dinamarca.api.rest.transform;

import com.celsia.dinamarca.api.rest.entity.QRContent;
import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.fixture.ContentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public final class QRModelMapperTest {

    private final QRModelMapper mapper = new QRModelMapper();

    @Test
    void shouldReturnNullWhenTransformingNullDataObject() {
        assertNull(mapper.transform((QRContent) null));
    }

    @Test
    void shouldReturnQRModelWhenTransformingAnyQRContent() {
        QRContent content = ContentFactory.create();
        QRModel model = mapper.transform(content);
        assertNotNull(model);
        assertEquals(content.getContent(), model.getContent());
        assertEquals(content.getImei(), model.getImei());
        assertEquals(content.getLocation(), model.getLocation());
    }

}
