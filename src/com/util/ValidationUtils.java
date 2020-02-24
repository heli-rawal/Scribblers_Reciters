package com.util;

public class ValidationUtils {

	public static boolean isEmpty(String param){
		boolean isEmpty = false;

		if(param == "" && param.trim().length()<=0){
			isEmpty = true;
			
		}
		return isEmpty;
	}
	
	public static int email(String param){
		int result=0;
		 int atPosition = param.indexOf("@");
		 int dotPosition = param.lastIndexOf(".");
		  if (atPosition<1 || dotPosition<atPosition+2 || dotPosition+2>=param.length()) {
			  result=1;
		  }
		  if(param == "" && param.trim().length()<=0){
				result = 2;
				
			}
		/*  var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
*/
		return result;
	}
	
	public static boolean isEmpty(int param){
		boolean isEmpty = false;

		if(param ==0){
			isEmpty = true;
			
		}
		return isEmpty;
	}
	
}
