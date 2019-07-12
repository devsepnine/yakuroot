package q_board.beans;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import q_board.beans.q_boardDao;
import q_board.beans.q_boardDto;

/**
 * 
 * 이 클래스는 페이징 처리를 수행하는 클래스입니다
 * 요청정보[검색분류 검색어 페이지번호 페이지 크기 블록 크기]를 전달받아
 * 다음 정보를 계산합니다
 * 1.시작/종료 블록번호
 * 2.시작/종료 게시글 순서
 * 3.페이지 이동시 필요한 파라미터 문자열
 * 4.게시글 갯수
 *
 */

public class paging {
	private String type;
	private String keyword;
	private String pstr;
	private int psize = 10;//페이지 표시글 개수
	private int bsize = 10;//페이지 표시번호 개수
	
	//생성자
	public paging(HttpServletRequest request) {
		this.type = request.getParameter("type");
		this.keyword = request.getParameter("keyword");
		this.pstr = request.getParameter("pno");		
	}
	
	private boolean search;
	private int pno;
	private int end;//마지막페이지
	private int start;//시작페이지
	private int count;//전체게시글
	private int pageCount;//전체페이지수
	private int startBlock;//시작블록
	private int endBlock; //종료블록
	private String query;
	private List<q_boardDto> list; //데이터가 저장된 목록
	public void calculate() throws Exception{
       	this.search = type!=null&&keyword!=null;

      	try{
      	pno = Integer.parseInt(pstr);
      		if(pno<=0) pno=1;
      	}catch(Exception e){
      		pno = 1;      		
      	}      	
      	this.end = pno*psize;
      	this.start = end - (psize-1);
      	q_boardDao qdao = new q_boardDao();      	
      	this.count = qdao.getCount(type,keyword);     	
      	this.pageCount = (count + psize-1)/psize;
      	
      	this.startBlock = ((pno-1)/bsize*bsize)+1;
      	this.endBlock = startBlock + (bsize-1);
      	if (endBlock>pageCount){
      		endBlock=pageCount;
      	}
      	//type,keyword 모두 null이 아니면 검색, 아니면 목록
      	if(search){
      		list = qdao.search(type,keyword,start,end); 				
      	}else{
      		list = qdao.list(start,end);
      	}
      	
      	//검색어 유지를 위해 검색일때와 아닐때의 첨부되는 파라미터 처리
      	//목록:검색어 처리 x
      	//검색:&type=??&keyword=?? 형태의 파라미터를 생성
      	if (search) {
      		String tmp = URLEncoder.encode(type,"UTF-8");
      		this.query = "&type="+tmp+"&keyword="+keyword;
      	}else{ this.query = "";}  		
	}

	@Override
	public String toString() {
		return "paging [type=" + type + ", keyword=" + keyword + ", pstr=" + pstr + ", psize=" + psize + ", bsize="
				+ bsize + ", search=" + search + ", pno=" + pno + ", end=" + end + ", start=" + start + ", count="
				+ count + ", pageCount=" + pageCount + ", startBlock=" + startBlock + ", endBlock=" + endBlock + "]";
	}

	//getter 메소드를 원하는 만큼 구현
	public List<q_boardDto> getList() {
		return list;
	}
	//첫 페이지 인지 확인 할 수 있는 getter
	public boolean isFirstBlock() { //첫 블록인지 확인
		return this.startBlock ==1;
	}
	public boolean isFirstPage() { //첫 페이지인지 확인
		return this.pno ==1;
	}
	public boolean isLastBlock() { // 마지막 블록인지 확인
		return this.endBlock ==this.pageCount;
	}
	public boolean isLastPage() { //마지막 페이지인지 확인
		return this.pno == this.pageCount;
	}
	public String getNextBlock() {//다음 블록으로
		return "pno="+(endBlock+1)+query;
	}
	public String getNextPage() {//다음 페이지로
		return "pno="+(pno+1)+query;
	}
	public String getPrevPage() {//이전 페이지로
		return "pno="+(pno-1)+query;
	}
	public String getPrevBlcok() {//이전 블록으로
		return "pno="+(startBlock-1)+query;
	}
	public boolean isCurrentPage(int i) {//현재 페이지인지
		return pno==i;
	}
	public String getPage(int i) {//i 페이지로 이동하기 위한 geter
		return "pno="+i+query;
	}

	public String getType() {
		return type;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getPstr() {
		return pstr;
	}

	public int getPsize() {
		return psize;
	}

	public int getBsize() {
		return bsize;
	}

	public boolean isSearch() {
		return search;
	}

	public int getPno() {
		return pno;
	}

	public int getEnd() {
		return end;
	}

	public int getStart() {
		return start;
	}

	public int getCount() {
		return count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public String getQuery() {
		return query;
	}
}
