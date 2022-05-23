package com.example.demo.repository;

import com.example.demo.model.Alert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AlertRepository extends CrudRepository<Alert,Long> {

    @Query(value = "select * from Alert a where a.customer_id = :customerId", nativeQuery = true)
    Stream<Alert> findAlertsByCustomer(@Param("customerId") final Long customerId);
}
