package f_board.beans;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import f_board.beans.f_boardDao;
import f_board.beans.f_boardDto;

/**
 * 
 * �� Ŭ������ ����¡ ó���� �����ϴ� Ŭ�����Դϴ�
 * ��û����[�˻��з� �˻��� ��������ȣ ������ ũ�� ��� ũ��]�� ���޹޾�
 * ���� ������ ����մϴ�
 * 1.����/���� ��Ϲ�ȣ
 * 2.����/���� �Խñ� ����
 * 3.������ �̵��� �ʿ��� �Ķ���� ���ڿ�
 * 4.�Խñ� ����
 *
 */

public class paging {
	private String type;
	private String keyword;
	private String pstr;
	private int psize = 10;//������ ǥ�ñ� ����
	private int bsize = 10;//������ ǥ�ù�ȣ ����
	
	//������
	public paging(HttpServletRequest request) {
		this.type = request.getParameter("type");
		this.keyword = request.getParameter("keyword");
		this.pstr = request.getParameter("pno");		
	}
	
	private boolean search;
	private int pno;
	private int end;//������������
	private int start;//����������
	private int count;//��ü�Խñ�
	private int pageCount;//��ü��������
	private int startBlock;//���ۺ��
	private int endBlock; //������
	private String query;
	private List<f_boardDto> list; //�����Ͱ� ����� ���
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
      	f_boardDao bdao = new f_boardDao();      	
      	this.count = bdao.getCount(type,keyword);     	
      	this.pageCount = (count + psize-1)/psize;
      	
      	this.startBlock = ((pno-1)/bsize*bsize)+1;
      	this.endBlock = startBlock + (bsize-1);
      	if (endBlock>pageCount){
      		endBlock=pageCount;
      	}
      	//type,keyword ��� null�� �ƴϸ� �˻�, �ƴϸ� ���
      	if(search){
      		list = bdao.search(type,keyword,start,end); 				
      	}else{
      		list = bdao.list(start,end);
      	}
      	
      	//�˻��� ������ ���� �˻��϶��� �ƴҶ��� ÷�εǴ� �Ķ���� ó��
      	//���:�˻��� ó�� x
      	//�˻�:&type=??&keyword=?? ������ �Ķ���͸� ����
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

	//getter �޼ҵ带 ���ϴ� ��ŭ ����
	public List<f_boardDto> getList() {
		return list;
	}
	//ù ������ ���� Ȯ�� �� �� �ִ� getter
	public boolean isFirstBlock() { //ù ������� Ȯ��
		return this.startBlock ==1;
	}
	public boolean isFirstPage() { //ù ���������� Ȯ��
		return this.pno ==1;
	}
	public boolean isLastBlock() { // ������ ������� Ȯ��
		return this.endBlock ==this.pageCount;
	}
	public boolean isLastPage() { //������ ���������� Ȯ��
		return this.pno == this.pageCount;
	}
	public String getNextBlock() {//���� �������
		return "pno="+(endBlock+1)+query;
	}
	public String getNextPage() {//���� ��������
		return "pno="+(pno+1)+query;
	}
	public String getPrevPage() {//���� ��������
		return "pno="+(pno-1)+query;
	}
	public String getPrevBlcok() {//���� �������
		return "pno="+(startBlock-1)+query;
	}
	public boolean isCurrentPage(int i) {//���� ����������
		return pno==i;
	}
	public String getPage(int i) {//i �������� �̵��ϱ� ���� geter
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
