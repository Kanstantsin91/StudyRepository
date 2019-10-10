package mySQL;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=Europe/Minsk&useSSL=false",
                "root", "138Lfc1937!1");

        ArrayList<Shops> shopsArrayList = new ArrayList<>();
//
//        Shops shop5 = new Shops(5, "rublevski");
//        Shops shop6 = new Shops(6, "spar");
//        Shops shop7 = new Shops(7, "korona");
//        Shops shop8 = new Shops(8, "hit");
//        Shops shop9 = new Shops(9, "kirmash");
//        Shops shop10 = new Shops(10, "dionis");
//        Shops shop11 = new Shops(11, "kopilka");
//        Shops shop12 = new Shops(12, "bigs");
//
//        shopsArrayList.add(shop5);
//        shopsArrayList.add(shop6);
//        shopsArrayList.add(shop7);
//        shopsArrayList.add(shop8);
//        shopsArrayList.add(shop9);
//        shopsArrayList.add(shop10);
//        shopsArrayList.add(shop11);
//        shopsArrayList.add(shop12);


//        for (int i = 0; i < shopsArrayList.size(); i++) {
//            String queryAdd = "INSERT INTO `store`.`shop` (`shop_id`, `title`) VALUES (\'"+shopsArrayList.get(i).shop_id+"\', \'"+shopsArrayList.get(i).title+"\')";
//            PreparedStatement st = connection.prepareStatement(queryAdd);
//            st.execute();
//        }


//        String query = "SELECT * FROM store.shop";
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(query);
//        while (rs.next()) {
//            int id = rs.getInt("shop_id");
//            String title = rs.getString("title");
//
//            System.out.printf("%d %s%n", id, title);
//        }
//        statement.close();

        String query = "select * from item,shop where item.shop_id=shop.shop_id and shop.title='evroopt'"; // and item.price<2";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            //int id = rs.getInt("shop_id");
            String title = rs.getString("title");
            String itemType = rs.getString("item_type");
            String itemTitle = rs.getString("item_title");
            double price = rs.getDouble("price");

            System.out.printf("В магазине %s продается %s марки %s по цене %.02f%n", title, itemType, itemTitle, price);
        }
        statement.close();
    }
}
