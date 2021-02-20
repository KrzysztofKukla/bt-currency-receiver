package pl.kukla.krzys.bluetrade.btcurrencyreceiver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Krzysztof Kukla
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyReceiverException extends RuntimeException {
    public CurrencyReceiverException(String message) {
        super(message);
    }

    public CurrencyReceiverException(String message, Throwable cause) {
        super(message, cause);
    }

}
