package model.vo;

import java.util.Objects;

public  class Farm {

	private String kind;
	private String name;
	private int price;
	private int cnt;

	public Farm() {
	}

	public Farm(String kind, String name, int price, int cnt) {
		this.kind = kind;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Farm farm = (Farm) o;
		return price == farm.price && cnt == farm.cnt && Objects.equals(kind, farm.kind) && Objects.equals(name, farm.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(kind, name, price, cnt);
	}

	@Override
	public String toString() {
		return "[ " + kind + " : " +
				 name + " | " +
				" price = " + price +
				" | quanity = " + cnt +
				" ]";
	}
	// [과일 : 사과 | 단가 = 2000 | 수량 = 20]

}
