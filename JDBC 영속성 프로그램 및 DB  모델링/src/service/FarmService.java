package service;

import model.dao.FarmDao;
import model.vo.Farm;
import model.vo.IOFarm;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static common.jdbcTemplate.*;


public class FarmService {
	
	private FarmDao fd = new FarmDao();
	
	public int insertItem(Farm f) {
		Connection conn = getConnection();

		int result = fd.insertItem(f, conn);

		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}

		close(conn);
		return result;

	}

	public ArrayList<Farm> searchAll() {
		Connection conn = getConnection();
		ArrayList list = fd.selectAll(conn);

		close(conn);

		return list;
	}

	public ArrayList<Farm> searchWord(String word){
		Connection conn = getConnection();
		ArrayList<Farm> searchList = searchAll();
		ArrayList<Farm> list  = new ArrayList<>();


		for(Farm f : searchList){
			if(f.getKind().equals(word)){
				list = fd.searchKind(word,conn);
			} else if (f.getName().equals(word)) {
				list = fd.searchKeyword(word,conn);
			}

		}


		
		close(conn);
		return list;
	}




	public int updateName(String name, Farm f) {
		Connection conn = getConnection();
		int result = fd.updateName(name,f, conn);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
	}


	public int deleteItem(String name){
		Connection conn = getConnection();
		int result = fd.deleteItem(name, conn);

		if(result > 0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int ioInsert(IOFarm iof){
		Connection conn = getConnection();
		int result =0;
		/*
		if (iof.getStatus().equals("출고")) {
			ArrayList<Farm> list = fd.selectAll(conn);
			int a = 0;

			for (Farm f : list) {
				if (f.getName().equals(iof.getpName())) {
					a = f.getQuanity();//현재 재고량
				}
			}
			if(a - iof.getaMount() < 0){
				result =-1;
			}else {
				result = fd.ioInsert(iof, conn);
			}
		}else {
			result = fd.ioInsert(iof, conn);
		}
		*/
		if(iof.getStatus().equals("출고")){
			int sum =  ioOutputUpdate(iof.getName(),iof.getDate());

			if(sum - iof.getAmount() >= 0){
				result  = fd.ioInsert(iof,conn);
			}else{
				result =-1;
			}
		}else{
			result  = fd.ioInsert(iof,conn);
		}

		if(result > 0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// sumIoOutput 삭제예정


	public ArrayList<IOFarm> ioSearchAll() {
		Connection conn = getConnection();
		ArrayList list = fd.ioSearchAll(conn);

		close(conn);
		return list;
	}
	public ArrayList<IOFarm> ioSearch(String status) {
		Connection conn = getConnection();
		ArrayList list = fd.ioSearch(status, conn);

		close(conn);
		return list;
	}



	public int ioOutputUpdate(String name, Date date){
		Connection conn = getConnection();
		ArrayList<IOFarm> list1 = fd.sumIoOutput(name,date,conn);
		int a = 0;
		int b = 0;


		for(int i =0 ;i <list1.size();i++){
			if(list1.get(i).getName().equals(name)){
				if(list1.get(i).getStatus().equals("입고")){
					a = list1.get(i).getAmountSum();

				}else if(list1.get(i).getStatus().equals("출고")){
					b = list1.get(i).getAmountSum();
				}
			}

		}

		close(conn);

		return a-b;

	}

	public int ioDelete(int removeNum){
		Connection conn = getConnection();
		int result =0;


		result  = fd.ioDelete(removeNum,conn);



		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}

		close(conn);
		return result;
	}
	public int ioNameDelete(String name){
		Connection conn = getConnection();
		int result =0;


		result  = fd.ioNameDelete(name,conn);



		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}

		close(conn);
		return result;
	}
	public ArrayList<IOFarm> sum(){
		Connection conn = getConnection();
		ArrayList<IOFarm> list = fd.sum(conn);

		close(conn);
		return  list;
	}
	/*오류 수정필요
	public List<HashMap<String, Object>> selectAll2() {
		Connection conn = getConnection();
		List<HashMap<String, Object>> list = fd.selectAll2(conn);

		close(conn);
		return list;
	}
	*/
}
