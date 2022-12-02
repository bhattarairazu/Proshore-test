package com.proshore.task.demo.service;

import com.proshore.task.demo.model.Battery;

import java.util.List;

public interface BatteryService {
    List<Battery> saveAll(List<Battery> batteries);

    List<Battery> findAll();

}
