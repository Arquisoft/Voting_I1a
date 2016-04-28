/*package test.java.es.uniovi.asw.steps;

import main.java.es.uniovi.asw.Application;
import main.java.es.uniovi.asw.access.LogInEV;
import main.java.es.uniovi.asw.access.VoteAction;
import main.java.es.uniovi.asw.dbUpdate.Database;
import main.java.es.uniovi.asw.model.Option;
import main.java.es.uniovi.asw.model.Vote;
import main.java.es.uniovi.asw.model.Voter;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class OnlyOneVoteSteps {
  
		@Autowired
		protected WebApplicationContext context;

		protected MockMvc mvc;
		protected MvcResult result;
  
		@Value("${local.server.port}")
		protected int port;

		Object checker;
	
	  @Given("^the user is logged in and checked if he has voted$")
	  public void the_user_is_logged_in_and_checked_if_has_voted() throws Throwable {
		 
		  org.junit.Assert.assertNotNull(Database.findVoter("71900605A"));
		  org.junit.Assert.assertFalse(Database.findVoter("71900605A").isHasVoted());
		  checker = new LogInEV().logIn("71900605A", "777sss");
	  }

	  @When("^the user votes$")
	  public void the_user_votes() throws Throwable {
	      new VoteAction().vote(new Vote(Option.whiteVote), (Voter) checker);
	  }

	  @Then("^the voter is marked as already voted$")
	  public void the_voter_is_marked_as_already_voted() throws Throwable {
	      org.junit.Assert.assertTrue(Database.findVoter("71900605A").isHasVoted());
	  }
}*/
