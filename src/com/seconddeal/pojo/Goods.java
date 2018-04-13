package com.seconddeal.pojo;

public class Goods {
	private String GOODSNAME;
	private String DETAIL;
	private String PRICE;
	private String PIC;
	private String SELLERNAME;
	private String TEL;
	private int STATE;
	
	public Goods(String GOODSNAME,String DETAIL,String PRICE,String PIC,String SELLERNAME,String TEL,int STATE){
		this.GOODSNAME = GOODSNAME;
		this.DETAIL = DETAIL;
		this.PRICE = PRICE;
		this.PIC = PIC;
		this.SELLERNAME = SELLERNAME;
		this.TEL = TEL;
		this.STATE = STATE; 
	}
	public Goods(int State){
		this.STATE = State;
	}
	public String getGOODSNAME() {
		return GOODSNAME;
	}
	public void setGOODSNAME(String gOODSNAME) {
		GOODSNAME = gOODSNAME;
	}
	public String getDETAIL() {
		return DETAIL;
	}
	public void setDETAIL(String dETAIL) {
		DETAIL = dETAIL;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	public String getPIC() {
		return PIC;
	}
	public void setPIC(String pIC) {
		PIC = pIC;
	}
	public String getSELLERNAME() {
		return SELLERNAME;
	}
	public void setSELLERNAME(String sELLERNAME) {
		SELLERNAME = sELLERNAME;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public int getSTATE() {
		return STATE;
	}
	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}
	
	

}
