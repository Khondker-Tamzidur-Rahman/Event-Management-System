package EventManagementSystem;

public class Qus_9_5 {
 public static void main(String[] args) {
	 GregorianCalendar year = new GregorianCalendar();
	 GregorianCalendar month = new GregorianCalendar();
	 GregorianCalendar day_of_month = new GregorianCalendar();
	
	year.setYEAR(2001);
	month.setMONTH(5);
	year.setDAY_OF_MONTH(25);
	
	 
	
	 System.out.println(year.toString());
	 System.out.println(month.toString());
	 System.out.println(day_of_month.toString());
 }

}