package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.CurrencyValueCalculator;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;
import pl.kukla.krzys.bluetrade.btmodel.RateDto;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
public class CurrencyValueCalculatorImpl implements CurrencyValueCalculator {
    @Override
    public CurrencyDto calculate(CurrencyDto currencyDto) {
        currencyDto.setRates(calculateRates(currencyDto.getRates()));
        return currencyDto;
    }

    private Set<RateDto> calculateRates(Set<RateDto> rates) {
        rates.forEach(i -> i.setValue(calculateValue(i.getValue())));
        return rates;
    }

    private BigDecimal calculateValue(BigDecimal value) {
        return BigDecimal.valueOf(1 / value.doubleValue());
    }

}
