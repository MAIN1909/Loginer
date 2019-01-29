package dao;

import entity.Item;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class MySqlItemDao implements ItemDao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://contac01.mysql.ukraine.com.ua/contac01_prilosh";
    private static final String LOGIN = "contac01_prilosh";
    private static final String PASS = "4h57futz";

    private Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Item> get() {
        List<Item> out = new LinkedList<>();
        Connection c = getConnection();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM loginer_item");
            while (rs.next()) {
                out.add(new Item(UUID.fromString(rs.getString("id")),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getString("pic")));
            }
            st.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public Item getById(String id) {
        Item out = null;
        Connection c = getConnection();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM loginer_item WHERE id='" + id + "'");

            System.out.println(rs.next());
            out = new Item(UUID.fromString(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("price"),
                    rs.getString("pic"));

            st.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public List<Item> getByName(String name) {
        List<Item> out = new LinkedList<>();
        Connection c = getConnection();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM loginer_item WHERE name LIKE '%" + name + "%'");
            while (rs.next()) {
                out.add(new Item(UUID.fromString(rs.getString("id")),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getString("pic")));
            }
            st.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public void save(Item i) {

        Connection c = getConnection();

        String query = " insert into loginer_item (id,name, description, price,pic)" + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, UUID.randomUUID().toString());
            preparedStmt.setString(2, i.getName());
            preparedStmt.setString(3, i.getDescription());
            preparedStmt.setString(4, String.valueOf(Integer.parseInt(String.valueOf(i.getPrice()))));
            preparedStmt.setString(5, i.getPic());
            preparedStmt.execute();
            c.close();
        } catch (SQLException e1) {
            e1.printStackTrace();

        }


    }
}
