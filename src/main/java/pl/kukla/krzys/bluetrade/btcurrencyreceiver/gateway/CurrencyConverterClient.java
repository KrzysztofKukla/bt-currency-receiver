package pl.kukla.krzys.bluetrade.btcurrencyreceiver.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

/**
 * @author Krzysztof Kukla
 */
@FeignClient(name = "bt-currency-converter", url = "${bt.currency-converter.url}")
public interface CurrencyConverterClient {

    @GetMapping("/api/v1/currency-converter/latest/{currency}")
    CurrencyDto convertToCurrencyDto(@PathVariable String currency);

}
