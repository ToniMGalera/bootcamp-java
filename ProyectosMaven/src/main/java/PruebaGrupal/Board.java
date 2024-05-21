package PruebaGrupal;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Card> cards;

    public Board() {
        cards = new ArrayList<>();
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/resources/default.png"));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/memory_game", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT image FROM cards");

            while (rs.next()) {
                byte[] imgBytes = rs.getBytes("image");
                ImageIcon image = new ImageIcon(imgBytes);
                cards.add(new Card(image, defaultIcon));
                cards.add(new Card(image, defaultIcon)); // Duplicar para tener parejas
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
