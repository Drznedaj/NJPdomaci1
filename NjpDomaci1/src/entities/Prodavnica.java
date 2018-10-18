package entities;

import annotations.Column;
import annotations.Table;

@Table(name="prodavnice")
public class Prodavnica extends BasicEntity {
	
	@Column(name= "prodavnica_ime")
	private String ime;
	
	@Column(name= "prodavnica_adresa")
	private String adresa;
	
	private String brojProdavaca;
	
	public Prodavnica() {
		super();
	}
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojProdavaca() {
		return brojProdavaca;
	}

	public void setBrojProdavaca(String brojProdavaca) {
		this.brojProdavaca = brojProdavaca;
	}
	
	
}
