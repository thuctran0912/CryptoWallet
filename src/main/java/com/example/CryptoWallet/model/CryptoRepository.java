package com.example.CryptoWallet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long>{

	// Query to find the quantity and average of each crypto owned
	@Query(value = "SELECT new com.example.CryptoWallet.model.Wallet(c.name, c.code, SUM(c.quantity), SUM(c.quantity*c.boughtPrice)/sum(c.quantity)) FROM Crypto as c GROUP BY c.code")
	List<Wallet> findWallet();
	
	List<Crypto> findByName(String name);
}
