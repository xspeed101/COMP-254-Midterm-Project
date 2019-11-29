package midtermProject;

public class HuffmanNode<E> {
	private String letter;
	private String ascii;
	private String occurence;
	private String frequency;
	private String orderedFrequency;
	private String huffmanCode;
	HuffmanNode<E> next;
	
	public HuffmanNode() {
		
	}
	
	public HuffmanNode(String letter, String ascii, String occurence, String frequency, String orderedFrequency, String huffmanCode, HuffmanNode<E> next) {
		this.letter = letter;
		this.ascii = ascii;
		this.occurence = occurence;
		this.frequency = frequency;
		this.orderedFrequency = orderedFrequency;
		this.huffmanCode = huffmanCode;
		this.next = next;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public String getAscii() {
		return ascii;
	}
	
	public String getOccurence() {
		return occurence;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public String getOrderedFrequency() {
		return orderedFrequency;
	}
	
	public String getHuffmanCode() {
		return huffmanCode;
	}
	
	public HuffmanNode<E> getNext() {		
		return next;
	}
	
	public void setNext(HuffmanNode<E> n) {
		next = n;
	}
}
