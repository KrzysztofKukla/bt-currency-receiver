package pl.kukla.krzys.bluetrade.btcurrencyreceiver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.externalapi.ExternalCurrencyApi;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.gateway.CurrencyConverterClient;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyReceiverServiceImpl implements CurrencyReceiverService {
    private final ExternalCurrencyApi externalCurrencyApi;
    private final CurrencyConverterClient currencyConverterClient;

    @Override
    public CurrencyDto getCurrency(String base) {
        String currency = externalCurrencyApi.getCurrency(base);
        return currencyConverterClient.convertToCurrencyDto(currency);
    }

//    @Override
//    public CurrencyDto getCurrency() {
//        String latest = externalApiServiceFeignClient.getCurrency();
//        ExchangeRate exchangeRate;
//        try {
//            exchangeRate = new ObjectMapper().readValue(latest, ExchangeRate.class);
//
//        } catch (JsonProcessingException e) {
//            throw new CurrencyReceiverException(e.getMessage(), e);
//        }
//        System.out.println(exchangeRate);
//        return null;
//    }

}
