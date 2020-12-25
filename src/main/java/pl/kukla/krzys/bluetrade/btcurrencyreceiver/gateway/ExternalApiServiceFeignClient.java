package pl.kukla.krzys.bluetrade.btcurrencyreceiver.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Krzysztof Kukla
 */
@FeignClient(name = "currency-external", url = "${currency.external.api.url}")
public interface ExternalApiServiceFeignClient {

    @GetMapping("/latest?base={base}")
    String getCurrency(@RequestParam("base") String base);

}
