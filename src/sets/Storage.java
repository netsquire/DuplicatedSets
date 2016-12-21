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
	int maxDuplicates = 0;
			
	public int get(Set<Integer> set){
		return sets.get(set);
	}
	
	public Set<Set<Integer>> keySet(){
		return sets.keySet();
	}
	
	public Set<Entry<Set<Integer>, Integer>> entrySet(){
		return sets.entrySet();
	}	
	
	public Storage() {}

	@Override
	public boolean insertSet(String string) {				
		Set<Integer> iset = new HashSet<>();
		
		for (String str : string.split(",")) {
			try {
				iset.add(Integer.parseInt(str));
			} catch (NumberFormatException nfe) {
				System.out.println("Wrong format of input token in [" + str + "]");
			}
		}		
		boolean alreadyExists = sets.keySet().contains(iset);		
		int appearance = 0;
		if (alreadyExists) {
			appearance = sets.get(iset);
			if (appearance == 1) {
				duplicates ++;
				nonDuplicates --;
				}
			duplicates ++;
			}	
		else{
			nonDuplicates ++;
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
	
	public Set<Integer> getMostDuplicates(){
		Set<Integer> ret = new HashSet<>();
		int max = 0;
		for (Entry<Set<Integer>, Integer> set : sets.entrySet()) {
			Set<Integer> key = set.getKey();
			int value = set.getValue();
			if (value > max){
				max = value;
				ret = key;
				}
			}
		maxDuplicates = max;
		return ret;
	}
	
	public int getMaxDuplicates(){
		return maxDuplicates;
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

	
	
}
