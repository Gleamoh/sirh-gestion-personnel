/**
 * 
 */
package dev.sgp.util;

import java.util.Map;

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
	
	public static String checkParameters(Map<String, String> params) {
		String defaultMessage = "Les paramètres suivants sont incorrects: ";
		String message = ""; 
		message += defaultMessage;

		for (Map.Entry<String, String> p : params.entrySet()) {
			if (RequestChecker.isNullOrEmptyParameter(p.getValue()) && !p.getKey().equals("active")) {
				message += p.getKey() + ", ";
			}
		}
		return message.equals(defaultMessage) ? null : message;
	}
}
