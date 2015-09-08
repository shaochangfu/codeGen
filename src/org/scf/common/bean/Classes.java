package org.scf.common.bean;
/**
**/
public class Classes {
	/**
	**/
		private int id;
		private String name;
		private String yuanxiid;
		private String desc;
	
	/**
	**/
	public Classes(){
		super();
	}
	
	/** 
	* setter  and  getter
	**/
		public int getId(){
			return id;
		}
		
		public void setId(int id){
			this.id=id;
		}
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name=name;
		}
		public String getYuanxiid(){
			return yuanxiid;
		}
		
		public void setYuanxiid(String yuanxiid){
			this.yuanxiid=yuanxiid;
		}
		public String getDesc(){
			return desc;
		}
		
		public void setDesc(String desc){
			this.desc=desc;
		}
}