package com.celsia.dinamarca.api.rest.transform;

import com.celsia.dinamarca.api.rest.entity.QRContent;
import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.domain.service.Transformable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public final class QRModelMapper implements Transformable<QRContent, QRModel> {

    @Override
    public QRModel transform(QRContent content) {
        QRModel model = null;
        if (Objects.nonNull(content)) {
            model = new QRModel();
            model.setContent(content.getContent());
            model.setImei(content.getImei());
            model.setLocation(content.getLocation());
        }
        return model;
    }

}
