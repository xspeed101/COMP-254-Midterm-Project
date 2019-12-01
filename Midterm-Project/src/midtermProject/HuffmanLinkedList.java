package midtermProject;

public class HuffmanLinkedList<E>{ 
	
	HuffmanNode<E> head = null;
	HuffmanNode<E> tail = null;

	int size = 0;

	public HuffmanLinkedList() {
		
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public String first() {
		if (isEmpty()) return null;
		return (head.getLetter() + " " + head.getAscii() + " " + head.getOccurence() + " " + head.getFrequency() + " " + head.getOrderedFrequency() + " " + head.getHuffmanCode());
	}
	
	public String last() {
		if (isEmpty()) return null;
		return (tail.getLetter() + " " + tail.getAscii() + " " + tail.getOccurence() + " " + tail.getFrequency() + " " + tail.getOrderedFrequency() + " " + tail.getHuffmanCode());
	}
	
	public void printList() 
    { 
        HuffmanNode<E> node = head; 
        while (node != null) { 
            System.out.println(node.getLetter() + "\t" + node.getAscii() + "\t" + node.getOccurence() + "\t" + node.getFrequency() + "\t" + node.getOrderedFrequency() + "\t" + node.getHuffmanCode());
            node = node.next; 
        } 
    }
	
	public void addFirst (String letter, String ascii, String occurence, String frequency, String orderedFrequency, String huffmanCode) {
		head = new HuffmanNode<E>(letter, ascii, occurence, frequency, orderedFrequency, huffmanCode, head);
		if (size == 0)
			tail = head;
		size++;
	}
	public void addLast (String letter, String ascii, String occurence, String frequency, String orderedFrequency, String huffmanCode) {
		HuffmanNode<E> newset = new HuffmanNode<>(letter, ascii, occurence, frequency, orderedFrequency, huffmanCode, null);
		if (isEmpty())
			head = newset;
		else
			tail.setNext(newset);
		tail = newset;
		size++;
	}
	
	/* public E removeFirst() {
		if(isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if(size ==0)
			tail = null;
		return answer;
	} */
	
}

