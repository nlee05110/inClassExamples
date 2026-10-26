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
		}else {
			while(curNode.next!=null) {
				curNode = curNode.next;
			}
			curNode.next = newNode;
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
		}else {
			while(curNode!=null) {
				if(curNode.value == value) {
					result = curNode;
					prevNode.next = curNode.next;
					if(prevNode.next!=null) {
						this.tail = prevNode.next;
					}else {
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
			System.out.printf("Value: %d  Next: %h\n", curNode.value,curNode.next);
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
