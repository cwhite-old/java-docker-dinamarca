package com.celsia.dinamarca.service;

import com.celsia.dinamarca.repository.model.QRModel;

import java.util.List;

public interface QRService {

    List<QRModel> findAllByDeviceId(String deviceId);
}
