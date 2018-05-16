package com.king.common.util;


import java.io.Serializable;
import java.util.List;

/**
 * 
 * 通用针对bootstrap-table分页基类
 */
public class MutiSort implements Serializable {

	
	private static final long serialVersionUID = 1L;
	/* queryParamsType采用limit方式,分页单列排序参数 */
	private String sort;// 单列排序名称
	private String order;// 单列排序命令
	private int offset;// 偏移量
	private int limit;// 每页显示多少条
	/* queryParamsType采用''方式,分页单列排序参数 */
	private String sortName;// 单列排序名称
	private String sortOrder;// 单列排序命令
	private int pageSize;// 每页多少条
	private int pageNumber;// 当前第几页
	/* 多列排序字段 */
	private List<Data> multiSort;
	/*使用springCachable注解时,针对service执行insert,update,delete方法时,返回执行结果*/
	private int operateResult;
	

	public static class Data implements Serializable{
		
		private static final long serialVersionUID = 5614729421143459706L;
		private String sortName;
		private String sortOrder;

		public Data() {
		}

		public Data(String sortName, String sortOrder) {
			this.sortName = sortName;
			this.sortOrder = sortOrder;
		}

		public String getSortName() {
			return sortName;
		}

		public void setSortName(String sortName) {
			this.sortName = sortName;
		}

		public String getSortOrder() {
			return sortOrder;
		}

		public void setSortOrder(String sortOrder) {
			this.sortOrder = sortOrder;
		}

	}

	public MutiSort() {
		
	}
	

	public MutiSort(String sort, String order, int offset, int limit, String sortName, String sortOrder, int pageSize,
			int pageNumber, List<Data> multiSort, int operateResult) {
		super();
		this.sort = sort;
		this.order = order;
		this.offset = offset;
		this.limit = limit;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.multiSort = multiSort;
		this.operateResult = operateResult;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Data> getMultiSort() {
		return multiSort;
	}

	public void setMultiSort(List<Data> multiSort) {
		this.multiSort = multiSort;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getOperateResult() {
		return operateResult;
	}

	public void setOperateResult(int operateResult) {
		this.operateResult = operateResult;
	}

	
	
}
