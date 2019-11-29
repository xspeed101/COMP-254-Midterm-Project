
package midtermProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void printArray(int [] arr){
		for(int l : arr){
			System.out.println(l);
		}
		System.out.println();
	}
	public static void printArray(double [] arr){
		for(double l : arr){
			System.out.println(l);
		}
		System.out.println();
	}
	public static void printArray(char [] arr) {
		for(char l : arr) {
			System.out.print(l);
		}
		System.out.println();
		System.out.println();
	}
	public static double[] frequencyArrayGen(int [] array, int total){
		double arr [] = new double[array.length];
		for(int i=0;i<array.length; i++){
			double f = (double)array[i]/(double) total;
			arr[i] = Math.round(f*100.0)/100.0;
		}
		return arr;

	}
	public static int sumArray(int [] arr){
		int sum = 0;
		for(int l : arr){
			sum +=l;
		}
		return sum;
	}
	public static int linearSearch(char [] arr, char elementToSearch) {

		for (int index = 0; index < arr.length; index++) {
			if (arr[index] == elementToSearch)
				return index;
		}
		return -1;
	}

	public static void main(String[] args) {
		char[] letters = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		int[] ascii = new int [27];
		boolean loop = true;
		for(int i=0;i<letters.length; i++){

			ascii[i] = (int)(letters[i]);
		}
		int [] occurence = new int[letters.length];

		FileReader fr = null;
		try {
			fr = new FileReader("src/midtermProject/IronHeel.txt");
			int i;
			int index =-1;
			while ((i=fr.read()) != -1) {

				index = linearSearch(letters, (char) i);
				if(index == -1) {

					occurence[letters.length-1] += 1;
				}else{
					occurence[index] += 1;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double [] frequency = frequencyArrayGen(occurence, sumArray(occurence));
		double [] orderedFrequency = frequencyArrayGen(occurence, sumArray(occurence));
		Arrays.sort(orderedFrequency);
		
		System.out.println("Displaying letter array");
		printArray(letters);
		System.out.println("Displaying ascii array");
		printArray(ascii);
		System.out.println("Displaying occurence array");
		printArray(occurence);
		System.out.println("Displaying frequency array");
		printArray(frequency);
		System.out.println("Displaying ordered frequency array");
		printArray(orderedFrequency);
		
		Scanner input = new Scanner(System.in);
		
		while (loop == true) {			
			System.out.println("Would you like to continue to level 2? Y/N");			
			String proceed = input.next();
			if (proceed.equals("N") || proceed.equals("n")) {
				loop = false;
				System.exit(0);
			} else if (proceed.equals("Y") || proceed.equals("y")) {
				loop = false;
				System.out.println("Proceeding to level 2 processing");
			} else {
				System.out.println("Invalid input");
				loop = true;
			}
		}
		loop = true;
		
		String empty = "";
		HuffmanLinkedList list = new HuffmanLinkedList();
		list.addFirst(String.valueOf(letters[0]), String.valueOf(ascii[0]), String.valueOf(occurence[0]), String.valueOf(frequency[0]), String.valueOf(frequency[0]), empty);
		
		for(int i = 1; i < letters.length; i++) {
			list.addLast(String.valueOf(letters[i]), String.valueOf(ascii[i]), String.valueOf(occurence[i]), String.valueOf(frequency[i]), String.valueOf(frequency[i]), empty);
		}
		
		list.printList();
		
		while (loop == true) {			
			System.out.println("Would you like to continue to level 3? Y/N");
			String proceed = input.next();
			if (proceed.equals("N") || proceed.equals("n")) {
				loop = false;
				input.close();
				System.exit(0);
			} else if (proceed.equals("Y") || proceed.equals("y")) {
				loop = false;
				input.close();
				System.out.println("Proceeding to level 3 processing");
			} else {
				System.out.println("Invalid input");
				loop = true;
			}
		}
		loop = true;
	}
}
