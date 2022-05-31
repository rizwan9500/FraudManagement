package com.mvc.fraudmanagement.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.fraudmanagement.entities.Card;
import com.mvc.fraudmanagement.entities.User;
import com.mvc.fraudmanagement.repos.CardRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
@SessionAttributes("card")
public class CardController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@RequestMapping(value="/card-fraud", method = RequestMethod.GET)
	public String showCard() {
		return "fraud-pages/card-fraud";
	}
	
	@RequestMapping(value="/card-registration", method = RequestMethod.GET)
	public String showCardRegistration(ModelMap model) {
		model.addAttribute("card",new Card());
		return "registration-forms/card-registration";
	}
	
	@RequestMapping(value="/card-registration", method = RequestMethod.POST)
	public String saveCardRegistration(ModelMap model,@Valid Card card,BindingResult result) {
		
		
		if (result.hasErrors()) {
			return "registration-forms/card-registration";
		}
		
		cardRepository.save(card);
		
		return "redirect:/card-fraud";
	}
	
	
}
