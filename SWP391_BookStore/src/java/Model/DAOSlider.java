/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Slider;
import java.util.Vector;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TDG
 */
public class DAOSlider extends DBConnect{
    public Vector<Slider> getAll(String sql) {
        Vector<Slider> vector = new Vector<>();
        try {

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                
                int sliderId = rs.getInt("slider_id");
                int userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String image = rs.getString("image");
                String status = rs.getString("status");
                 Slider c = new Slider(sliderId, userId, title, image, status);
                 vector.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSlider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
        DAOSlider daoCampaigns = new DAOSlider();
        Vector<Slider> vectorCampains = daoCampaigns.getAll("select * from slider ORDER BY slider_id DESC LIMIT 3");
        for (Slider vectorCampain : vectorCampains) {
            System.out.println(vectorCampain);
        }
    }
}
