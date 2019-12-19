package com.celsia.dinamarca.infrastructure.service;

import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.domain.repository.QRRepository;
import com.celsia.dinamarca.domain.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class QRServiceImpl implements QRService {

    private final QRRepository repository;
    private final RetryTemplate retryTemplate;

    @Autowired
    public QRServiceImpl(final QRRepository repository, final RetryTemplate retryTemplate) {
        this.repository = repository;
        this.retryTemplate = retryTemplate;
    }

    @Override
    public List<QRModel> findAllByDevice(final String device) {
        return repository.findAllByDevice(device);
    }

    @Override
    public QRModel save(QRModel model) {
        return retryTemplate.execute(context -> repository.save(model));
    }

}
