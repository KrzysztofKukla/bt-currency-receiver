package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service;

import pl.kukla.krzys.bluetrade.btmodel.RateDto;

/**
 * @author Krzysztof Kukla
 */
public interface RateService {

    RateDto getRate(String base, String currency);

}
