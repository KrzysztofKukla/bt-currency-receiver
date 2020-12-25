package pl.kukla.krzys.bluetrade.btcurrencyreceiver.externalapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.gateway.ExternalApiServiceFeignClient;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ExternalCurrencyApiImpl implements ExternalCurrencyApi {
    private final ExternalApiServiceFeignClient externalApiServiceFeignClient;

    @Override
    public String getCurrency(String base) {
        return externalApiServiceFeignClient.getCurrency(base);
    }

}
