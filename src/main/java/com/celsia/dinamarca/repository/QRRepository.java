package com.celsia.dinamarca.repository;

import com.celsia.dinamarca.repository.model.QRModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QRRepository extends MongoRepository<QRModel, String> {

    List<QRModel> findAllByDeviceIdEquals(String deviceId);
}
