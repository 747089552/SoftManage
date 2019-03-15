package com.bhdx.wy.domain.json;


public class PageJSON extends BaseJSON{
	protected int code=0;
	protected String message = "成功";
	protected int pageNum;
	protected int pageSize;
	protected long total;
	protected int pages;
	
	public PageJSON(){
	}
	
	public PageJSON(int code,String message){
		this.code=code;
		this.message=message;
	}
	
	public PageJSON(int code,String message,int pageNum,int pageSize,long total,int pages){
		this.code=code;
		this.message=message;
		this.pageNum=pageNum;
		this.pageSize=pageSize;
		this.pages=pages;
		this.total=total;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
}
