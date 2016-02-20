package org.scf.common.ipay.bean;
import org.webutils.common.util.PageBean;
/**
**/
public class CountryBean extends PageBean{
	/**
	**/
		private int Code;
		private int Name;
		private int Continent;
		private int Region;
		private int SurfaceArea;
		private int IndepYear;
		private int Population;
		private int LifeExpectancy;
		private int GNP;
		private int GNPOld;
		private int LocalName;
		private int GovernmentForm;
		private int HeadOfState;
		private int Capital;
		private int Code2;
	
	/**
	**/
	public CountryBean(){
		super();
	}
	
	/** 
	* setter  and  getter
	**/
		public int getCode(){
			return Code;
		}
		
		public void setCode(int Code){
			this.Code=Code;
		}
		public int getName(){
			return Name;
		}
		
		public void setName(int Name){
			this.Name=Name;
		}
		public int getContinent(){
			return Continent;
		}
		
		public void setContinent(int Continent){
			this.Continent=Continent;
		}
		public int getRegion(){
			return Region;
		}
		
		public void setRegion(int Region){
			this.Region=Region;
		}
		public int getSurfaceArea(){
			return SurfaceArea;
		}
		
		public void setSurfaceArea(int SurfaceArea){
			this.SurfaceArea=SurfaceArea;
		}
		public int getIndepYear(){
			return IndepYear;
		}
		
		public void setIndepYear(int IndepYear){
			this.IndepYear=IndepYear;
		}
		public int getPopulation(){
			return Population;
		}
		
		public void setPopulation(int Population){
			this.Population=Population;
		}
		public int getLifeExpectancy(){
			return LifeExpectancy;
		}
		
		public void setLifeExpectancy(int LifeExpectancy){
			this.LifeExpectancy=LifeExpectancy;
		}
		public int getGNP(){
			return GNP;
		}
		
		public void setGNP(int GNP){
			this.GNP=GNP;
		}
		public int getGNPOld(){
			return GNPOld;
		}
		
		public void setGNPOld(int GNPOld){
			this.GNPOld=GNPOld;
		}
		public int getLocalName(){
			return LocalName;
		}
		
		public void setLocalName(int LocalName){
			this.LocalName=LocalName;
		}
		public int getGovernmentForm(){
			return GovernmentForm;
		}
		
		public void setGovernmentForm(int GovernmentForm){
			this.GovernmentForm=GovernmentForm;
		}
		public int getHeadOfState(){
			return HeadOfState;
		}
		
		public void setHeadOfState(int HeadOfState){
			this.HeadOfState=HeadOfState;
		}
		public int getCapital(){
			return Capital;
		}
		
		public void setCapital(int Capital){
			this.Capital=Capital;
		}
		public int getCode2(){
			return Code2;
		}
		
		public void setCode2(int Code2){
			this.Code2=Code2;
		}
}