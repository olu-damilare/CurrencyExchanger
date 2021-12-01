package com.exchanger.currencyexchanger.controller;

import com.exchanger.currencyexchanger.model.ExchangeRequestDto;
import com.exchanger.currencyexchanger.model.ExchangeResponseDto;
import com.exchanger.currencyexchanger.services.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
@Slf4j
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @PostMapping("/exchange-rate/")
    public ResponseEntity<?> exchange(@RequestBody ExchangeRequestDto requestDto){
        log.info("request dto in controller --> {}", requestDto);
        try{
            ExchangeResponseDto response = exchangeService.exchange(requestDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
