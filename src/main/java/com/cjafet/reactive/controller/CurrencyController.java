package com.cjafet.reactive.controller;

import com.cjafet.reactive.repository.ReactiveCurrencyRepository;
import com.cjafet.reactive.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

/*    @Autowired
    private ICurrencyService iCurrencyService;*/

    @Autowired
    @Qualifier("currency")
    ReactiveCurrencyRepository reactiveCurrencyRepository;


    @GetMapping
    public @ResponseBody Flux<Currency> list() {
        return reactiveCurrencyRepository.findAll();
    }


    @PostMapping
    public @ResponseBody Mono<Currency> add(@RequestBody Currency currency) {
        return reactiveCurrencyRepository.save(currency);
    }
}
