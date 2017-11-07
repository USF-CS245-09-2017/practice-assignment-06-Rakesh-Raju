/**
 * @rraju
 * Practice Assignment 6
 * 11/6/2017
 * 
 */


import java.util.NoSuchElementException;

public class BinaryHeap {

	public int[] heap;
	public int size = 0;

	public BinaryHeap() {
		heap = new int[10];
	}
	
	
	//adds instance to end of heap, adjusts heap accordingly.
	public void add(int i) {
		if(isFull()) {
			  reSize();
		}
		heap[size++] = i;
		heapUp(size - 1);
	}
	
	//doubles heap size
	private void reSize() {
		int[] temp = new int[heap.length * 2];
		for(int i = 0; i < heap.length; i++) {
			temp[i] = heap[i];	
		}
		
		heap = temp;
		
	}

	//heapup function, adjusts size to next
	private void heapUp(int i) {
		int temp = heap[i];
		
		while(i > 0 && temp < heap[parent(i)]) {
			heap[i] = heap[parent(i)];
			i = parent(i);
		}
		heap[i] = temp;
	}
	
	private int parent(int i) {
		return (i - 1) / 2;
	}


	//removes min element in heap, adjusts accordingly
	public int remove() {
		if(isEmpty() == false) {
			  int item = heap[0];
		        heap[0] = heap[1];
		        size--;
		        heapDown(0); 
		        return item;
		}
		throw new NoSuchElementException("Empty!");
	}

	//heapdown function, adjusts 0 to next
	private void heapDown(int i) {
		int child;
        int temp = heap[i];

        while (getChild(i, 1) < size)
        {
            child = minChild(i);
            if (heap[child] < temp)
                heap[i] = heap[child];
            else
                break;
            i = child;
        }
        heap[i] = temp;
		
	}


	//gets the smallest child in the heap
	private int minChild(int i) {
		int child = getChild(i, 1);
        int k = 2;
        int pos = getChild(i, k);
        while ((k <= 2) && (pos < size)) 
        {
            if (heap[pos] < heap[child]) 
                child = pos;
            pos = getChild(i, k++);
        }    
        return child;
	}


	//gets child at index
	private int getChild(int i, int j) {
		return (2 * i) + j;
	}

	//checks if heap is full
	public boolean isFull() {
		return size == heap.length;
	}
	
	//checks if heap is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
}
