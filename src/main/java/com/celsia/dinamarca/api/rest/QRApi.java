package com.celsia.dinamarca.api.rest;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/qr-api/v1/codes/{device}")
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
