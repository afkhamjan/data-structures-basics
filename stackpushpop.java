import java.util.*;
class stack{
    private int []stackarr;
    int capacity;
    int top;

    public stack(int size){
      stackarr = new int[size];
         capacity = size;
         top = -1;// initiate top with empty.
    }
    public boolean isFull(){
        return top == capacity-1;
    }
    public boolean isempty(){
        return top == -1;
    }
    public void push(int x){
        if(isFull()){
            System.out.println("Stack is overflow");
        }
        else {
            top++;
            stackarr[top]= x;
        }
    }
    public int pop(){
        if(isempty()){
            System.out.println("STACK UNDERFLOW");
            return -1;
        }
        else{
            System.out.println("popping elements" + stackarr[top]+ " ");
            return stackarr[--top];
        }
    }
    public void display(){

        if(isempty()){
            System.out.println("stack is empty!");
            return;
        }
        else{
            System.out.println("stack contents: ");
            for (int i = top;i>=0;i--){
                System.out.println(stackarr[i]);
            }
            System.out.println();
        }
    }
    public int size(){
        return +1;
    }
    public int getCapacity(){
        return capacity;
    }
}

public class stackpushpop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---STACK IMPLEMENTING---");
        System.out.println();
        System.out.println("enter size of stack");
        int stacksize = sc.nextInt();

        stack st = new stack (stacksize);
        int choice ;
        boolean exit = false;
        while(!exit){
            System.out.println("\n" + "=".repeat(50));
            System.out.println(" STACK OPERATIONS MENU");
            System.out.println("=".repeat(50));
            System.out.println("1. Push element");
            System.out.println("2. Pop element");
            System.out.println("3. Display stack");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Get current stack size");
            System.out.println("7. Test Stack Overflow");
            System.out.println("8. Test Stack Underflow");
            System.out.println("9. Exit");
            System.out.println("=".repeat(50));
            System.out.print("Enter your choice (1-10): ");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    //push
                    System.out.println("enter element to push ");
                    int x = sc.nextInt();
                    st.push(x);
                    break;
                case 2:
                    //pop
                    st.pop();
                    break;
                case 3:
                    //display
                    st.display();
                    break;
                case 4:
                    //empty
                    if (st.isempty()){
                        System.out.println("stack is empty ");
                    }
                    else{
                        System.out.println("stack is not empty ");
                    }
                case 5:
                    //full
                    if(st.isFull()){
                        System.out.println("stack is full1 overflow ");
                        break;
                    }
                    else{
                        System.out.println("stack underflow!");
                    }
                    break;
                case 6:
                    //size
                    st.size();
                    break;
                case 7:
                    while(!st.isempty()){
                        st.pop();
                    }
                    st.display();
                    break;
                default:
                    System.out.println("enter valid choices!");
                    break;
            }
        }
        System.out.println();
    }
}
