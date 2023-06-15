package chess2;
/*Erin Tomorri
 *Mrs Katsman
 * ICS4U
 * This is a stacked list 
 */
public class StackedList {

    private Node head = null;
    int size = 0;
   
    public void push(int n){// puts in a new item into the stack and connects it to the previous node
        Node newNode = new Node(n);
        newNode.setNext(head);
        head = newNode;
        size++; //increases size of stack 
    }  
    public int pop(){ //pops the top item off the stack 
        int poppedData = head.data; 
        head = head.next;
        size--; // lowers size of stack 
        return poppedData;
    }
    public boolean isEmpty() {
        return head == null;//checks if the head is nothing 
    }
    public void sort() { // recursively insertion sort 
        StackedList sortedStack = new StackedList();
        while (!isEmpty()) {
            int current = pop(); //pop the top of the stack
            while (!sortedStack.isEmpty() && sortedStack.head.data > current) { //while the sorted stack is not empty and the top element is greater than the current element
                push(sortedStack.pop());//pop the top element from the sorted stack and push it back into the original stack
            }
            sortedStack.push(current);
        }
        head = sortedStack.head; // change the stack head back to the sortedstack orignal head
    }
   
    private class Node{
        private int data; //information in node (any type)
        private Node next; // recursive link
   
        //constructor for the node class
        private Node(int a){
            data =  a;
            next =  null;
        }
        //get the information stored
        private int getData(){
            return data;
        }
        //get the next node
        private Node getNext(){
            return next;
        }
        // set next node
        private void setNext (Node n){
            next = n;
        }
    }
}

