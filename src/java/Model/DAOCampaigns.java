/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Campaigns;
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
public class DAOCampaigns extends DBConnect{
    public Vector<Campaigns> getAll(String sql) {
        Vector<Campaigns> vector = new Vector<>();
        try {

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                
                int compaigh_id = rs.getInt(1);
                int user_id = rs.getInt(2);
                int book_id = rs.getInt(3);
                String name = rs.getString(4);
                String description = rs.getString(5);
                Date start_date = rs.getDate(6);
                Date end_date = rs.getDate(7);
                Timestamp created_at = rs.getTimestamp(8);
                Timestamp updated_at = rs.getTimestamp(9);
                Campaigns c = new Campaigns(compaigh_id, user_id, book_id, name, description, start_date, end_date, created_at, updated_at);
                vector.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCampaigns.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
        DAOCampaigns daoCampaigns = new DAOCampaigns();
        Vector<Campaigns> vectorCampains = daoCampaigns.getAll("select * from Campaigns ORDER BY compaigh_id DESC LIMIT 3");
        for (Campaigns vectorCampain : vectorCampains) {
            System.out.println(vectorCampain);
        }
    }
}
