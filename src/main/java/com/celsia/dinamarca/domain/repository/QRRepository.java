package com.celsia.dinamarca.domain.repository;

import com.celsia.dinamarca.domain.model.QRModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QRRepository extends MongoRepository<QRModel, String> {

    List<QRModel> findAllByDevice(String device);

}
