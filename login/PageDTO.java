package kr.co.hs.member.dto;

public class PageDTO {
	//���� ������
		int currentPage;
	//�������� ���� ��
		int linePerPage=10;
	//��ü ���ڵ� ��
		int allCount;
	//��ü ������ �� 
		int allPage;
	//������ ��(�ϳ��� ȭ�鿡 ������ ������ ��)
		int pageBlock=5;
	//���� ������ ��
		int currPageBlock;
	//���� ������
		int startPage;
		int endPage;
		
	public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getLinePerPage() {
			return linePerPage;
		}
		public void setLinePerPage(int linePerPage) {
			this.linePerPage = linePerPage;
		}
		public int getAllCount() {
			return allCount;
		}
		public void setAllCount(int allCount) {
			this.allCount = allCount;
		}
		public int getAllPage() {
			return allPage;
		}
		public void setAllPage(int allPage) {
			this.allPage = allPage;
		}
		public int getPageBlock() {
			return pageBlock;
		}
		public void setPageBlock(int pageBlock) {
			this.pageBlock = pageBlock;
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
		public int getCurrPageBlock() {
			return currPageBlock;
		}
		public void setCurrPageBlock(int currPageBlock) {
			this.currPageBlock = currPageBlock;
		}
		
		
		

}
