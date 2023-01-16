package org.example.connector;

import java.sql.*;

public class TempUserDao {

    public void create(TempUser tempUser) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tempUser.getUserId());
            pstmt.setString(2, tempUser.getPassword());
            pstmt.setString(3, tempUser.getName());
            pstmt.setString(4, tempUser.getEmail());
            pstmt.executeUpdate();
        } finally {
            if(pstmt != null) {
                pstmt.close();
            }

            if(con != null) {
                con.close();
            }
        }
    }

    public TempUser findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();
            TempUser tempUser = null;

            if(rs.next()){
                tempUser = new TempUser(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }

            return tempUser;
        } finally {
            if(rs != null){
                rs.close();
            }

            if(pstmt != null) {
                pstmt.close();
            }


            if(con != null) {
                con.close();
            }
        }
    }
}
