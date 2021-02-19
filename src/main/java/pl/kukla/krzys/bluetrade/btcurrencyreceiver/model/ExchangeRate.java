package pl.kukla.krzys.bluetrade.btcurrencyreceiver.model;

import lombok.Data;
import lombok.val;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Krzysztof Kukla
 */
@Data
public class ExchangeRate {
    private Map<String,BigDecimal> rates= new HashMap();
    private String base;
    private String date;
}
