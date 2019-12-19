package com.celsia.dinamarca.api.rest.transform;

import com.celsia.dinamarca.api.rest.entity.QRContent;
import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.domain.service.Transformable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public final class QRContentMapper implements Transformable<QRModel, QRContent> {

    @Override
    public QRContent transform(QRModel model) {
        QRContent content = null;
        if (Objects.nonNull(model)) {
            content = new QRContent();
            content.setContent(model.getContent());
            content.setImei(model.getImei());
            content.setLocation(model.getLocation());
        }
        return content;
    }

}
