package it.polito.tdp.lab04.DAO;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		
		StudenteDAO sdao = new StudenteDAO();
		System.out.println("\n");
		System.out.println("prova metedo elencoStudenti sdao");
		sdao.getElencoStudenti();
		System.out.println("\n");
		System.out.println("prova metedo elencoCorsi di sdao");
		sdao.getElencoCorsi("146101");
		System.out.println("\n");
		System.out.println("\n");
		sdao.iscrivi(146101, "Diritto commerciale");

	}

}
