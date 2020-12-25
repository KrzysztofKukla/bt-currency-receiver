package pl.kukla.krzys.bluetrade.btcurrencyreceiver.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyEnum;

/**
 * @author Krzysztof Kukla
 */
class ExchangeRateMapperTest {

    @Test
    void enumValueOfTest() throws Exception {
        CurrencyEnum usd = CurrencyEnum.valueOf("USD");
        Assertions.assertEquals(CurrencyEnum.USD, usd);

    }

}