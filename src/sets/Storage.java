package sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Storage implements Keeping{

	Map<Set<Integer>, Integer> sets = new HashMap<>();
	int duplicates = 0;
	int nonDuplicates = 0;
	Set<Integer> nonDuplicatesRef = new HashSet<>();
	Set<Integer> DuplicatesRef = new HashSet<>();
	
	public int get(Set<Integer> set){
		return sets.get(set);
	}
	
	public Set<Set<Integer>> keySet(){
		return sets.keySet();
	}
	
	public Set<Entry<Set<Integer>, Integer>> entrySet(){
		return sets.entrySet();
	}
	
	//public static void main(String[] args) {}
	
	public Storage() {}

	@Override
	public boolean insertSet(String string) {		
		
		Set<Integer> iset = new HashSet<>();
		
		for (String str : string.split(",")) {
			try {
				iset.add(Integer.parseInt(str));
			} catch (NumberFormatException nfe) {
				System.out.println("Wrong format of input string!");
			}
		}		
		boolean alreadyExists = sets.keySet().contains(iset);		
		int appearance = 0;
		if (alreadyExists) {
			appearance = sets.get(iset);
			duplicates++;
			}	
		else {
			nonDuplicates++;
			}
		sets.put(iset, appearance+1);
		return alreadyExists;
	}

	public int numberDuplicates(){
		return duplicates; 
	}
	
	public int numberNonDuplicates(){
		return nonDuplicates;
	}
	
	public int totals(){
		return nonDuplicates + duplicates;
	}
	
	
	public Set<Set<Integer>> getNonDuplicates(){
		Set<Set<Integer>> ret = new HashSet<>();
		for (Entry<Set<Integer>, Integer> set : sets.entrySet()) {
			Set<Integer> key = set.getKey();
			if (set.getValue() == 1)
				ret.add(key);
			}
		return ret;
	}
	
	public Set<Set<Integer>> getDuplicates(){
		Set<Set<Integer>> ret = new HashSet<>();
		for (Entry<Set<Integer>, Integer> set : sets.entrySet()) {
			Set<Integer> key = set.getKey();
			if (set.getValue() > 1)
				ret.add(key);
			}
		return ret;
	}
	
	
	public String dumpSets(){
		StringBuffer dump = new StringBuffer();
		for (Entry<Set<Integer>, Integer> set : sets.entrySet()) {
			dump.append(set.getKey());
			dump.append(" : ");
			dump.append(set.getValue());
			dump.append("\n");
		}
		return dump.toString();
	}

	public String prettyDump(){
		StringBuffer dump = new StringBuffer();
		for (Entry<Set<Integer>, Integer> set : sets.entrySet()) {
			dump.append(set.getKey());
			dump.append(" : ");
			dump.append(set.getValue());
			dump.append("\n");
		}
		return dump.toString();
	}
	
}
