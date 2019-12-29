package sample.Tool;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.net.URL;
import java.sql.*;

public class Database {
    private Statement statement;
    private Connection connection;
    private String databaseName;

    public Database(String databaseName) throws SQLException {
        this.databaseName = databaseName;
        this.connection = DriverManager.getConnection("jdbc:mysql://111.229.81.171:3306/"+databaseName+"?useUnicode=true&amp&characterEncoding=utf-8", "system", "S?639sss639?S");
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

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://111.229.81.171:3306/"+databaseName+"?useUnicode=true&amp&characterEncoding=utf-8", "system", "S?639sss639?S");
        this.statement = connection.createStatement();
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }


    public static void main(String[] args) throws SQLException {
        Database database = new Database("book_management");
        database.changeDatabase("INSERT INTO `reader` VALUES ('2018091613005', '影流之主', 2, '123456', '2018-09-01 10:00:00.000000', '2019-06-30 10:00:01.000000');");
        //changeDatabase()
    }



}
