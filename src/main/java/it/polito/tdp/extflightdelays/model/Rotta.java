package it.polito.tdp.extflightdelays.model;

import java.util.Objects;

public class Rotta {
	private Airport origine;
	private Airport destinazione;
	private Integer n;
	
	public Rotta(Airport origine, Airport destinazione, Integer n) {
		super();
		this.origine = origine;
		this.destinazione = destinazione;
		this.n = n;
	}

	public Airport getOrigine() {
		return origine;
	}

	public void setOrigine(Airport origine) {
		this.origine = origine;
	}

	public Airport getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(Airport destinazione) {
		this.destinazione = destinazione;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "Rotta [origine=" + origine + ", destinazione=" + destinazione + ", n=" + n + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destinazione, n, origine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rotta other = (Rotta) obj;
		return Objects.equals(destinazione, other.destinazione) && Objects.equals(n, other.n)
				&& Objects.equals(origine, other.origine);
	}
	
	
}
