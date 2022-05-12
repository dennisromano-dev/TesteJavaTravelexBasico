package br.com.confidencecambio.javabasico.model;

import java.util.Objects;

public class IndiceMassaCorporal {

	private Double massaCorporal;

	private String pesoIdeal;

	private String status;

	public Double getMassaCorporal() {
		return massaCorporal;
	}

	public void setMassaCorporal(Double massaCorporal) {
		this.massaCorporal = massaCorporal;
	}

	public String getPesoIdeal() {
		return pesoIdeal;
	}

	public void setPesoIdeal(String pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(massaCorporal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndiceMassaCorporal other = (IndiceMassaCorporal) obj;
		return Objects.equals(massaCorporal, other.massaCorporal);
	}

}
