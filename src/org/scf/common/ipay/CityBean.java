package org.scf.common.ipay.bean;
import org.webutils.common.util.PageBean;
/**
**/
public class CityBean extends PageBean{
	/**
	**/
		private int ID;
		private int Name;
		private int CountryCode;
		private int District;
		private int Population;
	
	/**
	**/
	public CityBean(){
		super();
	}
	
	/** 
	* setter  and  getter
	**/
		public int getID(){
			return ID;
		}
		
		public void setID(int ID){
			this.ID=ID;
		}
		public int getName(){
			return Name;
		}
		
		public void setName(int Name){
			this.Name=Name;
		}
		public int getCountryCode(){
			return CountryCode;
		}
		
		public void setCountryCode(int CountryCode){
			this.CountryCode=CountryCode;
		}
		public int getDistrict(){
			return District;
		}
		
		public void setDistrict(int District){
			this.District=District;
		}
		public int getPopulation(){
			return Population;
		}
		
		public void setPopulation(int Population){
			this.Population=Population;
		}
}