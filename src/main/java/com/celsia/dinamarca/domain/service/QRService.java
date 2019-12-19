package com.celsia.dinamarca.domain.service;

import com.celsia.dinamarca.domain.model.QRModel;

import java.util.List;

public interface QRService {

    List<QRModel> findAllByDevice(String device);

    QRModel save(QRModel model);

}
