package com.celsia.dinamarca.api.rest;

import com.celsia.dinamarca.config.Documented;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@Documented
@RestController("/qr-api/v1/codes/{device}")
public final class QRApi {

    @GetMapping
    public Collection<String> getQRCodes(@PathVariable("device") final String device) {
        return Collections.emptyList();
    }

    @PostMapping
    public void postQRCode(@PathVariable("device") final String device, @RequestBody final String content) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
