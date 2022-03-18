package dao;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // create an interface that holds methods such as Create, Read, Update, and Delete.
    // define those methods in the classes you create for user, customer, contact, appointment, etc.

    public static User getUserLogin(String userNameText) throws SQLException, Exception{

        DBConnector.openConnection();
        String loginQuery = "SELECT * FROM client_schedule.users WHERE User_Name = '" + userNameText + "'";
        DBQuery.makeQuery(loginQuery);
        User userLogin;
        ResultSet result = DBQuery.getResult();
        while(result.next()){
            int userid = result.getInt("User_ID");
            String userName = result.getString("User_Name");
            String password = result.getString("Password");
            userLogin = new User(userid, userName, password);
            DBConnector.closeConnection();
            return userLogin;
        }
        DBConnector.closeConnection();
        return null;
    }


}
