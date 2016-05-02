package es.uniovi.asw.dbUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.es.uniovi.asw.dbUpdate.verifiers.VoteVerifier;
import main.java.es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Vote;
import main.java.es.uniovi.asw.model.Voter;

public class Database {
	
	public Vote insertVote(Vote vote) throws SQLException, InvalidParameterException {
		
		//DriverManager = "org.hsqldb.jdbcDriver";
		
		String url = "jdbc:hsqldb:file:src/main/resources/database/db";
		String username = "SA";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		String query = "INSERT INTO votes (option) VALUES(?)";

		VoteVerifier.check(vote);
		
		try {
			conn = DriverManager.getConnection(url,username, password);
			
			stat = conn.prepareStatement(query);
		
			stat.setString(1, vote.getOptionS());
			stat.executeUpdate();
			return vote;
			
		}catch (SQLException e){
			System.err.print("error connecting \n");
			e.printStackTrace();
		}
		
		return vote;
	}
	
	public Voter findVoter(String nif) throws SQLException{
		
		Voter voter = null;
		
		//DriverManager = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:file:src/main/resources/database/db";
		String username = "SA";
		String password = "";
				
		Connection conn = null;
		PreparedStatement stat = null;
				
		String query = "SELECT nif, name, email, password, hasVoted, "
				+ "isEVoter FROM voters  WHERE v.nif =?";

		try {
			conn = DriverManager.getConnection(url,username, password);
					
			stat = conn.prepareStatement(query);
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				voter = new Voter(rs.getString(1), rs.getString(2), rs.getString(3), 
								rs.getString(4), rs.getBoolean(5), rs.getBoolean(6));
			}	
		}catch (SQLException e){
			System.err.print("error connecting \n");
			e.printStackTrace();
		}
				
		return voter;
	}
	
	public Voter updateHasVoted(Voter voter) throws SQLException, InvalidParameterException {
		
		//DriverManager = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:file:src/main/resources/database/db";
		String username = "SA";
		String password = "";
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		String query = "UPDATE voters SET hasVoted=? WHERE nif=?)";
		
		VoterVerifier.check(voter);

		try {
			conn = DriverManager.getConnection(url,username, password);
			
			stat = conn.prepareStatement(query);
		
			stat.setBoolean(1, voter.isHasVoted());
			stat.setString(2, voter.getNif());
			stat.executeUpdate();
			return voter;
			
		}catch (SQLException e){
			System.err.print("error connecting \n");
			e.printStackTrace();
		}
		
		return voter;
	}
	
	public Voter addNewEVoter(Voter voter) throws SQLException, InvalidParameterException{
		
		//DriverManager = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:file:src/main/resources/database/db";
		String username = "SA";
		String password = "";
				
		Connection conn = null;
		PreparedStatement stat = null;
				
		String query = "UPDATE voters SET isEvoter = ? WHERE nif =?";
				
		VoterVerifier.check(voter);

		try {
			conn = DriverManager.getConnection(url,username, password);
					
			stat = conn.prepareStatement(query);
				
			stat.setBoolean(1, voter.isEVoter());
			stat.setString(2, voter.getNif());
			stat.executeUpdate();
			return voter;
					
		}catch (SQLException e){
			System.err.print("error connecting \n");
			e.printStackTrace();
		}
				
		return voter;	
	}
}
