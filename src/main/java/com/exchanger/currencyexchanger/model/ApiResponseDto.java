package com.exchanger.currencyexchanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {

    private Map<String, Double> data;
}
