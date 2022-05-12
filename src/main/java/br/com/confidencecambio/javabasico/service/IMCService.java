package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.confidencecambio.javabasico.constants.Constants;
import br.com.confidencecambio.javabasico.model.IndiceMassaCorporal;
import br.com.confidencecambio.javabasico.util.Util;

@Service
public class IMCService {

	public IndiceMassaCorporal calcularIMC(String sPeso, String sAltura) {

		Assert.hasText(sPeso, Constants.Mensagem.PESO_NAO_INFORMADO);

		Assert.hasText(sAltura, Constants.Mensagem.ALTURA_NAO_INFORMADO);

		if (!Util.isNumeric(sAltura)) {
			throw new NumberFormatException(Constants.Mensagem.ALTURA_INVALIDA);
		}

		if (!Util.isNumeric(sPeso)) {
			throw new NumberFormatException(Constants.Mensagem.PESO_INVALIDO);
		}

		Double peso = Double.valueOf(sPeso.replace(",", "."));

		Double altura = Double.valueOf(sAltura.replace(",", "."));

		return calculo(peso, altura);
	}

	private IndiceMassaCorporal calculo(double peso, double altura) {

		double imc = peso / (altura * altura);

		double idealMin = Constants.PesoNormal.MINIMO * (altura * altura);

		double idealMax = Constants.PesoNormal.MAXIMO * (altura * altura);

		IndiceMassaCorporal massa = new IndiceMassaCorporal();

		massa.setMassaCorporal(Util.limitarDouble(imc, 2));

		massa.setPesoIdeal(String.format("O seu peso ideal é entre %.2f kg e %.2f kg", idealMin, idealMax));

		if (Constants.Magreza.MINIMO > imc) {
			massa.setStatus(Constants.Mensagem.MAGREZA);
		} else if (Constants.PesoNormal.MAXIMO > imc && Constants.PesoNormal.MINIMO < imc) {
			massa.setStatus(Constants.Mensagem.PESO_IDEAL);
		} else if (Constants.Sobrepeso.MAXIMO > imc && Constants.Sobrepeso.MINIMO < imc) {
			massa.setStatus(Constants.Mensagem.SOBREPESO);
		} else if (Constants.Obesidade.MINIMO < imc) {
			massa.setStatus(Constants.Mensagem.OBESIDADE);
		}

		return massa;
	}
}
