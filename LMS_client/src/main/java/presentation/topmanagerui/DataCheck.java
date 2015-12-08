package presentation.topmanagerui;

public class DataCheck {
	
	public static boolean isDouble(String number){
		boolean result = false;
		if (!number.equals("")) {
			if (number.contains(".")) {
				String[] temp = number.split("\\.");
				if (temp.length == 2) {					
					if ( !temp[0].equals("") && !temp[1].equals("")) {
						result = true;
					}
				}
				
			}else {
				result = true;
			}
			
			
		}
		
		return result;
		
	}
	
	public static boolean isBusinessCOde(String businessCode){
		boolean result = false;
		if (businessCode.contains("-")) {
			String[] temp = businessCode.split("-");
			if (temp.length == 2) {
				if (!temp[0].equals("") && !temp[1].equals("")) {
					result = true;
				}
			}
		}
		return result;
	}

}
