package com.dsaa.set;

import java.util.ArrayList;

public class Set {
	
	private ArrayList<String> listOfStrings;
	
	public Set() {
		listOfStrings = new ArrayList<String>();
	}
	
	public Set(ArrayList<String> initialSet) {
		listOfStrings = new ArrayList<String>(initialSet);
	}
	
	public Set union(ArrayList<String> comparisonSet){
		Set combinedSet = new Set(listOfStrings);
		
		for(int i = 0; i < comparisonSet.size(); i++) {
			combinedSet.add(comparisonSet.get(i));
		}
		
		return combinedSet;
	}
	
	public Set intersection(ArrayList<String> comparisonSet){
		Set combinedSet = new Set();
		
		for (int i = 0; i < listOfStrings.size();i++) {
		    if(comparisonSet.contains(listOfStrings.get(i))) {
		    	combinedSet.add(listOfStrings.get(i));
		    }
		}
		
		return combinedSet;
	}
	
	public Set setDifference(ArrayList<String> comparisonSet){
		Set firstDifferencesSet = new Set();
		
		for (int i = 0; i < listOfStrings.size();i++) {
		    if(!comparisonSet.contains(listOfStrings.get(i))) {
		    	firstDifferencesSet.add(listOfStrings.get(i));
		    }
		}
		
		return firstDifferencesSet;
	}
	
	public Set symmetricDifference(ArrayList<String> comparisonSet){
		Set allDifferencesSet = new Set();
		
		for (int i = 0; i < listOfStrings.size();i++) {
		    if(!comparisonSet.contains(listOfStrings.get(i))) {
		    	allDifferencesSet.add(listOfStrings.get(i));
		    }
		}
		
		for (int i = 0; i < comparisonSet.size();i++) {
		    if(!listOfStrings.contains(comparisonSet.get(i))) {
		    	allDifferencesSet.add(comparisonSet.get(i));
		    }
		}
		
		return allDifferencesSet;
	}
	
	public boolean add(String newString) {
		if(listOfStrings.contains(newString)) {
			return false;
		}
		else {
			listOfStrings.add(newString);
			
			return true;
		}
	}

	public boolean remove(String newString) {
		if(listOfStrings.contains(newString)) {
			listOfStrings.remove(newString);
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public void printContents() {
		for(int i = 0; i < listOfStrings.size(); i++) {
			System.out.println(listOfStrings.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> set1 = new ArrayList<String>();
		set1.add("One");
		set1.add("Two");
		set1.add("Three");
		set1.add("Four");
		set1.add("Five");
		set1.add("Six");
		
		ArrayList<String> set2 = new ArrayList<String>();
		set2.add("Four");
		set2.add("Five");
		set2.add("Six");
		set2.add("Seven");
		set2.add("Eight");
		set2.add("Nine");
		
		Set set = new Set(set1);
		System.out.println("Union of sets: ");
		set.union(set2).printContents();
		System.out.println("\nIntersection of sets: ");
		set.intersection(set2).printContents();
		System.out.println("\nSymmetric difference of sets: ");
		set.symmetricDifference(set2).printContents();
		System.out.println("\nDifference of sets: ");
		set.setDifference(set2).printContents();		
	}
	
}
