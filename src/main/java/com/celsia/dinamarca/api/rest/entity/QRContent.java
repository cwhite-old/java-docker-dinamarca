package com.celsia.dinamarca.api.rest.entity;

import lombok.Data;

@Data
public class QRContent {
    private String imei;
    private String location;
    private String qr;
}
