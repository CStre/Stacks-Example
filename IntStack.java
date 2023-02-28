public class IntStack 
{
	// May create private stack here.

	private int nextIndex;
	private int[] stack;
	
	
	public IntStack() {
		// TODO: Code to initialize your stack.
		this.stack = new int[110];
		this.nextIndex = 0;
	}

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack will never contain more than 100 elements.
		this.stack[this.nextIndex] = x;
		this.nextIndex += 1;
	}

	public int pop() {
		// TODO: Code to pop and return an item from the top of the stack. If the stack is empty, return -1.
		if (this.nextIndex > 0) {
			int at = this.stack[this.nextIndex - 1];
			this.nextIndex -= 1;
			return at;
		}
		else
			return - 1;
	}
}