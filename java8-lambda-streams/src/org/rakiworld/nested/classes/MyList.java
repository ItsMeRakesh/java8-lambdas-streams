package org.rakiworld.nested.classes;

import java.util.Iterator;

public class MyList {
	private int[] internalArr;
	private int size;
	
	public MyList() {
		size = 10;
		internalArr = new int[size];
		for(int i =0 ; i < size ; i++)
			internalArr[i] = i;
	}
	
	public MyList(int size) {
		this.size = size;
		internalArr = new int[size];
		for(int i =0 ; i < size ; i++)
			internalArr[i] = i;
	}
	
	//This uses inner classes
	public void printEvenNumbers() {
		Iterator<Integer> evenIterator = new MyListEvenIterator();
		printElements(evenIterator);
	}
	
	private void printElements(Iterator<Integer> iterator) {
		System.out.print("[");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println("]");
	}
	
	private class MyListEvenIterator implements Iterator<Integer> {
		private int noOfElements = size;
		private int indexCounter = 0;
		
		@Override
		public boolean hasNext() {
			return indexCounter <= noOfElements -  1;
		}

		@Override
		public Integer next() {
			Integer nextInteger =  internalArr[indexCounter];
			indexCounter += 2;
			return nextInteger;
		}
		
	}
	
	
	//use anonymous inner class
	public void printOddNumbers() {
		printElements(new Iterator<Integer>() {
			private int noOfElements = size;
			private int indexCounter = 1; //Changed starting index to 1
			
			@Override
			public boolean hasNext() {
				return indexCounter <= noOfElements -  1;
			}

			@Override
			public Integer next() {
				Integer nextInteger =  internalArr[indexCounter];
				indexCounter += 2;
				return nextInteger;
			}			
		});
	}
	
	public static void main(String[] args) {
		MyList list = new MyList();
		list.printEvenNumbers();
		list.printOddNumbers();
	}

	
}
