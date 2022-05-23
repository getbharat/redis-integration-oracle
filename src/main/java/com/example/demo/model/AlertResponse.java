package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@RedisHash
public class AlertResponse implements Serializable {
    private List<Alert> list;
    private Long customerId;

    public List<Alert> getList() {
        return list;
    }

    public void setList(List<Alert> list) {
        this.list = list;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }
}
