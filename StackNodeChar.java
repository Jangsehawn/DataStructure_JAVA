
public class StackNodeChar {
	char data;
	StackNodeChar link;
}

class LinkedStackChar {
	private StackNodeChar top;

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(char item) {
		StackNodeChar newNode = new StackNodeChar();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	public char pop() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		} else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}

	public void delete() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
		} else {
			top = top.link;
		}
	}

	public char peek() {
		if (isEmpty()) {
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		} else
			return top.data;
	}
	
	public int countNode() {
		int cnt = 0;

		StackNodeChar temp = top;
		while (temp != null) {
			cnt++;
			temp = temp.link;
		}
		return cnt;
	}

	public void printStackChar() {
		if (isEmpty())
			System.out.printf("Linked Stack is empty!! %n %n");
		else {
			StackNodeChar temp = top;
			System.out.println("\nLinked Stack>> ");
			while (temp != null) {
				System.out.printf("\t %c \n", temp.data);
				temp = temp.link;
			}
			System.out.println();
		}
	}
}
class OptExp{
	private String exp;
	private int expSize, postfixSize=0;
	private char testCh, openPair;
	
	public boolean testPair(String exp){
		this.exp = exp;
		LinkedStackChar S = new LinkedStackChar();
		expSize = this.exp.length();
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '(' :
				case '{' :
				case '[' : 
					S.push(testCh); break;				
				case ')' :
				case '}' :
				case ']' : 
					if(S.isEmpty()) return false;
					else{
						openPair = S.pop();
						if((openPair == '(' && testCh != ')') ||
						   (openPair == '{' && testCh != '}') ||
						   (openPair == '[' && testCh != ']'))
						   return false;
					   else break;
					}
			}
		}
		if (S.isEmpty()) return true;
		else return false;
	}
	
	public char[] toPostfix(String infix){
		char testCh;		
		exp = infix;	
//		System.out.println("1. "+exp.length());
//		int expSize = 10;
		int j=0;
		char postfix[] = new char[expSize];
		LinkedStackChar S = new LinkedStackChar();
//		System.out.println("2. "+expSize);
		
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
//			System.out.println("3. "+i+" "+testCh);
			
			switch(testCh){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix[j] = testCh;
					j++;
					break;
					
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					S.push(testCh); break;
					
				case ')' :  postfix[j] =S.pop();
				j++;
				break;
				
				
				default:
			}
		}
		postfixSize = j;
		postfix[j] = S.pop();
		char [] postfix2 = new char[j];
		for(int i=0; i<postfixSize; i++) {
			postfix2[i]=postfix[i];			
		}
		return postfix2;
	}	
}

