package kr.co.to;

import java.util.List;

import kr.co.dto.Board6DTO;

public class PageTO {
	private int curPage = 1; //현재 페이지
	private int perPage = 10; //한페이지에 게시물 최대갯수
	private int pageLine = 5; //한 페이지세트에 보여줄 수 있는 페이지번호 갯수
	private int amount; //게시물의 총 갯수
	private int totalPage; //전체 페이지 갯수,종속변수
	private int startNum; //현재페이지의 게시물 첫 행번호,종속변수
	private int endNum; //현재페이지의 게시물 마지막 행번호,종속변수
	private int beginPageNum; // 현재페이지의 페이지세트에 있는 첫페이지번호,종속변수
	private int stopPageNum;//현재페이지의 페이지세트에 있는 마지막번호,종속변수
	
	private List<Board6DTO> list;
	
	public PageTO() {
		changeVarVal();
	}

	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		changeVarVal();
	}

	
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		changeVarVal();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		changeVarVal();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getStopPageNum() {
		return stopPageNum;
	}

	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}

	public List<Board6DTO> getList() {
		return list;
	}

	public void setList(List<Board6DTO> list) {
		this.list = list;
	}
	
	private void changeVarVal() {
		/*
		totalPage = amount/perPage;
		if(amount%perPage != 0) {
		totalPage = totalPage+1;
		}
		*/
		totalPage = (amount-1)/perPage + 1;
		
		startNum = (curPage - 1) * perPage + 1;
		endNum = curPage * perPage;
		if(endNum>amount) {
			endNum = amount;
			//총 게시글의 수가 27이면 endNum = 27
		}
		
		beginPageNum = ((curPage-1)/pageLine)*pageLine + 1;
		stopPageNum  = beginPageNum + (pageLine-1);
		if(stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
		
	}
	
	
}
