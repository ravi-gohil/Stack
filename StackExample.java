import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackExample {


	private int stackSize;
	private int[] stackArr;
	private int top;

	public StackExample(int size){
		this.stackSize = size;
		this.stackArr = new int[size];
		this.top = -1;
	}
	
	public void push(int entry) throws Exception{
		if(this.isStackFull()){
			throw new Exception ("Sorry, Stack is full. No data can be added. ");
		}
		
		System.out.println("Adding new Data : " + entry);
		this.stackArr[++top] = entry;
	}
	
	public void pop() throws Exception{
		if(this.isStackEmpty()){
			throw new Exception("Sorry, Stack is already Empty. No Data can be removed. ");
		}
		
		int entry = this.stackArr[top--];
		System.out.println("Removed Data :" + entry);
	}
	
	public int peek(){
		return stackArr[top];
	}
	
	public boolean isStackFull(){
		return (top == stackSize - 1);
	}
	
	public boolean isStackEmpty(){
		return (top == -1);
	}
	
	public static void main(String args[]) throws IllegalArgumentException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter the size of stack");
		int size = Integer.parseInt(br.readLine());
		StackExample se = new StackExample(size);
		try{
			System.out.println("Please enter\n 1 for push operation\n2 for pop operation\n3 for peek operation");
			String entry = br.readLine();
			int number;
			switch(entry){
			case "1": 
				System.out.println("Please enter the number");
				for (int i=0;i< size; i++)
					{
					number =Integer.parseInt(br.readLine());
					se.push(number);
					}
				break;
			
			case "2":
				se.pop();
				break;
				
			case "3":
				se.peek();
				break;
				
			default :
				System.out.println("Wrong input");
			}
			
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
