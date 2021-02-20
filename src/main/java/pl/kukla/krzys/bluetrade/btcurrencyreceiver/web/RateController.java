package pl.kukla.krzys.bluetrade.btcurrencyreceiver.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.exception.CurrencyReceiverException;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.RateService;
import pl.kukla.krzys.bluetrade.btmodel.RateDto;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping(RateController.API_V1_RATE_URL)
@RequiredArgsConstructor
@Slf4j
public class RateController {

    static final String API_V1_RATE_URL = "/api/v1/rate";

    private final RateService rateService;

    @GetMapping("/{base}/{currency}")
    public RateDto getRate(@PathVariable String base, @PathVariable String currency) {
        log.info("Calling to get Rate details for {} base on {} currency", base, currency);
        try {
            return rateService.getRate(base, currency);
        } catch (Exception e) {
            throw new CurrencyReceiverException(e.getMessage(), e);
        }
    }

}
