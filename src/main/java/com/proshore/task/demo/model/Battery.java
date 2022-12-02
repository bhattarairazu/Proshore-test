package com.proshore.task.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Battery {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String postcode;
    private Double capacity;
}
