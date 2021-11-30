package com.exchanger.currencyexchanger.services;

import com.exchanger.currencyexchanger.model.ApiResponseDto;
import com.exchanger.currencyexchanger.model.ExchangeRequestDto;
import com.exchanger.currencyexchanger.model.ExchangeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class ExchangeService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    public ExchangeResponseDto exchange(ExchangeRequestDto exchangeRequestDto){
        log.info("request dto in controller --> {}", exchangeRequestDto);

        String baseCurrency = exchangeRequestDto.getCurrency1().toUpperCase();

        String url = "https://freecurrencyapi.net/api/v2/latest?apikey=" + apiKey + "&base_currency=" + baseCurrency;
        ApiResponseDto response = restTemplate.getForObject(url, ApiResponseDto.class);

        if(response == null){
            throw new IllegalArgumentException("Currency 1 is invalid");
        }

        Double rate = response.getData().get(exchangeRequestDto.getCurrency2().toUpperCase());

        if(rate == null){
            throw new IllegalArgumentException("Currency 2 is invalid");
        }

        return new ExchangeResponseDto(rate);

    }
}
