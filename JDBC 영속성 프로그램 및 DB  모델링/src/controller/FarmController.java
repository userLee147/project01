package controller;

import java.util.*;
import java.sql.Date;


import model.vo.Farm;

import model.vo.IOFarm;
import service.FarmService;
import veiw.FarmMenu;


public class FarmController {
	
	private FarmService fs = new FarmService();
	String methodName = null;
	
	
	public void insertItem(String kind, String name, int price, int cnt) {
		Farm f = new Farm(kind, name, price, cnt);
		int result = fs.insertItem(f);

		dmlPrint(result,"추가");
		
	}

	public void searchAll(){
		ArrayList<Farm> list = fs.searchAll();

		selectPrint(list,"검색");


	}
	public void searchWord(String kind) {
		ArrayList<Farm> list = fs.searchWord(kind);

		selectPrint(list,"검색");
		
	}



	public void updateName(String name,String newKind, String newName, int newPrice) {
		
		Farm f = new Farm();
		f.setKind(newKind);
		f.setName(newName);
		f.setPrice(newPrice);

		int result = fs.updateName(name,f);
		
		dmlPrint(result,"수정");
	}


	public void deleteItem(String name){
		int a = fs.deleteItem(name);
		int b = fs.ioNameDelete(name);
		if(a >0 && b >=0){
			dmlPrint(a+b,"삭제");
		}else
			dmlPrint(0,"삭제");


	}

	public void ioInsert(String name,Date date, int amount, String status) {
		IOFarm iof = new IOFarm(name, date, amount, status);
		int reslut = 0;

		reslut = fs.ioInsert(iof);

		dmlPrint(reslut, status);

	}

	public void ioSearchAll(){
		ArrayList<IOFarm> list = new ArrayList<>();
		list = fs.ioSearchAll();
		sort(list);
		selectPrint(list,"검색");
	}
	public void ioSearch(String status){
		ArrayList<IOFarm> list = new ArrayList<>();
		list = fs.ioSearch(status);
		sort(list);
		selectPrint(list,"검색");
	}



	public void ioUpdate(int updateNum,String newName, Date dateValue, int amonut, String status){

		IOFarm iof = new IOFarm(newName, dateValue, amonut, status);
		int a = fs.ioInsert(iof);
		int b = fs.ioDelete(updateNum);
		if((a >0 && b >=0)){
			dmlPrint(a+b,"수정");
		}else{
			dmlPrint(0,"수정");
		}

	}

	public void ioDelete(int removeNum){

		int result = fs.ioDelete(removeNum);


		dmlPrint(result,"삭제");
	}
	public void ioNameDelete(String name){
		int result = fs.ioNameDelete(name);


		dmlPrint(result,"삭제");
	}
	public ArrayList<IOFarm> sum(){
		ArrayList<IOFarm> list = fs.sum();
		return  list;
	}

/*
* 정렬메서드 : list에 담은 데이터를 일자별 내림차순으로 정렬하는 메서드
* */
	public void sort(ArrayList<IOFarm> list){
		Comparator<IOFarm> comparator = (o1, o2) -> o1.getDate().compareTo(o2.getDate());
		Collections.sort(list,comparator);
	}

	/*
	 * 정보제공 출력메서드(메뉴를 선택하기전에 데이터관련 정보를 출력하는 메서드 )
	 * */
	public ArrayList<Farm> selectPrint(){

		ArrayList<Farm> list = fs.searchAll();

		return list;
	}
	public ArrayList<IOFarm> ioSearchPrint(){
		ArrayList<IOFarm> list = fs.ioSearchAll();

		return list;

	}
	public HashSet<String> kindPrint(){
		HashSet<String> set = new HashSet<>();
		ArrayList<Farm> list = fs.searchAll();

		for(int i =0 ; i <list.size();i++){
			set.add(list.get(i).getKind());
		}

		return set;
	}
	public HashSet<String> namePrint(){
		HashSet<String> set = new HashSet<>();
		ArrayList<Farm> list = fs.searchAll();

		for(int i =0 ; i <list.size();i++){
			set.add(list.get(i).getName());
		}

		return set;
	}

	/**
	 * 조회관련 메서드(Service 및 Dao 에서의 성공여부 확인후 Menu 넘겨줌)
	 */
	public void dmlPrint(int result,String print) {

		if (result > 0) { //insert성공
			//성공화면 -> view
			new FarmMenu().displaySuccess("상품 " + print+"에 성공하였습니다");
		} else { //실패
			//실패화면 -> view
			if(result ==-1){
				System.out.println("입고와 출고량의 수량을 확인해주세요");
				System.out.println("* 출고량은 입력해주신 날짜의 재고량을 넘을 수 없습니다. ");
				System.out.println("* 입고량은 변동전의 날짜의 입고량보다 작을 수 없습니다.");
			}
			new FarmMenu().displayFail("상품 " + print+"에 실패하였습니다");
		}
	}

	public void selectPrint(ArrayList list, String methodName) {

		if(list.isEmpty()) {
			new FarmMenu().displayNoData("데이터가 존재하지 않습니다.");
		}else {
			new FarmMenu().displayList(list);
		}
	}


	/* 수정필요
	public void selectAll2(){
		System.out.println(fs.selectAll2());
	}
	*/


}
