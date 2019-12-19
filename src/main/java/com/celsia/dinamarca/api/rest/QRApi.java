package com.celsia.dinamarca.api.rest;

import com.celsia.dinamarca.config.Documented;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.celsia.dinamarca.api.rest.entity.QRContent;
import com.celsia.dinamarca.repository.model.QRModel;
import com.celsia.dinamarca.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@Documented
@RestController
@RequestMapping("/qr-api/v1/codes/{device}")
public final class QRApi {

    private QRService qrService;

    @Autowired
    public QRApi(QRService qrService) {
        this.qrService = qrService;
    }

    @GetMapping
    public ResponseEntity<Collection<QRModel>> getQRCodes(@PathVariable("device") final String device) {
        return ResponseEntity.ok(qrService.findAllByDeviceId(device));
    }

    @PostMapping
    public ResponseEntity postQRCode(@PathVariable("device") final String device, @RequestBody final QRContent content) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
