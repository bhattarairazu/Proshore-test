package com.proshore.task.demo.controller;

import com.proshore.task.demo.model.Battery;
import com.proshore.task.demo.model.dto.BatteryResponseDto;
import com.proshore.task.demo.service.BatteryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/battery")
public class BatteryController {

    private BatteryService batteryService;

    @PostMapping("/save")
    public ResponseEntity<List<Battery>> saveBattery(@RequestBody List<Battery> batteries){
        return new ResponseEntity<>(batteryService.saveAll(batteries), HttpStatus.CREATED);
    }

    @GetMapping("/postcode")
    public ResponseEntity<BatteryResponseDto> getBatteriesWithinPostcodeRange(@RequestParam("start") Integer start, @RequestParam("end") Integer end){
        return new ResponseEntity<>(batteryService.findAll(start,end),HttpStatus.OK);
    }
}
