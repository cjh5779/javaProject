package com.spring_mvc.jdbc2.dto;

public class ProductDTO {
	private String prdId;
    private String prdName;
    private int prdPrice;
    private String prdMaker;

    public ProductDTO() {}

    public ProductDTO(String prdId, String prdName, int prdPrice, String prdMaker) {
        this.prdId = prdId;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdMaker = prdMaker;
    }

	public String getPrdId() {
		return prdId;
	}

	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}
    
    
}
