package com.example.CryptoWallet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.CryptoWallet.model.Crypto;
import com.example.CryptoWallet.model.CryptoRepository;
import com.example.CryptoWallet.model.Wallet;

@Controller
public class CryptoController {
	
	@Autowired
	private CryptoRepository repository;
	
	// Showing all transactions
	@GetMapping(value = {"/transactions"})
	public String cryptoPort(Model model) {
		model.addAttribute("cryptos", repository.findAll());
		return "transactions";
	}
	
	// Adding transactions
	@GetMapping("/add")
	public String addCrypto(Model model) {
		model.addAttribute("crypto", new Crypto());
		return "add";
	}
	
	// Save new transaction
	@PostMapping("/add")
	public String save(Crypto crypto) {
		repository.save(crypto);
		return "redirect:transactions";
	}
	
	// Delete transactional record
	@GetMapping("/delete/{id}")
	public String deleteCrypto(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../transactions";
	}
	
	// Edit transaction
	@GetMapping("/edit/{id}")
	public String editCrypto(@PathVariable("id") Long id, Model model) {
		model.addAttribute("crypto", repository.findById(id));
		return "edit";
	}
	
	// Showing wallet 
	@GetMapping("/wallet")
	public String cryptoWallet(Model model) {
		model.addAttribute("wallets",repository.findWallet());
		return "wallet";
	}
	
	// REST for wallet
	@GetMapping("/walletrest")
	public @ResponseBody List<Wallet> walletREST() {
		return (List<Wallet>) repository.findWallet();
	}
	
	// REST for transactions
	@GetMapping("/transactionrest")
	public @ResponseBody List<Crypto> transactionREST() {
		return (List<Crypto>) repository.findAll();
	}
	
    @GetMapping("/login")
    public String welcomePage() {
        return "welcome";
    }
    
    
}
