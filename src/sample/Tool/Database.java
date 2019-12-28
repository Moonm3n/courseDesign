package sample.Tool;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.net.URL;
import java.sql.*;

public class Database {
    private Statement statement;
    private Connection connection;

    public Database(String databaseName) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://111.229.81.171:3306/"+databaseName, "system", "S?639sss639?S");
        this.statement = connection.createStatement();
    }

    public int changeDatabase(String sql) throws SQLException {
        int i = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        return i;
    }

    public ResultSet searchDatabase(String sql) throws  SQLException{
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }


    public static void main(String[] args) {
        //changeDatabase()
    }
}
