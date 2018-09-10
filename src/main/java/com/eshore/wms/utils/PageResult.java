package com.eshore.wms.utils;

import java.util.List;

/**
 * 用于包装list数据的类
 * @author eshore
 *
 */
public class PageResult {
	private List<?> data;

	private Integer totalCount;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageResult [data=" + data + ", totalCount=" + totalCount + "]";
	}
}
