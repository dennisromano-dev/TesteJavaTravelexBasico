package br.com.confidencecambio.javabasico.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.model.IndiceMassaCorporal;
import br.com.confidencecambio.javabasico.service.IMCService;

@RestController
@RequestMapping("/peso")
public class IMCController {

	@Autowired
	private IMCService service;

	@RequestMapping(value = "/imc", method = RequestMethod.GET)
	public ResponseEntity<IndiceMassaCorporal> imc(@RequestParam(value = "peso", required = false) String peso,
			@RequestParam(value = "altura", required = false) String altura) {
		return ResponseEntity.ok(service.calcularIMC(peso, altura));
	}

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "index";
	}
}
