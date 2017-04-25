package alp3_mulzer_u12_trie;

import java.util.HashMap;
import java.util.Set;

public class TrieVocabulary implements IVocabulary{
	Node root;
	char errorChar = '}';
	
	public TrieVocabulary(){
		this.root = new Node();
		this.root.val = -1;
		this.root.parent = null;
	}
	
	class Node{
		HashMap<Character, Node> children;
		Node parent;
		int val; //val >=0 means end of word, value of word = val 
		private Node(){
			this.val = -1;
			this.children = new HashMap<Character, Node>();
		}
	}
		
	@Override
	public boolean put(String s, int val) {
		s = s.toLowerCase();
		if (!isValid(s)){
			return false;
		}
		else{
			char[] chars = s.toCharArray();
			
			Node currNode = this.root;
			for(char c: chars){
				System.out.println("Putting: " + c);
				if (currNode.children != null && currNode.children.containsKey(c)){
					System.out.println(c + " is already in trie");
					currNode = currNode.children.get(c);
				}
				else{
					Node newNode = new Node();
					newNode.parent = currNode;
					currNode.children.put(c, newNode);
					currNode = newNode;
				}
			}
			currNode.val = val;
			System.out.println("After putting " + s + " currNode has value: " + currNode.val);
			System.out.println("After putting " + s + " currNode.children isEmpty(): " + currNode.children.isEmpty());
			return true;
		}
	}

	@Override
	public int get(String s) {
		s = s.toLowerCase();
		if (isValid(s)){
			System.out.println("Getting value of " + s);
			char[] chars = s.toCharArray();
			Node currNode = this.root;
			for(char c : chars){
				if(currNode.children.containsKey(c)){
					currNode = currNode.children.get(c);
					System.out.println("currNode <" + c + "> has value " + currNode.val);
				}
				else{
					return -1;
				}
			}
			return currNode.val;
		}
		else{
			return -1;
		}
	}

	@Override
	public boolean remove(String s) {
		s = s.toLowerCase();
		System.out.println("Removing " + s);
		if (!isValid(s) || !isInTrie(s)){//word should be in trie
			return false;
		}
		else{
			char[] chars = s.toCharArray();
			Node currNode = getLastNode(chars);
			if (!currNode.children.isEmpty()){//path goes on
				System.out.println("Removing by value change to -1");
				currNode.val = -1;
				return true;
			}
			else{//delete simple nodes bottom-up
				int index = chars.length-1;
				while(index>-1 && currNode.children.isEmpty()){
					char currC = chars[index];
					System.out.println("Removing char " + currC);
					currNode = currNode.parent;
					currNode.children.remove(currC);
					index--;
				}
				return true;
			}
		}
	}

	@Override
	public int succ(String s) {
		s = s.toLowerCase();
		int resVal = -1;
		char[] chars = s.toCharArray();
		Node currNode = getLastNode(chars);
		System.out.println("Getting successor of " + s);
		if (!isValid(s) || !isInTrie(s)){//word should be in trie
			return resVal;
		}
		else{
			if (!currNode.children.isEmpty()){//find succ below
				return resVal = findSuccBelow(currNode);
			}
			else{//find succ above
				Tuple<Character, Node> position = getSuccPath(chars, currNode);
				char succPath= position.x;
				currNode = position.y;
				if (succPath == errorChar){
					return -1;
				}
					else{
					currNode = currNode.children.get(succPath);
					if (currNode.val>=0){
						return resVal = currNode.val;
					}
					else{
						return resVal = findSuccBelow(currNode);
					}
				}
			}
		}
	}
	
	private boolean isValid(String s){
		if (s.length()<1){return false;}
		for(int i=0; i<s.length(); i++){
			if (!Character.isLetter(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	private boolean isInTrie(String s){
		return (get(s)>=0);
	}
	
	private Node getLastNode(char[] chars){
		Node currNode = this.root;
		for(char c: chars){//go to eof word
				currNode = currNode.children.get(c);
		}
		return currNode;
	}
	private int findSuccBelow(Node currNode){
		char minC = errorChar;
		while(true){
			Set<Character> cc =  currNode.children.keySet();
			System.out.println("possible node keys: " + cc.toString());
			for(char c : cc){
				if (c<minC){
					minC = c;
				}
			}
			System.out.println("smallest key: " + minC);
			currNode = currNode.children.get(minC);
			if (currNode.val>=0){
				int resVal = currNode.val;
				return resVal;
			}
		}
	}
	
	private Tuple<Character, Node> getSuccPath(char[] chars, Node currNode){
		int index = chars.length-1;
		boolean foundDir = false;
		char dir=errorChar;
		while(!foundDir){
			while(currNode.children.size()<=1){
				currNode = currNode.parent;
				index--;
			}
			char minC = errorChar;
			char noC = chars[index+1];
			Set<Character> cc =  currNode.children.keySet();
			System.out.println("possible node keys: " + cc.toString());
			System.out.println("no char: " + noC);
			for(char c : cc){
				System.out.println("checking " + c);
				if ((c<minC) && (c>noC)){
					minC = c;
				}
			}
			System.out.println("smallest key: " + minC);
			if(minC!=errorChar){
				foundDir=true;
				dir = minC;
				System.out.println("direction to take: " + dir);
			}
			else{//no successor in trie
				currNode = currNode.parent;
				index--;
				if(index<-1){
					Tuple<Character, Node>res = new Tuple<Character, Node>(errorChar, null);
					return res;
				}
			}
		}
		Tuple<Character, Node> res = new Tuple<Character, Node>(dir, currNode);
		return res;
	}
	
	private class Tuple<X, Y> { 
		  private  X x; 
		  private  Y y; 
		  private Tuple(X x, Y y) { 
		    this.x = x; 
		    this.y = y; 
		  } 
		} 

}
