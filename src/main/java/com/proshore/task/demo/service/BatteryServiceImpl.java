package com.proshore.task.demo.service;

import com.proshore.task.demo.model.Battery;
import com.proshore.task.demo.repository.BatteryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BatteryServiceImpl implements BatteryService{

    private BatteryRepository batteryRepository;


    @Override
    public List<Battery> saveAll(List<Battery> batteries) {
        return batteryRepository.saveAll(batteries);
    }

    @Override
    public List<Battery> findAll() {
        return batteryRepository.findAll();
    }


}
