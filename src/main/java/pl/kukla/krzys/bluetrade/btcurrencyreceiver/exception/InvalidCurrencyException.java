package pl.kukla.krzys.bluetrade.btcurrencyreceiver.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Krzysztof Kukla
 */
@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String message) {
        super(message);
    }

    public InvalidCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

}
