package entities;

import annotations.Column;
import annotations.Table;
import api.GetTableParameters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

@Table(name="prodavnice")
public class Prodavnica extends BasicEntity implements GetTableParameters {
	
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


	@Override
	public String getTableName(Class<?> klasa) {
		Annotation[] anotacije = klasa.getAnnotations();
		String tableName = "";
		for (Annotation anotacija : anotacije) {
			if (anotacija instanceof Table){
				tableName = ((Table)anotacija).name();
				break;
			}
		}
		return tableName;
	}

	@Override
	public ArrayList<String> getTableColumns(Class<?> klasa) {
		ArrayList<String> columns = new ArrayList<>();

		for(Field field : klasa.getDeclaredFields()) {
			for(Annotation a : field.getAnnotations()) {
				if(a instanceof Column) {
					columns.add(((Column) a).name());
				}

			}
		}

		return columns;
	}
}
