
package midtermProject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.*;
import java.util.stream.Stream;

public class Main {

	public static String readFile(String filePath)
	{
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static String linearSearchLinkedList(HuffmanLinkedList list, Character elementToSearch) {
		HuffmanNode head = list.head;
		for (int index = 0; index < list.size(); index++) {
			if (head.getLetter().equals(elementToSearch.toString()))
				return head.getHuffmanCode();

			head=head.getNext();
		}
		return "100";
	}
	public static String linearSearchLinkedListletter(HuffmanLinkedList list, String elementToSearch) {
		HuffmanNode head = list.head;
		for (int index = 0; index < list.size(); index++) {
			if (head.getHuffmanCode().equals(elementToSearch.toString()))
				return head.getLetter();

			head=head.getNext();
		}
		return "";
	}
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
	public static void printArray(String [] arr) {
		for(String l : arr) {
			System.out.println(l);
		}

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
	public static double CompressionRate(long initial, long current){
		return 100.00 - (((double) current/(double)initial)*100.00);
	}

	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////////////////////////
		//                                                                                         //
		//------------------------------Level 1----------------------------------------------------//
		//                                                                                         //
		//                                                                                         //
		/////////////////////////////////////////////////////////////////////////////////////////////
		char[] letters = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		int[] ascii = new int [27];
		boolean loop = true;
		for(int i=0;i<letters.length; i++){

			ascii[i] = (int)(letters[i]);
		}
		int [] occurence = new int[letters.length];

		FileReader fr = null;
		try {
			fr = new FileReader("Midterm-Project\\src\\midtermProject\\IronHeel.txt");
			int i;
			int index =-1;
			while ((i=fr.read()) != -1) {
				if(i < 32 || i > 122) continue;
				if(i >= 65 && i<= 90 ) i +=32;
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
		/////////////////////////////////////////////////////////////////////////////////////////////
		//                                                                                         //
		//------------------------------Level 2----------------------------------------------------//
		//                                                                                         //
		//                                                                                         //
		/////////////////////////////////////////////////////////////////////////////////////////////
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
				System.exit(0);
			} else if (proceed.equals("Y") || proceed.equals("y")) {
				loop = false;
				System.out.println("Proceeding to level 3 processing");
			} else {
				System.out.println("Invalid input");
				loop = true;
			}
		}
		loop = true;
		/////////////////////////////////////////////////////////////////////////////////////////////
		//                                                                                         //
		//------------------------------Level 3----------------------------------------------------//
		//                                                                                         //
		//                                                                                         //
		/////////////////////////////////////////////////////////////////////////////////////////////

		// Hashmap to map frequencies to letters
		Map<Character, Double> map = new HashMap<>();
		//populate hash map with letters and frequencies
		for(int i=0; i<letters.length; i++){
			map.put(letters[i], frequency[i]);
		}
		Comparator<Entry<Character, Double>> valueComparator = (e1, e2) -> {
			Double v1 = e1.getValue();
			Double v2 = e2.getValue();
			return v1.compareTo(v2);
		};
		//create set with map entries
		Set<Entry<Character, Double>> entries = map.entrySet();
		//Convert set entries to an array list
		List<Entry<Character, Double>> listOfEntries = new ArrayList<>(entries);
		// sorting HashMap by values using comparator
		Collections.sort(listOfEntries, valueComparator);
		LinkedHashMap<Character, Double> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
		// copying entries from List to Map
		for(Entry<Character, Double> entry : listOfEntries){
			sortedByValue.put(entry.getKey(), entry.getValue());
		}
		Set<Entry<Character, Double>> entrySetSortedByValue = sortedByValue.entrySet();
		//defining predefined list of huffmancodes
		String [] code = new String[]{"100","0010","0011","1111","1110","1100","1011","1010","0110","0101","11011","01111","01001","01000","00011","00010","00001","00000","110101","011101","011100","1101001","110100011","110100001","110100000","1101000101","11010001000"};
		Map encode = new HashMap();
		int k = 26;
		//map each letter to Huffmancode according to their frequencies
		for(Entry<Character, Double> mapping : entrySetSortedByValue){
			encode.put(mapping.getKey(), code[k]);
			k--;
		}
		String[] huffcode = new String[letters.length];
		//insert huffman code in new array match index of each letter in letters array.
		for(int j= 0; j<letters.length;j++){
			huffcode[j] = (String) encode.get(letters[j]);
		}

		//Loop through each node in the Huffmanlinked list and add huffman code for each node
		HuffmanNode head = list.head;
		for(int z=0;z<list.size(); z++){
			if(head.getNext() != null){
				head.setHuffmanCode(huffcode[z]);
			}
			else{
				head.setHuffmanCode(huffcode[z]);
			}
			head = head.next;
		}
		list.printList();
		loop = true;

		while (loop) {
			System.out.println("Would you like to continue to level 4? Y/N");
			String proceed = input.next();
			if (proceed.equals("N") || proceed.equals("n")) {
				loop = false;
				System.exit(0);
			} else if (proceed.equals("Y") || proceed.equals("y")) {
				loop = false;
				System.out.println("Proceeding to level 4 processing");
			} else {
				System.out.println("Invalid input");
				loop = true;
			}
		}

		FileReader fr1 = null;
		try {
			fr1 = new FileReader("Midterm-Project\\src\\midtermProject\\IronHeel.txt");
			int i;
			String hc ="";
			System.out.println("Encoding file...");
			while ((i=fr1.read()) != -1) {
				if(i < 32 || i > 122) continue;
				if(i >= 65 && i<= 90 ) i +=32;
				hc += linearSearchLinkedList(list, (char) i);

			}

			FileWriter fileWriter = new FileWriter("Midterm-Project/src/IronHeelCoded.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(hc);
			printWriter.close();
			System.out.println("Done!!!");
			System.out.println("Initial Size: "+sumArray(occurence)*8);
			System.out.println("Current Size: "+ hc.toCharArray().length);
			System.out.println("Compression Rate: "+ CompressionRate((sumArray(occurence)*8),hc.toCharArray().length ));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		loop = true;

		while (loop) {
			System.out.println("Would you like to continue to level 5? Y/N");
			String proceed = input.next();
			if (proceed.equals("N") || proceed.equals("n")) {
				loop = false;
				input.close();
				System.exit(0);
			} else if (proceed.equals("Y") || proceed.equals("y")) {
				loop = false;
				input.close();
				System.out.println("Proceeding to level 5 processing");
			} else {
				System.out.println("Invalid input");
				loop = true;
			}

			String Content  = readFile("Midterm-Project/src/IronHeelCoded.txt");

			char [] codedtext = Content.toCharArray();
			String combination = "";
			String text = "";
			System.out.println("Writing to IronHeelDecrypted...");
			for(Character c : codedtext){
				combination+= c.toString();
				System.out.println(combination);if(combination.toCharArray().length >= 3){

					String l = linearSearchLinkedListletter(list,combination);
					if(l.equals("")){
						continue;
					}else {
						text+=l;
						combination ="";
					}
				}

			}
			try {
				FileWriter fileWriter = new FileWriter("Midterm-Project/src/ironHeelDecrypted..txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);
				printWriter.print(text.toUpperCase());
				System.out.println("Done!!");
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
	}
}
