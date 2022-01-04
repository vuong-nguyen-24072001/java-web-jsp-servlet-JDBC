package com.laptrinhjavaweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {

	private Long id;
	private Timestamp createdDated;
	private Timestamp modifiedDated;
	private String createdBy;
	private String modifiedBy;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();
	private int offsetPaging;
	private int limitPaging;
	private int totalPage;
	
	public int getOffsetPaging() {
		return offsetPaging;
	}
	public void setOffsetPaging(int offsetPaging) {
		this.offsetPaging = offsetPaging;
	}
	public int getLimitPaging() {
		return limitPaging;
	}
	public void setLimitPaging(int limitPaging) {
		this.limitPaging = limitPaging;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreatedDated() {
		return createdDated;
	}
	public void setCreatedDated(Timestamp createdDated) {
		this.createdDated = createdDated;
	}
	public Timestamp getModifiedDated() {
		return modifiedDated;
	}
	public void setModifiedDated(Timestamp modifiedDated) {
		this.modifiedDated = modifiedDated;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
}
