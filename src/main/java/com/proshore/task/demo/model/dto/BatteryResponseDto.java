package com.proshore.task.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryResponseDto {
    Double average;
    Double sum;
    List<String> batteriesName = new ArrayList<>();
}
