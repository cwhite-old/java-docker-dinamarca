package com.celsia.dinamarca.fixture;

import com.celsia.dinamarca.domain.model.QRModel;

public final class ModelFactory {

    private ModelFactory() {}

    public static QRModel create() {
        QRModel model = new QRModel();
        model.setDevice("CO-GLB-001");
        model.setImei("1047-001");
        model.setLocation("(36.708064, -89.454365)");
        model.setContent("e2c9d97b2927a6ac7620f863fa2204bcce5eaae8");
        return model;
    }

}
