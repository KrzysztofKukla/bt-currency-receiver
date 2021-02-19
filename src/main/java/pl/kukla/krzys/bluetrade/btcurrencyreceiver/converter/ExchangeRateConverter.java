package pl.kukla.krzys.bluetrade.btcurrencyreceiver.converter;

import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

/**
 * @author Krzysztof Kukla
 */
public interface ExchangeRateConverter {
    CurrencyDto convertToCurrencyDto(String currencyMessage);
}
