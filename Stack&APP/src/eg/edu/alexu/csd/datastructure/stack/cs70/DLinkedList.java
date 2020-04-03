package eg.edu.alexu.csd.datastructure.stack.cs70;

public class DLinkedList {
	private int size;
	private DNode head;
	
	
	public DLinkedList() {
		this.size = 0;
		this.head = null;
	}
	
	public DNode getHead() {
		return head;
	}
	
	public void add(int index, Object element) {	
		DNode node = new DNode();
		if (!element.equals(null)) {
			node.item = element;
			DNode current = this.head;
			if(index <= this.size + 1 && index > 0) {
				for(int i = 1; i < index - 1; i++) {
					current = current.next;
				}
				if (current == this.head && index == 1) {
						node.next = current;
						node.prev = null;
						this.head = node;
				} else {
					node.next = current.next;
					node.prev = current;
					current.next = node;
				}
				if (node.next != null) {
					node.next.prev = node;
				}
				this.size++;
				
			}
			else {
				throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
			}
		} else {
			throw new NullPointerException();
		}
	}
	
	
	public void add(Object element) {
		DNode node = new DNode();
		if (!element.equals(null)) {
			node.item = element;
			DNode current = this.head;
			node.next = null;
			if(this.head != null) { // can remove
				for(int i = 1; i < this.size; i++) {
					current = current.next;
				}
				current.next = node;
				node.prev = current;
				this.size++;
			}
			else {
				this.head = node;
				node.next = null;
				node.prev = null;
				this.size = 1;
			}
		} else {
			throw new NullPointerException();
		}
		
	}
	
	public Object get(int index) {
		DNode node = this.head;
		if (index >= 0) {     				
			if(index <= this.size && this.head != null) {
				for(int i = 1; i < index; i++) {			
					node = node.next;
				}
				return node.item;
			}
			else {
				throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
			}
		} else {
			throw new NullPointerException("The Index must be positive integer number");
		}
		
	}

	public void set(int index, Object element) {
		
		DNode current = this.head;
		
		if(index <= this.size && this.head != null && index > 0 && !element.equals(null)) {
			for(int i = 1; i < index; i++) {
				current = current.next;
			}	
			current.item = element;
		}
		else {
			throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
		}
	}


	public void clear() { //edit
		if(this.head != null) {
			this.head = null;
			this.size = 0;
		}
		else {
			System.out.println("The List is already empty");
		}
	}

	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		else {
			return false;
		}
	}


	public void remove(int index) { //edit
		DNode exnode = new DNode();
		DNode current = this.head;
		if (index >= 1) {									//BOS HNA
			if(index <= this.size && this.head != null) {
					for(int i = 1; i < index - 1; i++) {
						current = current.next;
					}
					if (index == 1) {
						this.head = current.next;
						if (this.head != null) {
							current.next.prev = null;
						}
					}
					else if (index == this.size) {
						current.next.prev = null;
						current.next = null; 
					} else {
						exnode = current.next;
						current.next = exnode.next;
						current.next.prev = current;
					}
					this.size--;
			}
			else {
				throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
			}
		} else {
			throw new NullPointerException("The Index must be positive integer number");
		}
	}

	public int size() {
		return this.size;
	}

	public DLinkedList sublist(int fromIndex, int toIndex){ //edit
		DLinkedList Subone = new DLinkedList();
		if(this.head != null) {
			if(toIndex < fromIndex || fromIndex < 1 || toIndex < 1 || fromIndex > this.size || toIndex > this.size) {
				throw new NullPointerException("Error in border index");
			}
			else if(fromIndex == toIndex) {
				Subone.add(fromIndex,this.get(fromIndex));
				return Subone;
			}
			else {
				for(int i = fromIndex; i <= toIndex; i++) {
					Subone.add(this.get(i));
			}
				return Subone;
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	public boolean contains(Object o) {//edit
		if(this.head != null) {
			DNode current = this.head;
			for(int i = 1; i <= this.size; i++) {
				if(current.item.equals(o)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}
	

	}



