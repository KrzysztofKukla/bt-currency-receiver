package pl.kukla.krzys.bluetrade.btcurrencyreceiver.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.exception.InvalidCurrencyException;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.mapper.ExchangeRateMapper;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.model.ExchangeRate;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateConverterImpl implements ExchangeRateConverter {
    private final ObjectMapper objectMapper;
    private final ExchangeRateMapper exchangeRateMapper;

    @Override
    public CurrencyDto convertToCurrencyDto(String currencyJson) {
        log.debug("Converting exchangeRate to Currency");
        ExchangeRate exchangeRate = readExchangeRateFromJson(currencyJson);
        return exchangeRateMapper.mapExchangeRateToCurrencyDto(exchangeRate);

    }

//    val objectMapper: ObjectMapper,
//    val exchangeRateMapper: ExchangeRateMapper
//    ) {
//
//        fun convertToCurrencyDto(message: String): CurrencyDto {
//            val exchangeRateFromJson: ExchangeRate = readExchangeRateFromJson(message)
//            return exchangeRateMapper.mapToCurrencyDto(exchangeRateFromJson)
//        }
//
//        private fun readExchangeRateFromJson(message: String):ExchangeRate {
//            return try {
//                objectMapper.readValue(message, ExchangeRate::class.java)
//            } catch (e: Exception) {
//                throw InvalidCurrencyException(e.localizedMessage, e)
//            }
//        }

    private ExchangeRate readExchangeRateFromJson(String currencyJson) {
        try {
            return objectMapper.readValue(currencyJson, ExchangeRate.class);
        } catch (JsonProcessingException e) {
            throw new InvalidCurrencyException("Cannot read currencyJson", e);
        }

    }

}
