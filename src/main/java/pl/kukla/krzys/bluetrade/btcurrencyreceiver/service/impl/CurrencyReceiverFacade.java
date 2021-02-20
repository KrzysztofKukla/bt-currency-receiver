package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.converter.ExchangeRateConverter;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.externalapi.ExternalCurrencyApi;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.CurrencyReceiverService;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.CurrencyValueCalculator;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyReceiverFacade implements CurrencyReceiverService {
    private final ExternalCurrencyApi externalCurrencyApi;
    private final ExchangeRateConverter exchangeRateConverter;
    private final CurrencyValueCalculator currencyValueCalculator;

    @Override
    public CurrencyDto getCurrency(String base) {
        return convertBaseToCurrencyDto(base);
    }

    @Override
    public CurrencyDto getValueByBase(String base) {
        CurrencyDto currencyDto = convertBaseToCurrencyDto(base);
        return currencyValueCalculator.calculate(currencyDto);

    }

    private CurrencyDto convertBaseToCurrencyDto(String base) {
        String currency = externalCurrencyApi.getCurrency(base);
        return exchangeRateConverter.convertToCurrencyDto(currency);
    }

}
