/**
 * 
 */
package dev.sgp.util;

/**
 * @author Kevin M.
 *
 */
public class RequestChecker {

	public static Boolean isNullParameter(String param) {
		return null == param;
	}

	public static Boolean isEmptyParameter(String param) {
		return param.equals("");
	}
	
	public static Boolean isNullOrEmptyParameter(String param) {
		return isNullParameter(param) || isEmptyParameter(param);
	}
	
	public static Boolean isNullOrEmptyParameterId(String param) {
		return isNullParameter(param) || isEmptyParameter(param) || param.equals("0");
	}
	
	public static int parameterToInt(String param) {
		return Integer.parseInt(param);
	}
}
