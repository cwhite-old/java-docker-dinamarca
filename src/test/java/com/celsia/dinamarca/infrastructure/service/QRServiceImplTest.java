package com.celsia.dinamarca.infrastructure.service;

import com.celsia.dinamarca.domain.model.QRModel;
import com.celsia.dinamarca.domain.repository.QRRepository;
import com.celsia.dinamarca.domain.service.QRService;
import com.celsia.dinamarca.fixture.ModelFactory;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public final class QRServiceImplTest {

    private static final String DEVICE = "CO-GLB-001";

    @Autowired
    private QRService service;

    @MockBean
    private QRRepository repository;

    @Test
    public void shouldReturnQRCodesByDevice() {
        QRModel model = ModelFactory.create();
        when(repository.findAllByDevice(DEVICE)).thenReturn(List.of(model));
        assertNotNull(service.findAllByDevice(DEVICE));
    }

    @Test
    public void shouldPersistAppointmentAtFirstAttempt() {
        QRModel model = ModelFactory.create();
        when(repository.save(model)).thenReturn(model);
        service.save(model);
        verify(repository, times(1)).save(model);
    }

    @Test
    public void shouldPersistAppointmentAtSecondAttempt() {
        QRModel model = ModelFactory.create();
        when(repository.save(model)).then(failUntilAttempt(1, model));
        service.save(model);
        verify(repository, times(2)).save(model);
    }

    @Test
    public void shouldPersistAppointmentAtThirdAttempt() {
        QRModel model = ModelFactory.create();
        when(repository.save(model)).then(failUntilAttempt(2, model));
        service.save(model);
        verify(repository, times(3)).save(model);
    }

    private static Answer<QRModel> failUntilAttempt(int attempts, QRModel model) {
        AtomicInteger counter = new AtomicInteger(0);
        return invocationOnMock -> {
            if (counter.incrementAndGet() <= attempts) {
                throw new IllegalStateException();
            }
            return model;
        };
    }

}
