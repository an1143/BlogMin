package com.mingyu.vo;

public class PageCriteria {

	
	
	private int page;
	

	private int strPage;     //시작 페이지 
	private int endPage;     //끝페이지
	private int numPerPage;  //페이지당 개수
	
	
	public PageCriteria() {
		// TODO Auto-generated constructor stub
		this.page =1;
		this.numPerPage =10;
		this.strPage =0;
		this.endPage =10;
	
	}
	
	
	



	public void setPage(int page) {
	
	
		
		//시작 페이지
		if(page==1) {
			
			this.strPage =page-1;
			
		}else {
			this.strPage =(page-1)*this.numPerPage+1;	
		}
			
	
	
		  
		
			this.endPage =page*this.numPerPage;
			this.page =page;
			
			
		
	}
	
	
	
	
	
	public void setNumPerPage(int numPerPage) {
		
	
		
		this.numPerPage = numPerPage;
		
		
		
	}
	
	
	public int getStrPage() {
		return strPage;
	}



	public int getEndPage() {
		return endPage;
	}


	public int getPage() {
		return page;
	}
	

	public int getNumPerPage() {
		return numPerPage;
	}

	
	
	
	
	
}
