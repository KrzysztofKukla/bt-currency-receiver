package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.exception.InvalidCurrencyException;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.CurrencyReceiverService;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.RateService;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyEnum;
import pl.kukla.krzys.bluetrade.btmodel.RateDto;

import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RateServiceFacade implements RateService {

    private final CurrencyReceiverService currencyReceiverService;

    @Override
    public RateDto getRate(String base, String currency) {
        CurrencyDto valueByBase = currencyReceiverService.getValueByBase(base);
        Set<RateDto> rates = valueByBase.getRates();
        return rates.stream()
            .filter(r -> r.getRate() == CurrencyEnum.valueOf(currency))
            .findFirst()
            .orElseThrow(() -> new InvalidCurrencyException("Cannot find currency " + base + "->" + currency));
    }

}
