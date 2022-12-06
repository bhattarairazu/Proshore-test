package com.proshore.task.demo.service;

import com.proshore.task.demo.model.Battery;
import com.proshore.task.demo.model.dto.BatteryResponseDto;
import com.proshore.task.demo.repository.BatteryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BatteryServiceImpl implements BatteryService{

    private BatteryRepository batteryRepository;


    @Override
    public List<Battery> saveAll(List<Battery> batteries) {
        return batteryRepository.saveAll(batteries);
    }

    @Override
    public BatteryResponseDto findAll(Integer start, Integer end) {
        List<Battery> allBatteryWithinRange = batteryRepository.findAllByPostcodeBetween(start,end);

        List<String> batteriesName = allBatteryWithinRange.
                stream().
                map(Battery::getName).collect(Collectors.toList()); //filter list of batteries with name between two postcode range

        DoubleSummaryStatistics stats = allBatteryWithinRange.stream() //calculating the summaryStatistics so that we can get sum, max,avg from a single object
                .mapToDouble(Battery::getCapacity)
                .summaryStatistics();

        Double totals = stats.getSum(); // getting sum value from the stat
        Double average = stats.getAverage(); //getting average value from the state

        BatteryResponseDto newResponse = new BatteryResponseDto(); // converting respone in BatterResponseDto format
        newResponse.setBatteriesName(batteriesName);
        newResponse.setAverage(average);
        newResponse.setSum(totals);
        return newResponse;
    }


}
