package midtermProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void printArray(int [] arr){
		for(int l : arr){
			System.out.println(l);
		}
	}
	public static void printArray(double [] arr){
		for(double l : arr){
			System.out.println(l);
		}
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
		for(int i=0;i<letters.length; i++){

			ascii[i] = (int)(letters[i]);
		}
		int [] occurence = new int[letters.length];


		FileReader fr = null;
		try {
			fr = new FileReader("C:\\Users\\Kenyi\\Documents\\COMP-254-Midterm-Project\\Midterm-Project\\src\\midtermProject\\IronHeel.txt");
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
			printArray(frequencyArrayGen(occurence, sumArray(occurence)));
			System.out.println("array sum = " + sumArray(occurence));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
