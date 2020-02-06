package com.mysoft;

import javafx.geometry.Pos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "root12345");
    }

    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {
        ArrayList<Post> posts = new ArrayList<Post>();

        try (Connection c = getConnection();
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");){

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String txt = resultSet.getString(2);
                posts.add(new Post(id, txt));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure!");
            e.printStackTrace();
        }

        return posts;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getPosts());
    }

    // !!!!!!!!!подготовка запроса для postggrsql
    public static void deletePost(int id) {
        try (Connection c = getConnection();
             Statement statement = c.createStatement();){
            statement.executeQuery("DELETE FROM posts WHERE id = " + id);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure!");
            e.printStackTrace();
        }

    }

    public static void addPost(String txt) {
        try (Connection c = getConnection();
             Statement statement = c.createStatement();){
            statement.executeQuery("INSERT INTO posts (id, txt) VALUES(nextval('posts_sequence'), '" + txt + "')");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure!");
            e.printStackTrace();
        }
    }
}
