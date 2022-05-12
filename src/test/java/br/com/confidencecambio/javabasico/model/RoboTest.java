package br.com.confidencecambio.javabasico.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoboTest {

	Logger logger = LoggerFactory.getLogger(RoboTest.class);

	@Test
	public void nomePreenchidoCoretamente() {
		var robo = new Robo();
		robo.setNome("Dennis Romano");
		logger.info("######################################");
		logger.info("#############Robo##################");
		logger.info("######################################");
		logger.info("Nome: " + robo.getNome());
		logger.info("Nome Maiusculo: " + robo.getNomeMaiusculo());
		logger.info("Primeiro Nome: " + robo.getPrimeiroNome());
		logger.info("Ultimo Nome: " + robo.getUltimoNome());
		logger.info("Nome Abreviado: " + robo.getNomeAbreviado());

		assertEquals(robo.getNome(), "Dennis Romano");
		assertEquals(robo.getNomeMaiusculo(), "DENNIS ROMANO");
		assertEquals(robo.getPrimeiroNome(), "Dennis");
		assertEquals(robo.getUltimoNome(), "Romano");
		assertEquals(robo.getNomeAbreviado(), "Dennis R.");
	}

	@Test
	public void nomeComEspacoNoFim() {
		var robo = new Robo();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			robo.setNome("Dennis Romano ");
		});
	}

	@Test
	public void nomeComEspacoNoInicio() {
		var robo = new Robo();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			robo.setNome(" Dennis Romano");
		});
	}

	@Test
	public void nomeComNomeNulo() {
		var robo = new Robo();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			robo.setNome(null);
		});
	}

	@Test
	public void nomeComNomeVazio() {
		var robo = new Robo();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			robo.setNome("");
		});
	}
}