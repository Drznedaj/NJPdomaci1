package entities;

import annotations.Column;
import annotations.Table;
import annotations.Type;
import annotations.enumerators.FieldType;
import api.GetTableParameters;
import jdk.jfr.ContentType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

@Table(name="prodavnice")
public class Prodavnica extends BasicEntity {
	
	@Column(name= "prodavnica_ime")
	@Type(name = FieldType.VARCHAR)
	private String ime;
	
	@Column(name= "prodavnica_adresa")
    @Type(name = FieldType.VARCHAR)
	private String adresa;

	private ArrayList<Proizvod> proizvodi;

	@Column(name = "prodavnica_brojProdavaca")
    @Type(name = FieldType.INT)
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
