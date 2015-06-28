package dmf444.ExtraFood.Common.items.nbt;

import java.util.ArrayList;

public class PowerSetGen {
	
	public static ArrayList<String> binaryTo(int num, ArrayList<String> list){
		char[] binar = new char[list.size()];
		int offset = list.size() - Integer.toBinaryString(num).toCharArray().length;
		for (int i = 0; i < binar.length; i++){
			if (i < offset){
				binar[i] = '0';
			}
			else {
				binar[i] = Integer.toBinaryString(num).toCharArray()[i-offset];
			}
		}
		boolean[] okish = new boolean[binar.length];
		ArrayList<String> ts = new ArrayList<String>();
		for (int i = 0; i < binar.length; i++){
			if (binar[i] == '1'){
				okish[i] = true;
				
				
			}
			else {
				okish[i] = false;
			}
		}
		int ni = 0;
		for (boolean ok : okish){
			if (ok == true){
				ts.add(list.get(ni));
			}
			ni++;
		}
		//EFLog.fatal(ts);
		return ts;
		
	}
	public static ArrayList<ArrayList<String>> combinationsOf(ArrayList<String> tg){
		ArrayList<ArrayList<String>> rv = new ArrayList<ArrayList<String>>();
		//EFLog.info(tg);
		//EFLog.info((tg.size()^2));
		for (int i = 0; i < Math.pow(tg.size(), 2); i++){
			//EFLog.fatal(i);
			rv.add(binaryTo(i, tg));
		}
		
		return rv;
	}
}
