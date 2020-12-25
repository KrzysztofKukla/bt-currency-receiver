package pl.kukla.krzys.bluetrade.btcurrencyreceiver.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.service.CurrencyReceiverService;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

import static pl.kukla.krzys.bluetrade.btcurrencyreceiver.web.CurrencyReceiverController.API_V1_BT_CURRENCY_RECEIVER;

/**
 * @author Krzysztof Kukla
 */

@RestController
@RequestMapping(API_V1_BT_CURRENCY_RECEIVER)
@Slf4j
@RequiredArgsConstructor
public class CurrencyReceiverController {
    static final String API_V1_BT_CURRENCY_RECEIVER = "/api/v1/bt-currency-receiver";

    private final CurrencyReceiverService currencyReceiverService;

//    @GetMapping
//    public CurrencyDto getCurrency() {
//        return currencyLatestService.getCurrency();
//    }

    @GetMapping("/latest")
    public CurrencyDto getCurrency(@RequestParam(value = "base", required = false) String base) {
        return currencyReceiverService.getCurrency(base);
    }

}
