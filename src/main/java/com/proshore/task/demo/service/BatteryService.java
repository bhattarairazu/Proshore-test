package com.proshore.task.demo.service;

import com.proshore.task.demo.model.Battery;
import com.proshore.task.demo.model.dto.BatteryResponseDto;

import java.util.List;

public interface BatteryService {
    List<Battery> saveAll(List<Battery> batteries);

    BatteryResponseDto findAllBatteryByPostcodeBetweenRange(Integer start, Integer end);

}
