package test.java.es.uniovi.asw.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Voter;

public class DatabaseToTest {
	
	public static void insertVoter(Voter voter) throws InvalidParameterException{
		//DriverManager = "org.hsqldb.jdbcDriver";
		
		String url = "jdbc:hsqldb:file:src/test/resources/database/db";
		String username = "SA";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		String query = "INSERT INTO voters (nif, name, email, "
				+ "password, hasVoted, isEVoter) VALUES (?, ?, ?, ?, ?, ?)";

		VoterVerifier.check(voter);
		
		try {
			conn = DriverManager.getConnection(url,username, password);
			
			stat = conn.prepareStatement(query);
			stat.setString(1, voter.getNif());
			stat.setString(2, voter.getName());
			stat.setString(3, voter.getEmail());
			stat.setString(4, voter.getPassword());
			stat.setBoolean(5, voter.isHasVoted());
			stat.setBoolean(6, voter.isEVoter());
			stat.executeUpdate();
			
		}catch (SQLException e){
			System.err.print("error connecting \n");
			e.printStackTrace();
		}
	}
}
