package com.book.member.book.dao;

import com.book.member.book.vo.Like;

import static com.book.common.sql.JDBCTemplate.getConnection;
import static com.book.common.sql.JDBCTemplate.close;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LikeDao {

	//  독후감 좋아요 추가
    public int insertLike(Like lk) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        int result = 0;

        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO `like` (user_no, books_category_no, booktext_no)"
                    + "VALUES (?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lk.getUser_no());
            pstmt.setInt(2, lk.getBook_category_no());
            pstmt.setInt(3, lk.getBooktext_no());

            result = pstmt.executeUpdate();

            conn.commit();

        } catch(Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            close(pstmt);
            close(conn);
        }
        return result;
    }
//  독후감 좋아요 삭제
    public int deleteLike(Like lk) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM `like` WHERE user_no = ? AND booktext_no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lk.getUser_no());
            pstmt.setInt(2, lk.getBooktext_no());

            result = pstmt.executeUpdate();

            conn.commit();

        } catch(Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();  
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            close(pstmt);
            close(conn);
        }
        return result;
    }
//  독후감 좋아요 갯수
    public int countLike(int booktextNo) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;

        try {
            String sql = "SELECT COUNT(*) AS lkCnt FROM `like` "
                    + "WHERE booktext_no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, booktextNo);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = rs.getInt("lkCnt");
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
            close(conn);
        }
        return result;
    }
// 독후감 좋아요 체크 확인
    public int likeChecked(int userNo, int booktextNo) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
        
            conn.setAutoCommit(false);
            String sql = "SELECT like_no FROM `like` "+
                    "WHERE user_no = ? AND booktext_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            pstmt.setInt(2, booktextNo);

            rs = pstmt.executeQuery();
          
            if(rs.next()) {
                result = 1;
             
            } else {
                result = 0;
            }
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
            close(conn);
        }
        return result;
    }
}