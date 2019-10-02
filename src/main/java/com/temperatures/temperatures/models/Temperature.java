package com.temperatures.temperatures.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "temperatures")
public class Temperature {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private Float Temperature;
    @CreationTimestamp
    @Column(name = "create_date")
    private Date CreateDate;
    @UpdateTimestamp
    @Column(name = "update_date")
    private Date UpdateDate;

    public Temperature() { }

    public Temperature(TemperatureRequest request) {
        Temperature = request.getTemperature();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer value) {
        Id = value;
    }

    public Float getTemperature() {
        return Temperature;
    }

    public void setTemperature(Float value) {
        Temperature = value;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date value) {
        CreateDate = value;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date value) {
        UpdateDate = value;
    }
}
