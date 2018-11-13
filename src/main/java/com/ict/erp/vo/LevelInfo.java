package com.ict.erp.vo;

import org.apache.ibatis.type.Alias;

@Alias("li")
public class LevelInfo {
	private Integer linum;
	private String lilevel;
	private String liname;
	private String lidesc;
	private Integer getnum;
	
	public LevelInfo() {}
	
	public LevelInfo(Integer linum, String lilevel, String liname, String lidesc) {
		super();
		this.linum = linum;
		this.lilevel = lilevel;
		this.liname = liname;
		this.lidesc = lidesc;
	}
	@Override
	public String toString() {
		return "LevelInfo [linum=" + linum + ", lilevel=" + lilevel + ", liname=" + liname + ", lidesc=" + lidesc + "]";
	}
	public Integer getLinum() {
		return linum;
	}
	public void setLinum(Integer linum) {
		this.linum = linum;
	}
	public String getLilevel() {
		return lilevel;
	}
	public void setLilevel(String lilevel) {
		this.lilevel = lilevel;
	}
	public String getLiname() {
		return liname;
	}
	public void setLiname(String liname) {
		this.liname = liname;
	}
	public String getLidesc() {
		return lidesc;
	}
	public void setLidesc(String lidesc) {
		this.lidesc = lidesc;
	}
	public Integer getGetnum() {
		return getnum;
	}
	public void setGetnum(Integer getnum) {
		this.getnum = getnum;
	}
	
	
}
