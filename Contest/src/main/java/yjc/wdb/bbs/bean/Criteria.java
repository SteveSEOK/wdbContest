package yjc.wdb.bbs.bean;

public class Criteria {

   private int page = 1;
   private int recordsPerPage = 10;
   private String searchType;
   private String keyword;
   private int startPage;
   private int endPage;
   private boolean prev;
   private boolean next;
   private int totalCount;
   private int menuType;
   private String category;
   private String dateState;
   private String c_searchType;
   private String c_keyword;
   public final static int DISPLAY_PAGE_NUM = 10;
   
   
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDateState() {
		return dateState;
	}
	public void setDateState(String dateState) {
		this.dateState = dateState;
	}
	public String getC_searchType() {
		return c_searchType;
	}
	public void setC_searchType(String c_searchType) {
		this.c_searchType = c_searchType;
	}
	public String getC_keyword() {
		return c_keyword;
	}
	public void setC_keyword(String c_keyword) {
		this.c_keyword = c_keyword;
	}
	

	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}

    public String getSearchType() {
	return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
   
   
   public int getTotalCount() {
	return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calculate();
	}
	
	private void calculate() {
		/*
		 * startPage, endPage, prev, next 占쏙옙占� 占쏙옙占쏙옙.
		 */
		endPage = (int)Math.ceil(page/(double)DISPLAY_PAGE_NUM)*DISPLAY_PAGE_NUM;
		/*
		 * endPage占쏙옙占쏙옙 占쏙옙타占쏙옙 占쏙옙 占쌍댐옙 占쏙옙 占쏙옙占쏙옙
		 * 占쏙옙占싱븝옙 占쏙옙占� 占쌍댐옙 占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占싼댐옙.(totalCount)
		 * endPage占쏙옙占쏙옙 占쏙옙타占쏙옙 占쏙옙 占쌍댐옙 占쏙옙 占쏙옙占쏙옙 : endPage * recordsPerPage
		 * (endPage * recordsPerPage) > totalCount
		 * 占쏙옙占썅에 占쏙옙占쏙옙 占쏙옙占싱띰옙占�
		 * endPage = (totalCount/recordsPerPage)+1;
		 */
		startPage = endPage-DISPLAY_PAGE_NUM + 1;

		if((endPage*recordsPerPage)>totalCount)
			endPage = (int)(Math.ceil(totalCount/(double) recordsPerPage));
		
		prev = startPage > 1 ? true : false;
		next = endPage*recordsPerPage<totalCount ? true : false;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public int getPage() {
      return page;
   }
	
   public void setPage(int page) {
      if( page <= 0){
         this.page = 1;
      }else{
         this.page = page;
      }
      
   }
   public int getRecordsPerPage() {
      return recordsPerPage;
   }
   public void setRecordsPerPage(int recordsPerPage) {
      if(recordsPerPage < 0 || recordsPerPage >100){
         this.recordsPerPage = 10;
      }else{
         this.recordsPerPage = recordsPerPage;
      }
      
   }
   public int getStartRecord(){
      //page占쏙옙 1占싱몌옙 0*10占쏙옙占쏙옙
            //page占쏙옙 2占싱몌옙 1*10占쏙옙占쏙옙
            //page占쏙옙 3占싱몌옙 2*10占쏙옙占쏙옙
            return (page-1)*recordsPerPage;
   }
   public String toString(){
      return "Criteria [page=" +page +"," +"recordsPerPage=" + recordsPerPage + "]";
   }
   
}