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

        List<Battery> allBatteryWithtinRange = batteryService.findAll().    //Get all battery and apply the postcode filter criteria
                stream().
                filter(i->Integer.parseInt(i.getPostcode()) > start &&
                        Integer.parseInt(i.getPostcode())<end).
                collect(Collectors.toList());

        List<String> batteriesName = allBatteryWithtinRange.
                stream().
                map(Battery::getName).sorted().collect(Collectors.toList()); //filter list of batteries with name between two postcode range

        DoubleSummaryStatistics stats = allBatteryWithtinRange.stream() //calculating the summaryStatistics so that we can get sum, max,avg from a single object
                .mapToDouble(Battery::getCapacity)
                .summaryStatistics();

        Double totals = stats.getSum(); // getting sum value from the stat
        Double average = stats.getAverage(); //getting average value from the state

        BatteryResponseDto newResponse = new BatteryResponseDto(); // converting respone in BatterResponseDto format
        newResponse.setBatteriesName(batteriesName);
        newResponse.setAverage(average);
        newResponse.setSum(totals);
        return new ResponseEntity<>(newResponse,HttpStatus.OK);
    }
}
