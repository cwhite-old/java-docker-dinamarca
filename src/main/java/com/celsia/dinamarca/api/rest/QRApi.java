package com.celsia.dinamarca.api.rest;

import com.celsia.dinamarca.api.rest.entity.QRContent;
import com.celsia.dinamarca.api.rest.transform.QRContentMapper;
import com.celsia.dinamarca.api.rest.transform.QRModelMapper;
import com.celsia.dinamarca.config.Documented;
import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.domain.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Documented
@RestController
@RequestMapping("/qr-api/v1/codes/{device}")
public final class QRApi {

    private final QRService service;
    private final QRContentMapper qrContentMapper;
    private final QRModelMapper qrModelMapper;

    @Autowired
    public QRApi(final QRService service, final QRContentMapper qrContentMapper, final QRModelMapper qrModelMapper) {
        this.service = service;
        this.qrContentMapper = qrContentMapper;
        this.qrModelMapper = qrModelMapper;
    }

    @GetMapping
    public ResponseEntity<Collection<QRContent>> getQRCodes(@PathVariable("device") final String device) {
        return ResponseEntity.ok(qrContentMapper.transform(service.findAllByDevice(device)));
    }

    @PostMapping
    public void postQRCode(@PathVariable("device") final String device, @RequestBody final QRContent content) {
        QRModel model = qrModelMapper.transform(content);
        model.setDevice(device);
        service.save(model);
    }

}
