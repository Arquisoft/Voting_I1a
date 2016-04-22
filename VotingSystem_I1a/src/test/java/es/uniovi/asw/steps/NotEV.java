package test.java.es.uniovi.asw.steps;

import main.java.es.uniovi.asw.Application;
import main.java.es.uniovi.asw.access.LogInEV;
import main.java.es.uniovi.asw.access.VoteAction;
import main.java.es.uniovi.asw.dbUpdate.Database;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class NotEV {
  
		@Autowired
		protected WebApplicationContext context;

		protected MockMvc mvc;
		protected MvcResult result;
  
		@Value("${local.server.port}")
		protected int port;

		Exception exception;
	
	  @Given("^the voter is not EVoter$")
	  public void the_voter_is_not_evoter() throws Throwable {
	      
		  org.junit.Assert.assertNotNull(Database.findVoter("71900605A"));
		  org.junit.Assert.assertFalse(Database.findVoter("71900605A").isEVoter());
	  }
	  

	  @When("^the voter tries to access the system$")
	  public void the_voter_tries_to_access_the_system() throws Throwable {
		  try{
			  new LogInEV().logIn("7190605A", "777sss");
		  }catch(InvalidParameterException e){
			  exception = e;
		  }
	  }
	  

	  @Then("^the system shows an error message$")
	  public void the_system_shows_an_error_message() throws Throwable {

		  org.junit.Assert.assertNotNull(Database.findVoter("71900605A"));
		  org.junit.Assert.assertTrue(exception.getMessage().contains("You are not an e-voter."));
	  }
	  
}
