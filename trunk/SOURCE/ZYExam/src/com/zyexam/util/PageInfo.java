package com.zyexam.util;

public class PageInfo {
    private int recordCount;
    private int pageSize;
    private int pageCount;
    private int partPageCount;
    private int currentPage;
    private int startRecord;
    private int endRecrod;
    private int startPage;
    private int endPage;
	public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getEndRecrod()
    {
        return endRecrod;
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public int getPartPageCount()
    {
        return partPageCount;
    }

    public void setPartPageCount(int partPageCount)
    {
        this.partPageCount = partPageCount;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getRecordCount()
    {
        return recordCount;
    }

    public void setRecordCount(int recordCount)
    {
        this.recordCount = recordCount;
    }

    public int getStartRecord()
    {
        return startRecord;
    }

    public PageInfo()
    {
        pageSize = 10;
        partPageCount = 5;
    }
    
    public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void compute()
    {
        if(recordCount == 0 || pageSize == 0)
        {
            pageCount = 0;
            startRecord = 0;
            endRecrod = 0;
            currentPage = 0;
        } else
        {
            pageCount = ((recordCount + pageSize) - 1) / pageSize;
            if(currentPage <= 0)
                currentPage = 1;
            if(currentPage > pageCount)
                currentPage = pageCount;
            startRecord = (currentPage - 1) * pageSize + 1;
            int endRecrodTemp = (startRecord + pageSize) - 1;
            if(endRecrodTemp <= recordCount)
                endRecrod = endRecrodTemp;
            else
                endRecrod = recordCount;
            //确保partPageCount是奇数
            if((partPageCount/2) == 0)
            	partPageCount++;
            //计算开始和结束的页数
            startPage = currentPage - (partPageCount/2);
            endPage = currentPage + (partPageCount/2);
            //确保开始与结束页数的正确性
            if(startPage < 1){
            	startPage = 1;
            	endPage = startPage + partPageCount - 1;
            }
            if(endPage > pageCount){
            	endPage = pageCount;
            	startPage = endPage - partPageCount + 1;
            }
            if(startPage < 1)
            	startPage = 1;
        }
    }
}
