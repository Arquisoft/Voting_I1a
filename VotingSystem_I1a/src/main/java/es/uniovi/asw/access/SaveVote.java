package es.uniovi.asw.access;

import java.sql.SQLException;

import main.java.es.uniovi.asw.dbUpdate.Database;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Option;
import main.java.es.uniovi.asw.model.Vote;

/**
 * Class that stores the votes
 * 
 */
public class SaveVote {

	public void saveVote(Option option) throws SQLException, InvalidParameterException{
		
		Database database = new Database();
		
		Vote vote = new Vote(option);
		
		database.insertVote(vote);	
	}
	
}
