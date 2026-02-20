package queues;

public class Queue {
    int front=-1;
    int rear=-1;
    int[] arr;
    int capacity;

    //contructor for declaring the array(which will be converted to Queue)
    Queue(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
    }


    //for insertion of an element
    void Enqueue(int num){
        if(rear>=capacity-1){
            System.out.println("Queue Overflow!");
            return;
        }
        else {
            if (front == -1 && rear==-1)
                front = 0;
            rear++;
            arr[rear] = num;
        }
    }

    //for removal for an element
    int Dequeue(){
        int item;
        if(front==-1 && rear==-1){
            System.out.println("Queue underFlow!");
            return -1;
        }

        //if front > rear --------------->means array Empty(so set front and rear=-1)
        if(front==rear){
            item=arr[front];
            front=-1;
            rear=-1;
            return item;
        }

        else
            return arr[front++];

    }

    //to display the frontMost element
    int Front(){
        if (front==-1) {
            System.out.println("The Queue is Empty!");
            return -1;

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


    void Display(int[] arr){

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


    //for rotataing the Queue by N members from the front
    void rotate(int N){
        int[] arr2=new int[capacity];
        int i;
        for(i=N;i<capacity;i++)
            arr2[i-N]=arr[i];

        for(int j=0;j<N;j++)
            arr2[capacity - N + j] = arr[j];


        //for printing the array
        Display(arr2);
    }
}
