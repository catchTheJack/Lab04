package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public ArrayList<Studente> getElencoStudenti(){
		
		final String sql = "SELECT * FROM studente";
		
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");
				int matricola = rs.getInt("matricola");
				
				System.out.println(nome+" "+cognome+" "+matricola+" "+cds);
				
				Studente nuovo = new Studente(matricola, cognome, nome, cds);
				studenti.add(nuovo);
			}
			
			return studenti;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("Erore Db");
		}	
		
	}
	
	public ArrayList<Studente> getElencoIscritti(String nomeInsegnamento){
		
		final String sql = "SELECT * FROM studente WHERE matricola IN "
				+ "(SELECT matricola FROM iscrizione WHERE codins IN "
				+ "(SELECT codins FROM corso WHERE nome = ?))";
		
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,nomeInsegnamento);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");
				int matricola = rs.getInt("matricola");
				
				System.out.println(nome+" "+cognome+" "+matricola+" "+cds);
				
				Studente nuovo = new Studente(matricola, cognome, nome, cds);
				studenti.add(nuovo);
			}
			
			return studenti;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("Erore Db");
		}	
		
	}
	
	public ArrayList<Corso> getElencoCorsi(String matricola){
		final String sql = "SELECT * FROM corso WHERE codins IN "
				+ "(SELECT codins FROM iscrizione WHERE matricola =?)";
		
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String codins =rs.getString("codins");
				int crediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int pd = rs.getInt("pd");
				
				System.out.println(codins+" "+crediti+" "+nome+" "+pd);
				
				Corso nuovo = new Corso(codins, crediti, nome,pd);
				corsi.add(nuovo);
			}
			
			return corsi;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("Erore Db");
		}
	}	
		
		public void iscrivi(int matricola,String nomeCorso){
			final String sql = "INSERT INTO iscrizione (matricola, codins)\n" + 
					"VALUES (?, (SELECT codins \n" + 
					"				FROM corso\n" + 
					"				WHERE nome = ?))\n";
			
			
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1,matricola);
				st.setString(2,nomeCorso);
				ResultSet rs = st.executeQuery();
				System.out.println(" "+rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new RuntimeException("Erore Db");
			}	
	}
	
}
