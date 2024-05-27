/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DAOBooks extends DBContext {
    public static void main(String[] args) {
DAOBooks b=new DAOBooks();
List<Books> list=b.getAll();
System.out.println(list.get(0).getName());
}
}
