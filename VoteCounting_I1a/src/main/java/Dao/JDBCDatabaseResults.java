package dao;

import java.sql.*;


public class JDBCDatabaseResults implements DBResultsDAO{
	
	private Connection conn;

    private static final String DB_URL = "jdbc:hsqldb:hsql://localhost";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
	
	public JDBCDatabaseResults()
	{
		 try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void updateResults(String PoliticalParty, int totalVotes)
	{
        String sql = "UPDATE RESULTS SET TOTAL_VOTES = ? WHERE POLITICAL_PARTY = ?;";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, totalVotes);
            statement.setString(2, PoliticalParty);

            //ResultSet resultSet = statement.executeQuery();

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
           //System.out.Println("Database Offline");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                //System.out.Println("Database Offline");
            }
        }
	}

    @Override
    public void addResults(String PoliticalParty, int totalVotes)
    {
        String sql = "INSERT INTO RESULTS " +
                "(POLITICAL_PARTY, TOTAL_VOTES ) " +
                "VALUES ( ?,? )";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, PoliticalParty);
            statement.setInt(2, totalVotes);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            //System.out.Println("Database Offline");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                //System.out.Println("Database Offline");
            }
        }
    }
}