package com.example.demo.service.impl;

import com.example.demo.model.Alert;
import com.example.demo.model.AlertResponse;
import com.example.demo.service.AlertService;
import com.example.demo.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Override
    @Transactional
    @Cacheable(cacheNames = "alert", key = "#customerId", cacheManager = "alertCacheManager")
    public AlertResponse getAlertsByCustomerId(final Long customerId) {
        final List<Alert> alerts = alertRepository.findAlertsByCustomer(customerId).collect(Collectors.toList());
        final AlertResponse alertResponse = new AlertResponse();
        alertResponse.setCustomerId(customerId);
        alertResponse.setList(alerts);
        return alertResponse;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "alert", key= "#customerId", cacheManager = "alertCacheManager")
    public Alert saveAlert(final Alert alert, final Long customerId) {
        return alertRepository.save(alert);
    }

    @Override
    @Transactional
    public Alert getAlertById(final Long alertId) {
        return alertRepository.findById(alertId).orElse(null);
    }
}
