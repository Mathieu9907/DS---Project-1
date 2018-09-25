import java.util.Arrays;

public class LinkedBag<T> extends ResizableArrayBag<T> implements BagInterface<T> {

	private Node firstNode;
	private int numberOfEntries;

	public LinkedBag() { // empty bag
		firstNode = null;
		numberOfEntries = 0;
	}

	public int getCurrentSize() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public boolean add(T anEntry) {
		Node newNode = new Node(anEntry, firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}
	
	@Override

	public boolean remove(T newEntry) {
        for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
          if (currentNode.data.equals(newEntry)) {
             currentNode.setData(firstNode.getData());
             firstNode = firstNode.getNext();
             numberOfEntries--;
             return true;
          }
        }
        return false;
	 }
	
	 public T remove() {
        if (firstNode != null) { // more than 0 items
          T temp = firstNode.data;
          firstNode = firstNode.getNext();
          numberOfEntries--;
          return temp;
        }
        return null;
	 }


	public void clear() {
		while (!(firstNode == null)) {
			remove();
		}
	}

	public boolean contains(T newEntry) {

		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (currentNode.data.equals(newEntry)) {
				return true;
			}
		}
		return false;
	}

	public int getFrequencyOf(T newEntry) {

		int counter = 0;
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (currentNode.data.equals(newEntry)) {
				counter++;
			}
		}
		return counter;
	}

	@SuppressWarnings("unchecked")
    public T[] toArray() {
	   T[] result = (T[]) new Object[numberOfEntries];
	   int count = 0;
	   for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
	      result[count] = currentNode.data;
	      count++;
	    }
	   return result;
	}

	private class Node {
	    private T data;
	    private Node next;
	
	    Node (T data, Node nextNode) {
	         this.data = data;
	         firstNode = nextNode;
	    }
	
	    Node (T data) {
	    	 this(data, null);
	    }

	    public void setData (T item) {
	    	 data = item;
        }
       
        public T getData () {
        	 return data;
        }
       
        public Node getNext () {
             return next;
        }

	}
}
