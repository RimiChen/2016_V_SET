/*
 * This contains some commonly used functions
 */
package Variables;

public class G_Fun {
	
	public String removeBlank(String input){
		String result = "";
		result = input.replaceAll("\\s+", "");
		return result;
	}
}
