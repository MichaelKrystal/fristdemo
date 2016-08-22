package com.ytx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoopSubString {

	private static Map<String, List<String>> subStringMethod(String str){
		Map<String, List<String>> subMap = new HashMap<String, List<String>>();
		List<String> bigList = new ArrayList<String>();
		List<String> subList = new ArrayList<String>();
		List<String> subsubList = new ArrayList<String>();
		String[] bigStr = str.split("\\|");
		for (int i = 0; i < bigStr.length; i++) {
			//System.out.println(bigStr[i]);
			bigList.add(bigStr[i]);
			String[] subStr = bigStr[i].split(",");
			for (int j = 0; j < subStr.length; j++) {
				if(3 == subStr.length){
					//System.out.println(subStr[j]);
					if (j%2 == 0) {
						subList.add(subStr[j]);
						if (j%4 == 0) {
							String[] subsubStr = subStr[j].split("-");
							for (int k = 0; k < subsubStr.length; k++) {
								//System.out.println(subsubStr[k]);
								subsubList.add(subsubStr[k]);
							}
						}
					}
				}else{
					subList.add(subStr[j]);
					if (j%2 == 0) {
						String[] subsubStr = subStr[j].split("-");
						for (int k = 0; k < subsubStr.length; k++) {
							//System.out.println(subsubStr[k]);
							subsubList.add(subsubStr[k]);
						}
					}
				}
			}
		}
		subMap.put("big", bigList);
		subMap.put("small", subList);
		subMap.put("mic", subsubList);
		return subMap;
	}
	public static void main(String[] args) {
		String str = "HKG-MXO,A3119,2016-06-15 18:20:36||HFG-MJO,A3169,2016-06-18 19:20:36||KFG-MJP,A3159,2016-06-25 08:20:36||RYG-MHF,A5169,2016-06-30 15:20:36";
		String str1 = "China-Beijing,2016-06-15 18:20:36||Japan-Tokyo,2016-06-18 19:20:36||France-Paris,2016-06-25 08:20:36";
		//System.out.println(subStringMethod(str));
		for (int i = 0; i < subStringMethod(str).get("big").size(); i++) {
			System.out.println(subStringMethod(str).get("big").get(i));
		}
		
		for (int j = 0; j < subStringMethod(str).get("small").size(); j++) {
			System.out.println(subStringMethod(str).get("small").get(j));
			if (j%2==0) {
				System.out.println(subStringMethod(str).get("small").get(j));
				if (j%4==0) {
					String[] subsubStr = subStringMethod(str).get("small").get(j).split("-");
					for (int k = 0; k < subsubStr.length; k++) {
						System.out.println(subsubStr[k]);
					}
				}
			}
		}
		
		for (int k = 0; k < subStringMethod(str).get("mic").size(); k++) {
			System.out.println(subStringMethod(str).get("mic").get(k));
		}
		
		System.out.println(subStringMethod(str).get("big"));
		System.out.println(subStringMethod(str).get("small"));
		System.out.println(subStringMethod(str).get("mic"));
		
		
		for (int i = 0; i < subStringMethod(str1).get("big").size(); i++) {
			System.out.println(subStringMethod(str1).get("big").get(i));
		}
		for (int j = 0; j < subStringMethod(str1).get("small").size(); j++) {
			System.out.println(subStringMethod(str1).get("small").get(j));
		}
		
		for (int k = 0; k < subStringMethod(str1).get("mic").size(); k++) {
			System.out.println(subStringMethod(str1).get("mic").get(k));
		}
	}
}
