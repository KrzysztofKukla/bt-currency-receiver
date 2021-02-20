package pl.kukla.krzys.bluetrade.btcurrencyreceiver.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.bluetrade.btmodel.RateDto;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping(RateController.API_V1_RATE_URL)
public class RateController {

    static final String API_V1_RATE_URL = "/api/v1/rate";

    public RateDto getRate(@PathVariable String base, @PathVariable String currency) {
        return null;
    }

}
