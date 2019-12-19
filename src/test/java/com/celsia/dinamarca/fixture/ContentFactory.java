package com.celsia.dinamarca.fixture;

import com.celsia.dinamarca.api.rest.entity.QRContent;

public final class ContentFactory {

    private ContentFactory() {}

    public static QRContent create() {
        QRContent content = new QRContent();
        content.setImei("1047-001");
        content.setLocation("(36.708064, -89.454365)");
        content.setContent("e2c9d97b2927a6ac7620f863fa2204bcce5eaae8");
        return content;
    }

}
