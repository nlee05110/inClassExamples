package doublyLink;

public class LinkedList {
	protected Node head;
	protected Node tail;
		
	public LinkedList() {
		head=null;
		tail=null;
	}
	
	public void appendNoTail(int value) {
		//**********************************************************
		//** Append Node to End of List O(n)                      **
		//**********************************************************
		Node newNode = new Node(value);
		Node curNode = this.head;
		
		if(this.head==null) {
			this.head=newNode;
	        newNode.prev = null;	
        }else {
			while(curNode.next!=null) {
				curNode = curNode.next;
                
			}
			curNode.next = newNode;
            newNode.prev = curNode;
            
		}
	}
	
	
	public void append(int value) {
		//**********************************************************
		//** Append Node to End of List of with TAIL Pointer O(1) **
		//**********************************************************
		Node newNode = new Node(value);
		if(this.head==null) {
			this.head=newNode;
			this.tail=newNode;
		}else {
            newNode.prev = this.tail;  // References the newNode.prev to the current tail before tail is updated to newNode
			this.tail.next = newNode;
			this.tail = newNode;
		}	
	}
	
	public Node search(int value) {
		//**********************************************************
		//**  Search(Traversal) for value  O(n)                   **
		//**********************************************************
		Node result=null;
		Node curNode = this.head;
		while(curNode!=null) {
			if(curNode.value == value) {
				result = curNode;
				break;
			}
			curNode=curNode.next;
		}
		return result;
	}
	
	
	public Node delete(int value) {
		//**********************************************************
		//**  Delete for value  O(n)                              **
		//**********************************************************		
		Node result=null;
		Node curNode = this.head;
		Node prevNode = this.head;
		if(this.head.value == value) {
			result = this.head;
			this.head = this.head.next;
            this.head.prev = null; // Sets value of prev node to null if selected value is the head. 

            
		}else {
			while(curNode!=null) {
				if(curNode.value == value) {
					result = curNode;
					prevNode.next = curNode.next;
					if(prevNode.next!=null) {
                        
						this.tail = prevNode.next;
                        this.tail.prev = prevNode; // The newely selected tail.prev is referencing to the previous node. 
                        
					}else {
                        prevNode.prev = this.tail;  // References the prevNode.prev to the current tail before tail is updated to prev Node
						this.tail = prevNode;
					}
					break;
				}
				prevNode=curNode;
				curNode=curNode.next;
			}
		}
		return result;
	}

	public void show() {
		//**********************************************************
		//**  Show List  O(n)                                     **
		//**********************************************************	
		Node curNode = this.head;
		System.out.printf("=================\n");
		while(curNode!=null) {
			System.out.printf("---------------\n");
			System.out.printf("%s\n", curNode.toString());
			System.out.printf("Value: %d  Next: %h Prev: %h\n", curNode.value,curNode.next, curNode.prev);
			curNode = curNode.next;
		}
	}
	
	public static void main(String[] args) {
		
			LinkedList list = new LinkedList();
			list.append(5);
			list.append(10);
			list.append(15);
			list.append(25);
			list.show();
			list.delete(15);	
			list.append(40);
			list.show();
		
	}
}
