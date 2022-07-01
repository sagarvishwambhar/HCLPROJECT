package com.hclcv.generated;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] cars = {"id", "synopsistext", "sapid", "employeeid", "status"};
	    System.out.println(cars[0]);

		/*
		 * String name = "java2blog"; System.out.println("Original String: " + name); //
		 * get First letter of the string String firstLetStr = name.substring(0, 1); //
		 * Get remaining letter using substring String remLetStr = name.substring(1);
		 * 
		 * // convert the first letter of String to uppercase firstLetStr =
		 * firstLetStr.toUpperCase();
		 * 
		 * // concantenate the first letter and remaining string String
		 * firstLetterCapitalizedName = firstLetStr + remLetStr;
		 * System.out.println("String with first letter as Capital: " +
		 * firstLetterCapitalizedName);
		 */
	int i;
//	System.out.println("Residencephoto2"
	        for(i=0;i<cars.length;i++)
	        {
	        	String name = cars[i];
		 //       System.out.println("Original String: " + name);
		        // get First letter of the string
		        String firstLetStr = name.substring(0, 1);
		        // Get remaining letter using substring
		        String remLetStr = name.substring(1);
		        // convert the first letter of String to uppercase
		        firstLetStr = firstLetStr.toUpperCase();
		        // concantenate the first letter and remaining string
		        String firstLetterCapitalizedName = firstLetStr + remLetStr;
		        //System.out.println("String with first letter as Capital: " + firstLetterCapitalizedName);
		        System.out.println("mainprofessionalsynopsis.set"+firstLetterCapitalizedName+"(professionalsynopsis.get"+firstLetterCapitalizedName+"());");
	        	
	        	//System.out.println(i);
	       // licResidenceverification.setClientid(licResidenceverification2.getClientid());
	        }
		
		
		
	}

}
