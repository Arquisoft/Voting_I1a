package test.java.es.uniovi.asw.access;

import java.sql.SQLException;

import junit.framework.TestCase;
import main.java.es.uniovi.asw.access.RegisterEV;
import main.java.es.uniovi.asw.exceptions.ExceptionMessages;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Voter;

public class RegisterEVTest extends TestCase {
		
		//not e-voters
		private static Voter voter1 = new Voter("XXXX", "name1", "email1", "pass1", false, false);
		private static Voter voter2 = new Voter("YYYY", "name2", "email2", "pass2", false, false);
		
		//e-voter
		private static Voter voter3 = new Voter("ZZZZ", "name3", "email3", "pass3", false, true);
		private static Voter voter4 = new Voter("QQQQ", "name4", "email4", "pass4", false, true);

		public static void insertVoters() throws InvalidParameterException{
			DatabaseToTest.insertVoter(voter1);
			DatabaseToTest.insertVoter(voter2);
			DatabaseToTest.insertVoter(voter3);
			DatabaseToTest.insertVoter(voter4);
		}
		
		public void testCorrectRegister() throws InvalidParameterException, SQLException {
			Voter test;
			
			assertFalse(voter1.isEVoter());
			test = new RegisterEV().makeEVoter(voter1.getNif());
			assertEquals(voter1, test);
			assertTrue(test.isEVoter());
			
			assertFalse(voter2.isEVoter());
			test = new RegisterEV().makeEVoter(voter2.getNif());
			assertEquals(voter2, test);
			assertTrue(test.isEVoter());
		}
		
		public void testAlreadyEvoter() throws InvalidParameterException, SQLException{
			
			Exception message = null;
			
			try{
				new RegisterEV().makeEVoter(voter3.getNif());
			} catch (InvalidParameterException e){
				message = e;
			}
			
			assertEquals(ExceptionMessages.ALREADY_EVOTER, message);
			
			
			try{
				new RegisterEV().makeEVoter(voter4.getNif());
			} catch (InvalidParameterException e){
				message = e;
			}
			
			assertEquals(ExceptionMessages.ALREADY_EVOTER, message);
		}

}
