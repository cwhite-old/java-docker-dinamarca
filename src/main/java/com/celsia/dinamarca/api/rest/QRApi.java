package com.celsia.dinamarca.api.rest;

<<<<<<< HEAD
import com.celsia.dinamarca.config.Documented;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
=======
import com.celsia.dinamarca.api.rest.entity.QRContent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
>>>>>>> origin/dev

import java.util.Collection;
import java.util.Collections;

<<<<<<< HEAD
@Documented
@RestController("/qr-api/v1/codes/{device}")
=======
@RestController
@RequestMapping("/qr-api/v1/codes/{device}")
>>>>>>> origin/dev
public final class QRApi {

    @GetMapping
    public Collection<String> getQRCodes(@PathVariable("device") final String device) {
        return Collections.emptyList();
    }

    @PostMapping
    public ResponseEntity postQRCode(@PathVariable("device") final String device, @RequestBody final QRContent content) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
