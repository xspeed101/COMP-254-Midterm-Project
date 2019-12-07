package midtermProject;

import java.util.*;


abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int occurence; 
    public HuffmanTree(int occ) { occurence = occ; }
 
    
    public int compareTo(HuffmanTree tree) {
        return occurence - tree.occurence;
    }
}
 
class HuffmanLeaf extends HuffmanTree {
    public final char value; 
 
    public HuffmanLeaf(int occ, char val) {
        super(occ);
        value = val;
    }
}
 
class Huffman extends HuffmanTree {
    public final HuffmanTree left, right; 
 
    public Huffman(HuffmanTree l, HuffmanTree r) {
        super(l.occurence + r.occurence);
        left = l;
        right = r;
    }
}
 
public class HuffmanCode {
    public static HuffmanTree buildTree(int[] charOccurence) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        
        for (int i = 0; i < charOccurence.length; i++)
            if (charOccurence[i] > 0)
                trees.offer(new HuffmanLeaf(charOccurence[i], (char)i));
 
        assert trees.size() > 0;
        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
 
            trees.offer(new Huffman(a, b));
        }
        return trees.poll();
    }
 
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
 
            System.out.println(leaf.value + "\t" + leaf.occurence + "\t" + prefix);
 
        } else if (tree instanceof Huffman) {
            Huffman node = (Huffman)tree;
 
           
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
