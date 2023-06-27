/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BirdCategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;

/**
 *
 * @author PC
 */
public class CategoriesDAO {

    private static final String GET_ALL_CATE = "select * from dbo.tblBirdCategories";

    public List<BirdCategoryDTO> getAllCate() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BirdCategoryDTO> list = new ArrayList<>();
        try {
            con = DBContext.getConnection();
            if(con != null){
                stm = con.prepareStatement(GET_ALL_CATE);
                rs = stm.executeQuery();
                if(rs != null){
                    while (rs.next()) {                        
                        int cateID = rs.getInt(1);
                        String cateName = rs.getString(2);
                        BirdCategoryDTO birdCate = new BirdCategoryDTO(cateID, cateName);
                        list.add(birdCate);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(con != null){
                con.close();
            }
            if(stm != null){
                stm.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return list;

    }
    
}
