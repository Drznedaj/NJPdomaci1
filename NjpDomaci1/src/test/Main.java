package test;

import java.util.ArrayList;

import api.DAO;
import api.Generator;
import entities.Prodavnica;
import entities.Proizvod;
import entities.Tip;

public class Main {

	public static void main(String[] args) {
		Generator.getInstance().generateObjects();
        DAO.getInstance().updateOne(DAO.getInstance().getProdavnice().get(0),"prodavnica_ime","sadjedruga");
        Proizvod p = DAO.getInstance().getProizvodi().get(1);
        Prodavnica prod = DAO.getInstance().getProdavnice().get(1);
        Tip t = DAO.getInstance().getTipovi().get(2);
        String[] k1 = {"proizvod_naziv"};
        String[] k2 = {"tip_naziv","tip_id"};
        DAO.getInstance().join(p.getClass(),t.getClass(),k1,k2);
        String[] proizvod_kolone = {"prodavnica_ime","prodavnica_adresa"};
        String[] vals = {"?","?"};
        DAO.getInstance().deleteAND(prod.getClass(), proizvod_kolone, vals);
        DAO.getInstance().select(prod.getClass(), proizvod_kolone);
        DAO.getInstance().selectAll(prod.getClass());
		//ORM.getInstance().getTableColumn((new Proizvod()).getClass(),"naziv");
//		DAO.getInstance().insert(ORM.getInstance(),p.getClass());
//        System.out.println(DAO.getInstance().getTableName(p.getClass()));
//        System.out.println(DAO.getInstance().getTableColumns(p.getClass()));
		
//        System.out.println(orm.getSuperClassColumns(p.getClass().getSuperclass()));
	}

}
