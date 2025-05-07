package org.example.calories.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String serviceName;
    @Column
    private Date dateFrom;
    @Column
    private Date dateTo;

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Long getId() {
        return id;
    }

    @Deprecated
    public Subscribe() {
    }
}
