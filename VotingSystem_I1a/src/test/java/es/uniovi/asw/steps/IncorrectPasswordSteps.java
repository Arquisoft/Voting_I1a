package test.java.es.uniovi.asw.steps;

import main.java.es.uniovi.asw.Application;
import main.java.es.uniovi.asw.access.LogInEV;
import main.java.es.uniovi.asw.dbUpdate.Database;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class IncorrectPasswordSteps {
  
		@Autowired
		protected WebApplicationContext context;

		protected MockMvc mvc;
		protected MvcResult result;
  
		@Value("${local.server.port}")
		protected int port;

		Exception exception;
	
	  @Given("^the nif suppose it exists$")
	  public void the_nif_suppose_it_exists() throws Throwable {
		  	org.junit.Assert.assertNotNull(Database.findVoter("71900605A"));
	  }
	  

	  @When("^the voter introduces a wrong password$")
	  public void the_voter_introduces_a_wrong_password() throws Throwable {
		  try{
			  new LogInEV().logIn("7190605A", "wrong");
		  }catch(InvalidParameterException e){
			  exception = e;
		  }
	  }
	  

	  @Then("^the system shows an error message$")
	  public void the_system_shows_an_error_message() throws Throwable {

		  	org.junit.Assert.assertTrue(exception.getMessage().contains("The password is not correct."));
	  }  
}