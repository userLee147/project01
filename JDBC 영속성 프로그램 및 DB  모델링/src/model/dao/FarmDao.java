package model.dao;

import model.vo.Farm;
import model.vo.IOFarm;


import java.sql.*;
import java.sql.Date;
import java.util.*;

import static common.jdbcTemplate.close;

public class FarmDao {

	
	
	
	public int insertItem(Farm f, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;


		String sql = "INSERT INTO Farm VALUES(?,?,?,?)";
		
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,f.getKind());
			pstmt.setString(2, f.getName());
			pstmt.setInt(3, f.getPrice());
			pstmt.setInt(4, f.getCnt());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
				close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Farm> selectAll(Connection conn){
		ResultSet rset = null;
		ArrayList list = new ArrayList();
		PreparedStatement pstmt =null;

		String sql = "SELECT * FROM FARM";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();


			while(rset.next()){
				Farm f = new Farm();
				f.setKind(rset.getString("PKIND"));
				f.setName(rset.getString("PNAME"));
				f.setPrice(rset.getInt("PRICE"));
				f.setCnt(rset.getInt("CNT"));
				list.add(f);

			}


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public ArrayList<Farm> searchKind(String word, Connection conn) {
		ResultSet rset = null;
		ArrayList list = new ArrayList();
		PreparedStatement pstmt = null;
		String sql = null;
		
		
		sql = "SELECT * FROM FARM WHERE PKIND = ?";

		try {

			pstmt =conn.prepareStatement(sql);
			

			pstmt.setString(1,word);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Farm f = new Farm();

				f.setKind(rset.getString("PKIND"));
				f.setName(rset.getString("PNAME"));
				f.setPrice(rset.getInt("PRICE"));
				f.setCnt(rset.getInt("CNT"));
				
				list.add(f);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public ArrayList<Farm> searchKeyword(String word, Connection conn) {
		ResultSet rset = null;
		ArrayList list = new ArrayList();

		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM FARM WHERE PNAME LIKE '%'||?||'%'";

		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,word);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Farm f = new Farm();

				f.setKind(rset.getString("PKIND"));
				f.setName(rset.getString("PNAME"));
				f.setPrice(rset.getInt("PRICE"));
				f.setCnt(rset.getInt("CNT"));

				list.add(f);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}



	
	public int updateName(String name ,Farm f, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = "Update Farm set PKIND =?, PNAME =?, PRICE =? where PNAME= ? ";
		
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, f.getKind());
			pstmt.setString(2, f.getName());
			pstmt.setInt(3, f.getPrice());
			pstmt.setString(4, name);


			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
				close(pstmt);
		}
		
		return result;
	}


	public int deleteItem(String name, Connection conn){

		int result = 0;
		PreparedStatement pstm = null;

		String sql = "Delete from Farm where pname = ?";
        try {
            pstm = conn.prepareStatement(sql);

			pstm.setString(1,name);

			result =pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return result;
    }
	public int ioInsert(IOFarm iof, Connection conn){

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO IOFarm VALUES(SEQ_IOFARM.NEXTVAL,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);



			pstmt.setString(1,iof.getName());
			pstmt.setDate(2, iof.getDate());
			pstmt.setInt(3, iof.getAmount());
			pstmt.setString(4, iof.getStatus());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}


	public ArrayList<IOFarm> sumIoOutput(String name, Date date, Connection conn){
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<IOFarm> list = new ArrayList();


		String sql = "select pname, status, sum(AMOUNT) from IOFARM join farm using(pname) where IOfarm.iodate <= ? group by pname,status";


		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setDate(1,date);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				IOFarm f = new IOFarm();


				f.setName(rset.getString("PNAME"));
				f.setStatus(rset.getString("STATUS"));
				f.setAmountSum(rset.getInt("sum(AMOUNT)"));



				list.add(f);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}
	public ArrayList<IOFarm> ioSearchAll(Connection conn) {
		ResultSet rset = null;
		ArrayList list = new ArrayList();
		PreparedStatement pstmt = null;


		String sql = "select * from IOFARM join farm using(pname)";

		try {
			pstmt =conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				IOFarm iof = new IOFarm();

				iof.setIoNum(rset.getInt("IONUM"));
				iof.setName(rset.getString("PNAME"));
				iof.setDate(rset.getDate("IODATE"));
				iof.setAmount(rset.getInt("AMOUNT"));
				iof.setStatus(rset.getString("STATUS"));

				list.add(iof);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}
	public ArrayList<IOFarm> ioSearch(String status, Connection conn) {
		ResultSet rset = null;
		ArrayList list = new ArrayList();
		PreparedStatement pstmt = null;


		String sql = "select * from IOFARM join farm using(pname) where STATUS = ?";

		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,status);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				IOFarm f = new IOFarm();

				f.setIoNum(rset.getInt("IONUM"));
				f.setName(rset.getString("PNAME"));
				f.setDate(rset.getDate("IODATE"));
				f.setAmount(rset.getInt("AMOUNT"));
				f.setStatus(rset.getString("STATUS"));

				list.add(f);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}



	public int ioDelete(int removeNum, Connection conn){

		int result = 0;
		PreparedStatement pstm = null;

		String sql = "Delete from IOFarm where IONUM = ?";
		try {
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1,removeNum);

			result =pstm.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	public int ioNameDelete(String name, Connection conn){

		int result = 0;
		PreparedStatement pstm = null;

		String sql = "Delete from IOFarm where pname = ?";
		try {
			pstm = conn.prepareStatement(sql);

			pstm.setString(1,name);

			result =pstm.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	public ArrayList<IOFarm> sum(Connection conn){
		ResultSet rset = null;
		ArrayList list = new ArrayList();
		PreparedStatement pstmt = null;

		String sql ="select pname, status, SUM(cnt * amount)as iosum from iofarm\n" +
				"join farm using (pname) group by pname, status";
		try {
			pstmt =conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				IOFarm f = new IOFarm();


				f.setName(rset.getString("PNAME"));
				//f.setDate(rset.getDate("IODATE"));
				f.setAmountSum(rset.getInt("iosum"));
				f.setStatus(rset.getString("STATUS"));

				list.add(f);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}
	public List<HashMap<String, Object>> selectAll2(Connection conn){
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		List<HashMap<String, Object>> hashMapList = new ArrayList<>();
		String sql = "Select * from Farm";
		int i =0;
		try {

			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			HashMap<String,Object> hashMap = new HashMap<>();

			while (rset.next()){
				hashMap.put("kind",rset.getString("PKIND"));
				hashMap.put("name",rset.getString("PNAME"));
				hashMap.put("price",rset.getInt("PRICE"));
				hashMap.put("quanity",rset.getInt("QUANITY"));

				hashMapList.add(hashMap);

			}


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return hashMapList;

	}

}
