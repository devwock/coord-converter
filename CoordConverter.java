
public class CoordConverter {
	public static final int SUCCESS = 000;
	public static final int ERROR_NULL = -901;
	public static final int ERROR_EMPTY = -902;
	public static final int ERROR_NOT_DOUBLE = -903;

	public double toDMS(String degrees) {
		int isValid = isValidValue(degrees);
		if (isValid != SUCCESS) {
			return isValid;
		}
		
		String[] splitted = degrees.split("\\.");
		double hour = Double.parseDouble(splitted[0] + "0000");
		if (splitted.length == 1) {
			return hour;
		}
		
		double rest = Double.parseDouble("0." + splitted[1]);
		String[] minRest = String.valueOf(rest * 60).split("\\.");
		double min = Double.parseDouble(minRest[0] + "00");
		if (minRest.length == 1) {
			return hour + min;
		}
		
		rest = Double.parseDouble("0." + minRest[1]);
		String[] secRest = String.valueOf(rest * 60).split("\\.");
		double sec = Double.parseDouble(secRest[0]);
		
		if (secRest.length == 1) {
			return hour + min + sec;
		}
		
		String secSecStr = null;
		if (secRest[1].length() == 1) {
			secSecStr = secRest[1];
		} else {
			secSecStr = secRest[1].substring(0, 2);
		}
		double secSec = Double.parseDouble("0." + secSecStr);
		return hour + min + sec + secSec;
	}
	
	public double toDecimalDegrees(String dms) {
		int isValid = isValidValue(dms);
		if (isValid != SUCCESS) {
			return isValid;
		}
		
		double hour = Double.parseDouble(dms.substring(0, 2));

		double min = Double.parseDouble(dms.substring(2, 4));
		min /= 60;
		
		double sec = Double.parseDouble(dms.substring(4, dms.length()));
		sec /= 60 * 60;
		
		double total = hour + min + sec;
		return total;
	}
	
	private int isValidValue(String value) {
		if (value == null) {
			return ERROR_NULL;
		}
		
		if (value.length() == 0) {
			return ERROR_EMPTY;
		}
		
		if (!isDouble(value)) {
			return ERROR_NOT_DOUBLE;
		}
		
		return SUCCESS;
	}
	
	private boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
