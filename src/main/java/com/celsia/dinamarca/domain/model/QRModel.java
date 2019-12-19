package com.celsia.dinamarca.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "QRCode")
public final class QRModel {

    @Id
    private String id;
    private String device;
    private String imei;
    private String location;
    private String content;

}
