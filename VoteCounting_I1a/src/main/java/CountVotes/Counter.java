package countvotes;

import java.util.List;
import java.util.ArrayList;


import dao.*;

public class Counter {
	
	private List<String> PPList; // Political Party list
	private List<Integer> countList; // Sum of votes


  public void main()
  {
    count();

  }

  
  public void count()
  {
	  // Pretty much uses readVotes and updateResults.
    readVotes();
    //System.out.println("Counting succesfull.");
      //System.out.println("Please load in next database then press a key to continue");
      //System.in.read();
    updateResults();
    //System.out.println("Succesfully added Votes.");
  }

  public void readVotes()
  {
	  // Goes to Database_Votes and reads the data inside 
	  // Lists all political parties and then performs a preparedStatement in order to 
	  // 	extract and store the sum of all the results for the specific political party
	  //	SQL stuff done in DBVotesDAO
      DBVotesDAO dao = new JDBCDatabaseVotes();

      PPList = dao.getParties();
      countList = new ArrayList<Integer>();

      for(int i = 0; i < PPList.size(); i++)
      {
        countList.add(dao.countTotal(PPList.get(i)));
      }

  }
  
  public void updateResults()
  {
	  // Updates or inserts in the Database_Results the sum of the votes found.
	  //	SQL stuff done in DBResultsDAO

      DBResultsDAO dao = new JDBCDatabaseResults();

      for(int i = 0; i < PPList.size(); i++)
      {
          //dao.addResults(PPList.get(i), countList.get(i));
          dao.updateResults(PPList.get(i), countList.get(i));
      }
  }
}