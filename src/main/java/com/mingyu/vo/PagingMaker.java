package com.mingyu.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingMaker {

	
	
	private int totalData;
	private int startPage;
	private int endPage;
	private boolean prev; // 이전버튼
	private boolean next; //다음버튼
	
	private int displayPageNum = 10;   // 1 2 3 4 5 6 7 8 9 10 목록 수 
	
	
	private PageCriteria Cri;

	



	public int getTotalData() {
		return totalData;
	}


	public void setTotalData(int totalData) {
		this.totalData = totalData;
		
		  getPagingData();
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}


	public PageCriteria getpCria() {
		return Cri;
	}


	public void setpCria(PageCriteria pCria) {
		System.out.println(pCria.getPage()+"겟페이지");
		this.Cri = pCria;
	} 
	
	
	public void getPagingData() {
		
	
		endPage = (int)(Math.ceil(Cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		
		

		
		int finalEndPage = (int)Math.ceil(totalData/(double)Cri.getNumPerPage());
		
		
		
		
		if(endPage>finalEndPage) {
			 endPage = finalEndPage;
		}
		
		
		
		prev = startPage ==1? false : true;
		next = endPage * Cri.getNumPerPage() >= totalData ? false : true ;
		
	}
	
	
	
	public String makeURI(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				                                                        .queryParam("numPerPage", Cri.getNumPerPage()).build();
			
		return uriComponents.toUriString();
		
	}
	
	
	
	public String makeFind(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				                                                        .queryParam("findType", ((FindCriteria) Cri).getFindType())
				                                                        .queryParam("numPerPage", Cri.getNumPerPage())
				                                                        .queryParam("keyword", ((FindCriteria) Cri).getKeyword())
				                                                        .build();
			
		return uriComponents.toUriString();
		
	}
	
	
	public PageCriteria getCri() {
		return Cri;
	}

		
}
