package eg.edu.alexu.csd.datastructure.stack.cs70;

public class Stack implements IStack {
	
	DLinkedList Stack=new DLinkedList();
	
	@Override
	
	public Object pop() {
		if(Stack.isEmpty())
			throw new RuntimeException();
		Object POPED;
		POPED=Stack.get(1);
		Stack.remove(1);
		return POPED;
}
	
	@Override
	public Object peek(){
		if(Stack.isEmpty())
			throw new RuntimeException();
		Object POPED;
		POPED=Stack.get(1);
		return POPED;
	}
	
	@Override
	public void push(Object element) {
		
		Stack.add(1,element);
		
	}
	
	@Override
	public boolean isEmpty() {
		return Stack.isEmpty();
	}
	
	@Override
	public int size() {
		return Stack.size();
	}
	
}
