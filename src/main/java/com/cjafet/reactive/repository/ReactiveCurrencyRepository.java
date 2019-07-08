package com.cjafet.reactive.repository;

import com.cjafet.reactive.model.Currency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("currency")
@Repository
public interface ReactiveCurrencyRepository extends ReactiveCrudRepository<Currency, Long> {
}
