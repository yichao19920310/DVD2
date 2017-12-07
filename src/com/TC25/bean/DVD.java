package com.TC25.bean;


import java.io.Serializable;
import java.util.Date;

public class DVD implements Serializable {

	
	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 8308926435504792397L;
	
	
	private int dvdId;
	private String dvdName;
	private int dvdLendCount;
	private Date dvdDate;
	//状态,1在库,2借出,3已删除
	private int dvdStatus;
	
	public int getDvdId() {
		return dvdId;
	}
	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}
	public int getDvdLendCount() {
		return dvdLendCount;
	}
	public void setDvdLendCount(int dvdLendCount) {
		this.dvdLendCount = dvdLendCount;
	}
	public Date getDvdDate() {
		return dvdDate;
	}
	public void setDvdDate(Date dvdDate) {
		this.dvdDate = dvdDate;
	}
	public int isDvdStatus() {
		return dvdStatus;
	}
	public void setDvdStatus(int dvdStatus) {
		this.dvdStatus = dvdStatus;
	}
	public DVD() {
		
	}
	public DVD(int dvdId, String dvdName, int dvdLendCount, Date dvdDate, int dvdStatus) {
		super();
		this.dvdId = dvdId;
		this.dvdName = dvdName;
		this.dvdLendCount = dvdLendCount;
		this.dvdDate = dvdDate;
		this.dvdStatus = dvdStatus;
	}
	
	public DVD(String dvdName, int dvdLendCount, Date dvdDate, int dvdStatus) {
		super();
		this.dvdName = dvdName;
		this.dvdLendCount = dvdLendCount;
		this.dvdDate = dvdDate;
		this.dvdStatus = dvdStatus;
	}
	@Override
	public String toString() {
		return "DVD [dvdId=" + dvdId + ", dvdName=" + dvdName + ", dvdLendCount=" + dvdLendCount + ", dvdDate="
				+ dvdDate + ", dvdStatus=" + dvdStatus + "]";
	}

	

	
	
	
	
	
	
	
	
}
