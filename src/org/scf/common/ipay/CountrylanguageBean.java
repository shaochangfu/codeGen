package org.scf.common.ipay.bean;
import org.webutils.common.util.PageBean;
/**
**/
public class CountrylanguageBean extends PageBean{
	/**
	**/
		private int CountryCode;
		private int Language;
		private int IsOfficial;
		private int Percentage;
	
	/**
	**/
	public CountrylanguageBean(){
		super();
	}
	
	/** 
	* setter  and  getter
	**/
		public int getCountryCode(){
			return CountryCode;
		}
		
		public void setCountryCode(int CountryCode){
			this.CountryCode=CountryCode;
		}
		public int getLanguage(){
			return Language;
		}
		
		public void setLanguage(int Language){
			this.Language=Language;
		}
		public int getIsOfficial(){
			return IsOfficial;
		}
		
		public void setIsOfficial(int IsOfficial){
			this.IsOfficial=IsOfficial;
		}
		public int getPercentage(){
			return Percentage;
		}
		
		public void setPercentage(int Percentage){
			this.Percentage=Percentage;
		}
}