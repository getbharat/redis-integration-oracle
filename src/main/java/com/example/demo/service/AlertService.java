package com.example.demo.service;

import com.example.demo.model.Alert;
import com.example.demo.model.AlertResponse;


public interface AlertService {

    AlertResponse getAlertsByCustomerId(final Long customerId);
    Alert saveAlert(final Alert alert, final Long customerId);
    Alert getAlertById(final Long alertId);

}
