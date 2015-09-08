package org.scf.common.bean;
/**
**/
public class Categories {
	/**
	**/
		private int id;
		private String category;
		private String desc;
		private String ext1;
		private String ext2;
		private String ext3;
	
	/**
	**/
	public Categories(){
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
		public String getCategory(){
			return category;
		}
		
		public void setCategory(String category){
			this.category=category;
		}
		public String getDesc(){
			return desc;
		}
		
		public void setDesc(String desc){
			this.desc=desc;
		}
		public String getExt1(){
			return ext1;
		}
		
		public void setExt1(String ext1){
			this.ext1=ext1;
		}
		public String getExt2(){
			return ext2;
		}
		
		public void setExt2(String ext2){
			this.ext2=ext2;
		}
		public String getExt3(){
			return ext3;
		}
		
		public void setExt3(String ext3){
			this.ext3=ext3;
		}
}