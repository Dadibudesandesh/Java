class Stack{
	private int top;
	private int[] stack;
	
	Stack(){
		this.top=-1;
		this.stack=new int[5];
	}

	public boolean isFull(){
		return top==stack.length-1;
	}

	public boolean isEmpty(){
		return top==-1;
	}

	public void push(int data){
		if(isFull()){
			System.out.print("Stack is full.....!");
		}else{
			top++;
			stack[top]=data;
			System.out.println("Data Pushed : "+data);
		}
	}

	
	public void pop(){
		if(isEmpty()){
			System.out.print("Stack is Empty.....!");
		}else{
			System.out.println("Data Poped : "+stack[top]);
			top--;
		}
	}

	public void display(){

		if(top==-1){
			System.out.println("Stack is empty....!");
			return;
		}else{
			for(int i=0;i<=top;i++){
				System.out.println(stack[i]);
			}
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
		st.pop();
		st.pop();
		st.pop();
		st.display();
	}
}