package br.com.confidencecambio.javabasico.model.common;

import org.springframework.util.Assert;

public class NomeBase {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Assert.notNull(nome, "O nome não pode estar Nulo!");
		Assert.hasText(nome, "O nome não pode estar Vazio!");
		
		if (nome.endsWith(" ")) {
			throw new IllegalArgumentException("O nome não pode terminar com espaço");
		}
		if (nome.startsWith(" ")) {
			throw new IllegalArgumentException("O nome não pode iniciar com espaço");
		}
		
		nome = nome.trim().replaceAll(" +", " ");
		
		this.nome = nome;
	}

	public String getPrimeiroNome() {
		return nome.split(" ")[0];
	}

	public String getUltimoNome() {
		return nome.replace(getPrimeiroNome() , "").trim();
	}

	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}

	public String getNomeAbreviado() {
		var nomeDoMeio = nome.split(" ")[1];
		var abreviado = nomeDoMeio.substring(0,1);
		return nome.replace(nomeDoMeio, abreviado.toUpperCase() + ".");
	}

}
