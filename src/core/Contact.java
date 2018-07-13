package core;


	public class Contact {
		


		  public String staffName;
		  public String dateOfBirth;
		  public float hourlyRate;
		  public float sunday;
		  public float monday;
		  public float tuesday;
		  public float wednesday;
		  public float thrusday;
		  public float friday;
		  public float saturday;
		  public float totalHours;
		  public float weeklyRate;
		  

		  public Contact(String staffName,float hourlyRate,float sunday,float monday, float tuesday, float wednesday, float thrusday,float friday, float saturday, float totalHours,float weeklyRate) {
		    this.staffName = staffName;
		   // this.dateOfBirth = dateOfBirth;
		    this.hourlyRate = hourlyRate;
		    this.sunday = sunday;
		    this.monday = monday;
		    this.tuesday = tuesday;
		    this.wednesday = wednesday;
		    this.thrusday = thrusday;
		    this.friday = friday;
		    this.saturday = saturday;
		    this.totalHours=totalHours;
		    this.weeklyRate = weeklyRate;
		  }

}
