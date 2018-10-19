package test;

import entities.Proizvod;

public class Main {

	public static void main(String[] args) {
		Proizvod p = new Proizvod();

        System.out.println(p.getTableName(p.getClass()));
        System.out.println(p.getTableColumns(p.getClass()));
	}

}
