package com.celsia.dinamarca.api.rest.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public final class QRContent {

    @NotNull
    private String imei;

    @NotNull
    private String location;

    @NotNull
    private String content;

}
