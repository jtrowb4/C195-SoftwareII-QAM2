package dao;

import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DBQuery {
    private static String query;
    private static Statement statement;
    private static ResultSet result;

    public static void makeQuery(String query){
        query = query;
        try{
            statement = DBConnector.connection.createStatement();
            // determine query execution
            if(query.toUpperCase().startsWith("SELECT"))
                result=statement.executeQuery(query);
            if(query.toUpperCase().startsWith("DELETE")||query.toUpperCase().startsWith("INSERT")||query.toUpperCase().startsWith("UPDATE"))
                statement.executeUpdate(query);

        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static ResultSet getResult(){

        return result;
    }
}
