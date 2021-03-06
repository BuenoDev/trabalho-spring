package br.gov.rj.faetec.estoque.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.rj.faetec.estoque.model.Cliente;

@Controller
public class ClienteControler {
	@RequestMapping("/cliente/novo")
	public String novo(Cliente cliente) {
		return "cliente/CadastroCliente";
	}
	
	@RequestMapping(value = "/cliente/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		return "redirect:/cliente/novo";
		// Salvar no banco de dados...
		/*
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		System.out.println(">>> sku: " + produto.getSku());
		return "redirect:/produtos/novo";
		*/
	}
	
}
