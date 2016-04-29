package test.java.es.uniovi.asw.access;

import java.sql.SQLException;

import junit.framework.TestCase;
import main.java.es.uniovi.asw.access.LogInEV;
import main.java.es.uniovi.asw.exceptions.ExceptionMessages;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Voter;


public class LoginEVTest extends TestCase{
	
	//registered e-voters who have not voted yet
	private static Voter voter1 = new Voter("XXXX", "name1", "email1", "pass1", false, true);
	private static Voter voter2 = new Voter("YYYY", "name2", "email2", "pass2", false, true);
	
	//not e-voter
	private static Voter voter3 = new Voter("ZZZZ", "name3", "email3", "pass3", false, false);
	
	public static void insertVoters() throws InvalidParameterException{
		DatabaseToTest.insertVoter(voter1);
		DatabaseToTest.insertVoter(voter2);
		DatabaseToTest.insertVoter(voter3);
	}
	
	public void testLogIn() throws SQLException, InvalidParameterException{
		Voter test;
		
		assertTrue(voter1.isEVoter());
		test = new LogInEV().logIn(voter1.getNif(), voter1.getPassword());
		assertEquals(voter1, test);
		
		assertTrue(voter2.isEVoter());
		test = new LogInEV().logIn(voter2.getNif(), voter2.getPassword());
		assertEquals(voter2, test);
	}
	
	public void testPassword() throws SQLException{
		
		Exception message = null;

		assertTrue(voter2.isEVoter());
		try{
			new LogInEV().logIn(voter2.getNif(), voter1.getPassword());
		}catch(InvalidParameterException e){
			message = e;
		}
		
		assertEquals(ExceptionMessages.WRONG_PASSWORD, message);
		
		assertTrue(voter1.isEVoter());
		try{
			new LogInEV().logIn(voter1.getNif(), voter2.getPassword());
		}catch(InvalidParameterException e){
			message = e;
		}
		
		assertEquals(ExceptionMessages.WRONG_PASSWORD, message);	
	}

	public void testNotEV() throws SQLException{
		
		Exception message = null;
		assertFalse(voter3.isEVoter());
		
		try{
			new LogInEV().logIn(voter3.getNif(), voter3.getPassword());
		} catch (InvalidParameterException e){
			message = e;
		}
	
		assertEquals(ExceptionMessages.NOT_EVOTER, message);
	}
}