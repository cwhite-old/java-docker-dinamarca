package com.celsia.dinamarca.service;

import com.celsia.dinamarca.repository.QRRepository;
import com.celsia.dinamarca.repository.model.QRModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QRServiceImpl implements QRService {

    private QRRepository repository;

    @Autowired
    public QRServiceImpl(QRRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<QRModel> findAllByDeviceId(final String deviceId) {
        return repository.findAllByDeviceIdEquals(deviceId);
    }
}
