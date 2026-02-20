package queues;

public class StringQueue {
    int front=-1;
    int rear=-1;
    String[] arr;
    int capacity;

    //contructor for declaring the array(which will be converted to Queue)
    QueueString(int capacity){
        this.capacity=capacity;
        arr=new String[capacity];
    }


    //for insertion of an element
    void Enqueue(String id){
        if(rear>=capacity-1){
            System.out.println("Queue Overflow!");
            return;
        }
        if (front==-1)
            front=0;
        rear++;
        arr[rear]=id;
    }

    //for removal for an element
    String Dequeue(){
        String pass_id;
        if(front==-1 && rear==-1){
            System.out.println("Queue underFlow!");
            return "-1";
        }

        //if front > rear --------------->means array Empty(so set front and rear=-1)
        if(front==rear){
            pass_id=arr[front];
            front=-1;
            rear=-1;
            return pass_id;
        }

        else
            return arr[front++];

    }

    //to display the frontMost element
    String Front(){
        if (front==-1) {
            System.out.println("The Queue is Empty!");
            return null;

        }
        else
            return arr[front];
    }


    //to check whether the Queue is Empty or not!
    boolean isEmpty(){
        if (front==-1 & rear==-1)
            return true;


        else{
            return false;
        }

    }

    void Display(){

        if (isEmpty())
            System.out.println("Queue Empty!");

        else{
            System.out.print("[");
            for(int i=front;i<=rear;i++){
                if(i==rear)
                    System.out.print(arr[i]);
                else
                System.out.print(arr[i]+",");
            }
            System.out.print("]");
        }
    }




}

