package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.converter.ExchangeRateConverter;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.externalapi.ExternalCurrencyApi;
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

    @Override
    public CurrencyDto getCurrency(String base) {
        String currency = externalCurrencyApi.getCurrency(base);
        return exchangeRateConverter.convertToCurrencyDto(currency);
    }

}
