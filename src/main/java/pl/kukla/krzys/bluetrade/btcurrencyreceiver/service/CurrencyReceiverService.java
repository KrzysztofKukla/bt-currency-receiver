package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service;

import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

/**
 * @author Krzysztof Kukla
 */
public interface CurrencyReceiverService {

    CurrencyDto getCurrency(String base);

}
