 package exam.binding;

public class ProductVO {
	String prdName;
	String prdPrice;
	String prdMaker;
	String prdNo;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String prdName, String prdPrice, String prdMaker, String prdNo) {
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
		this.prdNo = prdNo;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(String prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}

	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}
}
