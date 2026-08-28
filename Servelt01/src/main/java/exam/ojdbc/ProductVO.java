 package exam.ojdbc;

public class ProductVO {
	String prdName;
	String prdPrice;
	String prdMaker;
	String prdId;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String prdName, String prdPrice, String prdMaker, String prdId) {
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
		this.prdId = prdId;
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

	public String getPrdId() {
		return prdId;
	}

	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}

	
}