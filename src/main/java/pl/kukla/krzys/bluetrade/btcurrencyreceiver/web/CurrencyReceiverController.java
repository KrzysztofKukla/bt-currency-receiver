package pl.kukla.krzys.bluetrade.btcurrencyreceiver.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.CurrencyReceiverService;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

import static pl.kukla.krzys.bluetrade.btcurrencyreceiver.web.CurrencyReceiverController.API_V1_URL;

/**
 * @author Krzysztof Kukla
 */

@RestController
@RequestMapping(API_V1_URL)
@Slf4j
@RequiredArgsConstructor
public class CurrencyReceiverController {
    static final String API_V1_URL = "/api/v1";

    private final CurrencyReceiverService currencyReceiverService;

    @GetMapping("/latest")
    public CurrencyDto getCurrency(@RequestParam(value = "base", required = false) String base) {
        String currency = StringUtils.isNotEmpty(base) ? base : "EUR";
        log.info("Getting latest currencies value for {}", currency);
        return currencyReceiverService.getCurrency(base);
    }

}
