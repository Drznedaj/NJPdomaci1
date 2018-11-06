package entities;

import annotations.Column;
import annotations.Tabela;
import annotations.Table;
import annotations.Type;
import annotations.enumerators.FieldType;

@Table(name="prodavnice")
@Tabela
public class Prodavnica extends BasicEntity {
	
	@Column(name= "prodavnica_ime")
	@Type(name = FieldType.VARCHAR, length="32")
	private String ime;
	
	@Column(name= "prodavnica_adresa")
    @Type(name = FieldType.VARCHAR, length="32")
	private String adresa;


	@Column(name = "prodavnica_brojProdavaca")
    @Type(name = FieldType.INT,length="6")
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
