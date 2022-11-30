package com.example.CryptoWallet;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.CryptoWallet.model.Crypto;
import com.example.CryptoWallet.model.CryptoRepository;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CryptoRepositoryTest {
	
	@Autowired
	private CryptoRepository repository;
	
	
	@Test
	public void findByNameShouldReturnCode() {
		List<Crypto> transactions = repository.findByName("Bitcoin");
		
		assertThat(transactions.get(0).getCode()).isEqualTo("BTC");
		
	}
	
	@Test
	public void addCrypto() {
		Crypto crypto = new Crypto("NEAR", "NEAR", "30-11-2022", 1.5, 1000);
		repository.save(crypto);
		assertThat(crypto.getId()).isNotNull();
	}
	


}
