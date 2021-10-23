package utility;

import bussinessLogic.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	public static List<String> retrieveItemIDs(List<Item> reviewedList) {
		List<String> list = new ArrayList<>();
		for (Item item : reviewedList) {
			list.add(item.getItemID());
		}
		return list;

	}

	public static String formatDouble(double value) {
		String stringValue = String.valueOf(value);
		// If in case the string does not have sufficent values after decimal points
		stringValue += "00";
		int index = stringValue.lastIndexOf(".") + 3;
		return stringValue.substring(0, index);
	}
}
