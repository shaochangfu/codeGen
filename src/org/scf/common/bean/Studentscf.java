package org.scf.common.bean;
/**
**/
public class Studentscf {
	/**
	**/
		private String id;
		private String birth;
		private String name;
	
	/**
	**/
	public Studentscf(){
		super();
	}
	
	/** 
	* setter  and  getter
	**/
		public String getId(){
			return id;
		}
		
		public void setId(String id){
			this.id=id;
		}
		public String getBirth(){
			return birth;
		}
		
		public void setBirth(String birth){
			this.birth=birth;
		}
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name=name;
		}
}