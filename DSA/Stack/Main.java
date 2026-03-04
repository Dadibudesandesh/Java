class Stack{
	private int top;
	private int[] stack;
	
	Stack(){
		this.top=-1;
		this.stack=new int[10];
	}

	public int isFull(){
		if(top==stack.length){
			return 1;
		}else{
			return 0;
		}
	}

	public int isEmpty(){
		if(top==-1){
			return 1;
		}else{
			return 0;
		}
	}

	public void push(int data){
		if(isFull()){
			System.out.print("Stack is full.....!");
		}else{
			top++;
			stack[top]=data;
		}
	}

	
	public void pop(){
		if(isEmpty()){
			System.out.print("Stack is Empty.....!");
		}else{
			System.out.println("Data Poped : ",+this.stack[top]);
			top--;
		}
	}

	public void display(){
		for(int i : stack){
			System.out.println(i);
		}

	}
}


class Main{

	public static void main(String[] args){
		Stack st=new Stack();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);

		st.display();
	}
}