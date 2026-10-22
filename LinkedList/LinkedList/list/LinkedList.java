package list;

public class LinkedList {
	Node HEAD;
    Node TAIL;	
	public LinkedList() {
		this.HEAD=null;
        this.TAIL=null;
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		Node curNode = this.HEAD;
		if(this.HEAD==null) {
			this.HEAD=newNode;
		}else {
			while(curNode.next!=null) {
				curNode=curNode.next;
			}
			curNode.next=newNode;
		}
	}
    public Node tailAppend(int value){
        Node newNode = new Node(value);
        Node curNode = this.TAIL;
        if(this.HEAD == null){ //If Head node is NULL, then new node is HEAD and TAIL
            this.HEAD=newNode;
            this.TAIL=newNode;
        } else{ //Increments tail to the next node at the end of the list
           TAIL.next = newNode;
           TAIL = newNode;
        }
        return newNode; 

    }
    public Node delete(int position){
        Node curNode = this.HEAD; 
         
        int i = 1;
        if(position == 0){
            this.HEAD = curNode.next;
            return curNode.next;
        }
        while(i < position){
            curNode = curNode.next;
            i++;
        }
        curNode.next = curNode.next.next; //current node references the node after the next, skipping deletes the next node. 
        return curNode;


    }
    public int search(int findVal){
        //current node is the HEAD
        Node curNode = this.HEAD;

        //Instantiate a temporary Node that is the value we are searching for
        Node searchNode = new Node(findVal);
        
        //Compares current node and the value we are looking for 
        
        int i = 0;
        while(curNode.value!=searchNode.value && curNode.next != null){
            curNode = curNode.next; //Navigates through Linked List
            i++;  
        }
        
        if(curNode.value != searchNode.value){ //If value is NOT in Linked List, return -1
            return -1;
        }
        return i; //If value is found in Linked List, return i (position) 
    }
	
	public void show() {
		Node curNode = this.HEAD;
		while(curNode!=null) {
			System.out.printf("----%s------\n", curNode.toString());
			System.out.printf("Value: %d - Next: %h\n", curNode.value,curNode.next);
			curNode=curNode.next;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
	    int position = 0;
        int findVal =30;
		list.tailAppend(10); //position 0
		list.tailAppend(20); //position 1
		list.tailAppend(30); //position 2
        list.tailAppend(40);
        list.tailAppend(50);
        list.show();
        System.out.printf("\nDeletion at Postition %d\n", position);
        list.delete(0);
		list.show();

        int searchVal = list.search(findVal);
        if(searchVal < 0) {
            System.out.printf("\nValue %d is not in Linked List\n", findVal);
        } else {
            System.out.printf("\nValue %d is at position %s\n", findVal, searchVal);
        }
        list.show();

	}

}
