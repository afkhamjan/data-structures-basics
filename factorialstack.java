import java.util.*;
import java.util.Stack;
class stackk{
    int [] stackarr;
    int top;
    int capacity;

    stackk (int size){
        capacity = size;
        stackarr = new int [capacity];
        top = -1;
    }
    public boolean isfull(){
        return top == capacity -1;
    }
    public boolean isempty(){
        return  top ==-1;
    }

    void push(int x){
        if(isfull()){
            System.out.println("stack overflow " +x);
        }else{
            stackarr[++top] = x;
        }
    }
    int pop(){
        if(isempty()){
            System.out.println("stack underflow ");
            return -1;
        }else{
            return stackarr[top--];
        }
    }
}

public class factorialstack {
    public static int factorial(int n){
        int fact = 1;
        for(int i = 0;i<=n;i++){
            fact*=i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        stackk st = new stackk(5);
        System.out.println("enter 5 values to push");
        for(int i=0;i<5;i++){
            int x = sc.nextInt();
            st.push(x);
        }
        System.out.println("\n popping elements and calc factorial");
        while(!st.isempty()){
            int x = st.pop();
            if(x!=-1){
                int fact = factorial(x);
                System.out.println("factorial " +x + " = " + fact);
            }
        }

    }
}
