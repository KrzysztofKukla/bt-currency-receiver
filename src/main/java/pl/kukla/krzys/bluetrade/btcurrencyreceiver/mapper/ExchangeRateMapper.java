package pl.kukla.krzys.bluetrade.btcurrencyreceiver.mapper;

import org.springframework.stereotype.Component;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.model.ExchangeRate;
import pl.kukla.krzys.bluetrade.btcurrencyreceiver.model.Rate;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyDto;
import pl.kukla.krzys.bluetrade.btmodel.CurrencyEnum;
import pl.kukla.krzys.bluetrade.btmodel.RateDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
@Component
public class ExchangeRateMapper {
    public CurrencyDto mapExchangeRateToCurrencyDto(ExchangeRate exchangeRate) {
        Set<RateDto> rateSet = convertRates(exchangeRate);
        return CurrencyDto.builder()
            .base(CurrencyEnum.valueOf(exchangeRate.getBase()))
            .localDateTime(LocalDateTime.now())
            .rates(rateSet)
            .build();
    }

    private Set<RateDto> convertRates(ExchangeRate exchangeRate) {
        Set<RateDto> rateSet = new HashSet();
        exchangeRate.getRates()
            .forEach((key, value)->{
                RateDto rateDto = RateDto.builder()
                    .rate(CurrencyEnum.valueOf(key))
                    .value(value)
                    .build();
                rateSet.add(rateDto);
            });
        return rateSet;
    }

}


//    fun mapToCurrencyDto(exchangeRate:ExchangeRate): CurrencyDto {
//    val convertRates = convertRates(exchangeRate)
//    return CurrencyDto.builder()
//    .base(CurrencyEnum.valueOf(exchangeRate.base))
//    .localDate(LocalDate.now())
//    .rates(convertRates)
//    .build()
//    }
//
//private fun convertRates(exchangeRate: ExchangeRate,): Set<RateDto> {
//    val rateSet: MutableSet<RateDto> = HashSet()
//    exchangeRate.rates.forEach { (key: String, value: BigDecimal) ->
//    val rateDto = RateDto.builder()
//    .rate(CurrencyEnum.valueOf(key))
//    .value(value)
//    .build()
//    rateSet.add(rateDto)
//    }
//    return rateSet
//    }
