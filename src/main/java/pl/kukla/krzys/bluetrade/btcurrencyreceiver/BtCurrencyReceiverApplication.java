package pl.kukla.krzys.bluetrade.btcurrencyreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BtCurrencyReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtCurrencyReceiverApplication.class, args);
	}

}
