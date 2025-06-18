package veiw;


import controller.FarmController;
import model.vo.Farm;
import model.vo.IOFarm;

import java.sql.Date;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;


public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		while (true){
			while(true){

				System.out.println();
				System.out.println("|  메뉴를 선택해주세요  |");
				System.out.println("1. 상품 목록 추가");
				System.out.println("2. 상품 검색");
				System.out.println("3. 상품 수정");
				System.out.println("4. 상품 삭제");
				System.out.println("5. 상품입출고 메뉴");
				System.out.println("9. 프로그램 종료");

				System.out.println("메뉴선택 : ");
				int menu = sc.nextInt();
				sc.nextLine();

				switch(menu) {
					case 1 :
						insertMenu();
						break;
					case 2 :
						searchMenu();
						break;
					case 3 :
						updateName();
						break;
					case 4 :
						deleteItem();
						break;
					case 5 :
						ioMenu();
						break;
					case 9 :
						System.out.println("프로그램을 종료합니다.");
						return;
					default:
						System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요");
				}
			}

		}

		
	}

	public void insertMenu(){
		while (true){
			System.out.println();
			System.out.println("====== 전체 상품 리스트 ======");
			fc.searchAll();

			System.out.println();
			System.out.println("======  추 가 메 뉴  ======");
			System.out.println("추가하실 항목을 선택해주세요");
			System.out.println("1. 과일  2. 채소");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num){
				case 1 :
					insertItem("과일");
					return;
				case 2:
					insertItem("채소");
					return;
				default:
					System.out.println("메뉴번호를 잘못입력하셨습니다. 다시입력해주세요");
			}
		}

	}

	public  void insertItem(String kind){
			System.out.println("상품을 입력해주세요");
			String name = sc.nextLine();

			System.out.println("단가를 입력해주세요");
			int price = sc.nextInt();
			sc.nextLine();

			System.out.println("수량은 0으로 초기화됩니다.");


			fc.insertItem(kind,name,price,0);

	}

	public void searchMenu() {
		while (true){
			System.out.println("======  검 색 메 뉴 ======");
			System.out.println("1.전체 출력");
			System.out.println("2.품목 검색");
			System.out.println("3.상품이름 검색");
			System.out.println("4.메인으로 돌아가기");
			int menu = sc.nextInt();
			sc.nextLine();


			switch(menu) {
				case 1:
					System.out.println();
					System.out.println("====== 전체 상품 리스트 ======");
					fc.searchAll();
					return;

				case 2:
					System.out.println();
					System.out.println("====== 상품 품목 리스트 ======");
					System.out.println(fc.kindPrint());

					System.out.println("검색할 품목을 입력하세요 :");
					String kind = sc.nextLine();
					fc.searchWord(kind);
					return;

				case 3:
					System.out.println("검색할 상품이름을 입력하세요");
					String name = sc.nextLine();
					fc.searchWord(name);
					return;

				case 4 :
					System.out.println("메인으로 돌아갑니다.");
					return;

				default:
					System.out.println("메뉴번호를 잘못입력하셨습니다. 다시입력해주세요");
			}

		}

	}


	public void updateName() {

		System.out.println();
		System.out.println("====== 전체 상품 리스트 ======");
		fc.searchAll();


		System.out.println("목록에서 수정할 상품이름을 입력해주세요");
		String name = sc.nextLine();


		System.out.println(fc.kindPrint());
		System.out.println("목록에서 어떤 품목으로 변경하시겠습니까?");
		String newKind = sc.nextLine();

		System.out.println("이름 변경시 입출고내역도 모두 변경됩니다.");
		System.out.println("변경할 이름을 입력해주세요");
		String newName = sc.nextLine();


		System.out.println("변경할 단가를 입력해주세요");
		int newPrice = sc.nextInt();
		sc.nextLine();



		fc.updateName(name, newKind,newName,newPrice);


	}
	public void deleteItem(){
		System.out.println();
		System.out.println("====== 전체 상품 리스트 ======");
		fc.searchAll();

		System.out.println("상품 삭제시 입출고내역도 모두 삭제됩니다.");
		System.out.println("삭제할 상품이름을 입력해주세요");
		String name = sc.nextLine();


		fc.deleteItem(name);
		System.out.println();


	}

	public void ioMenu(){
		while (true){
			System.out.println();
			System.out.println("|      입고/출고 메뉴      |");
			System.out.println("1. 상품 입고출고내역 보기");
			System.out.println("2. 상품 입고/출고 입력하기 ");
			System.out.println("3. 상품 입고/출고 삭제하기");
			System.out.println("4. 상품 입고/출고 수정하기");
			System.out.println("6. 상품 입고/ 출고 합계");
			System.out.println("5. 메인으로 돌아가기");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu){
				case 1:
					ioSearchMenu();
					break;
				case 2:
					ioInsertMenu();
					break;
				case 3 :
					ioDelete();
					break;
				case 4 :
					ioUpdateMenu();
					break;
				case 5 :
					System.out.println("메인으로 돌아갑니다.");
					return;
				case 6 :
					sum();
					return;
				default:
					System.out.println("메뉴번호를 잘못입력하셨습니다. 다시입력해주세요");

			}

		}
	}


	public void ioSearchMenu(){
		while (true){
			System.out.println();
			System.out.println("====== 입고/출고 내역 세부메뉴 =======");
			System.out.println("1. 전체입출고내역 보기 ");
			System.out.println("2. 상품별 내역 보기");
			System.out.println("3. 입고/출고별 내역 보기");
			System.out.println("5. 입출고메뉴로 돌아가기");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu){
				case 1:
					fc.ioSearchAll();
					break;
				case 2 :
					ioSearchName();
					return;
				case 3 :
					System.out.println();
					System.out.println("======  입고/출고 선택 =======");
					System.out.println("입고 또는 출고를 선택해주세요");
					System.out.println("1. 입고   2. 출고");
					int status = sc.nextInt();
					sc.nextLine();
					String status1 = (status == 1 ? "입고" : status == 2 ? "출고" :"null");
					fc.ioSearch(status1);
					return;
				case 5 :
					System.out.println("메인으로 돌아가기");
					return;
				default:
					System.out.println("메뉴번호를 다시 입력해주세요");
			}
		}

	}

	public void ioSearchName(){
		while (true){
			System.out.println();
			System.out.println("====== 전체 상품 리스트 ======");
			fc.searchAll();

			System.out.println();
			System.out.println("======  상품별 검색 메뉴 =======");
			System.out.println("검색하실 상품명을 입력해주세요");
			String name = sc.nextLine();



			ArrayList<IOFarm> list = fc.ioSearchPrint();

			if(list.isEmpty()){
				System.out.println("찾으시는 내용이 없습니다.");
				return;
			}else {
				for(IOFarm io : list){
					if(io.getName().equals(name)){
						System.out.println(io);
					}
				}
				return;
			}




		}
	}

	public void ioInsertMenu(){
		while (true){
			System.out.println();
			System.out.println("======  입고/출고 추가 =======");
			System.out.println("입고 또는 출고를 선택해주세요");
			System.out.println("1. 입고   2. 출고");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu){
				case 1 :
					ioInsert("입고");
					return;
				case 2 :
					ioInsert("출고");
					return;
				default:
					System.out.println("입고 출고 메뉴 번호를 다시 입력해주세요");
			}
		}

	}
	public void ioInsert(String status){

		System.out.println();
		System.out.println("====== 전체 상품 리스트 ======");
		fc.searchAll();


		System.out.println(status+"할 상품의 이름을 입력해주세요 :");
		String name = sc.nextLine();

		System.out.println(status +"날짜(yyyymmdd)를 입력해주세요 :");
		String date = sc.nextLine();
		Date dateValue = isDate(date);

		System.out.println(status +" 수량을 입력해주세요 :");
		int amonut = sc.nextInt();
		sc.nextLine();



		fc.ioInsert(name,dateValue,amonut, status);

		System.out.println();
		System.out.println("======= 입출고후 상품의 재고량 =======");
		ioprint(name);

	}




        public void ioUpdateMenu(){
            while(true){
				System.out.println();
				System.out.println("======= 입고/출고내역 목록 =======");
                fc.ioSearchAll();

                System.out.println("변경할 사항을 선택해주세요");
                System.out.println("1. 입고   2. 출고");
                int menu = sc.nextInt();
                sc.nextLine();

                switch (menu){
                    case 1 :
                        ioUpdate("입고");
                        return;
                    case 2 :
                        ioUpdate("출고");
                        return;
                    default:
                        System.out.println("입고 출고 메뉴 번호를 다시 입력해주세요");
                }
            }

        }

    public  void  ioUpdate(String ioStatus){
			System.out.println();
            System.out.println("======= "+ioStatus+"내역 목록 =======");
            fc.ioSearch(ioStatus);

            System.out.println("위의 목록에서 변경할 항목의 번호를 입력해주세요" );
            int updateNum = sc.nextInt();
            sc.nextLine();

			System.out.println();
            System.out.println("======= 현재 보유 상품이름 목록 =======");
			System.out.println("보유 상품목록의 이름으로만 변경할 수 있습니다.");

			System.out.println(fc.namePrint());

            System.out.println("수정할 상품의 이름을 입력해주세요 :");
            String newName = sc.nextLine();


        	System.out.println("수정할 "+ ioStatus + " 날짜(yyyy-mm-dd)를 입력해주세요 :");
            String date = sc.nextLine();
            Date dateValue = isDate(date);



			ArrayList<IOFarm> list = fc.ioSearchPrint();
			int amount = 0;
			for(IOFarm iof : list){
				if(iof.getIoNum() == updateNum){
					amount = iof.getAmount();

			}

			}
			fc.ioUpdate(updateNum,newName,dateValue,amount,ioStatus);


			System.out.println();
			System.out.println("======= 입출고 변경 후 상품의 재고량 =======");

			ioprint(newName);

        }

	public  void  ioDelete(){
		while(true){
			System.out.println();
			System.out.println("======= 삭제 세부메뉴 =======");
			System.out.println("1. 입출고 건별 삭제하기(1건씩 삭제)");
			System.out.println("2. 상품 입출고내역 전체 삭제하기");
			System.out.println("5. 입출고 메뉴로 돌아가기");
			int menu = sc.nextInt();
			sc.nextLine();

			System.out.println();
			System.out.println("======= 입고/출고내역 목록 =======");
			fc.ioSearchAll();

			switch (menu){
				case 1 :
					System.out.println("위의 목록에서 삭제할 항목의 번호를 입력해주세요" );
					int removeNum = sc.nextInt();
					sc.nextLine();

					fc.ioDelete(removeNum);

					System.out.println();
					System.out.println("======= 입출고후 상품의 재고량 =======");
					ArrayList<IOFarm> list = fc.ioSearchPrint();
					for(IOFarm iof : list){
						if(iof.getIoNum() == removeNum){
							String name = iof.getName();
							ioprint(name);
							break;
						}

					}



					break;
				case 2 :
					System.out.println("위의 목록에서 삭제할 상품의 이름을 입력해주세요 ");
					String name = sc.nextLine();
					fc.ioNameDelete(name);

					System.out.println();
					System.out.println("======= 입출고후 상품의 재고량 =======");
					ioprint(name);
					break;
				case 5 :
					return;
				default:
					System.out.println("메뉴번호를 다시 입력해주세요");
			}

		}

	}
	public void sum(){
		ArrayList<IOFarm> list = fc.sum();
		for(IOFarm i : list){
			System.out.println(i.getName() + ", " + i.getStatus() + ", " + i.getAmountSum());
		}
	}
	/**
	 * 조회서비스 요청시 조회결과가 없을 때 사용자가 보게될 응답화면
	 * message :죄회결과에 대한 응답메세지	
	 */
	public void isIoSelect(int choice, String status){
		if(choice == 1){
			return;
		} else if (choice == 2) {
			System.out.println("======= " + status +"내역 =======");
			fc.ioSearch(status);

		}
	}
	public Date isDate(String date){

		int yyyy = parseInt(date.substring(0,4))-1900;
		int mm = parseInt(date.substring(4,6))-1;
		int dd = parseInt(date.substring(6));

		return new Date(yyyy,mm,dd);
	}

	public void ioprint(String name){
		ArrayList<Farm> list = fc.selectPrint();
		for(Farm f : list){
			if(f.getName().equals(name)){
				System.out.println("[ 상품명 : "+f.getName()+"| 재고량 = "+f.getCnt()+" ]");
			}

		}
	}

		
	/**
	 * 조회서비스 요청 결과가 여러행일 경우 보게될 응답화면
	 * list : 조회결과
	 */
		public void displayList(ArrayList<Object> list) {


			for( int i = 0 ; i <list.size() ; i++){
				if(list.get(i) instanceof Farm){
					System.out.println(list.get(i));
				}
				if(list.get(i) instanceof IOFarm){

					if(i == 0){
						System.out.println("목록번호 |  " +"상품이름 | " + "상품수량 | " + "입출고일자 |  "+"입출고구분 |");
					}
					System.out.println("[ "+
							((IOFarm) list.get(i)).getIoNum() +"    | "
							+((IOFarm) list.get(i)).getName() +"    | "
							+((IOFarm) list.get(i)).getAmount() +"     |  "
							+((IOFarm) list.get(i)).getDate() +" | "
							+((IOFarm) list.get(i)).getStatus()+" ]");

				}
			}


		}

	public void displayNoData(String message) {
		System.out.println("\n" +message);
	}

	public void displaySuccess(String message) {
			System.out.println("\n서비스 요청 성공 : " +message);
		}
		
		public void displayFail(String message) {
			System.out.println("\n서비스 요청 실패 : " +message);
		}
}
