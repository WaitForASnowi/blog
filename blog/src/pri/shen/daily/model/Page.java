package pri.shen.daily.model;

/**
 * @author ZhiqiangShen
 *	��ҳ��
 * @param <T>
 */
public class Page<T>{
	/**
	 * ��ǰ�ڼ�ҳ
	 */
	private int currentPage;
	/**
	 * һҳ��������¼
	 */
	private int pageSize;
	/**
	 * ��¼������
	 */
	private int totalNum;
	/**
	 * ��ҳ��
	 */
	private int pageNum;
	
	/**
	 * ��¼�б�
	 */
	private T list;

	
	public Page() {
		super();
	}


	public Page(int currentPage, int pageSize, int totalNum, T list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.pageNum=this.totalNum%this.pageSize==0?this.totalNum/this.pageSize:this.totalNum/this.pageSize+1;
		if(this.pageNum==0) {
			this.pageNum=1;
		}
		if(this.currentPage<=0) {
			this.currentPage=1;
		}else if(this.currentPage>this.pageNum) {
			this.currentPage=this.pageNum;
		}
		
		this.list = list;
	}

	
	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public T getList() {
		return list;
	}


	public void setList(T list) {
		this.list = list;
	}


	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalNum=" + totalNum + ", pageNum="
				+ pageNum + ", list=" + list + "]";
	}
	
	
	
	
	
	
	
	
}
