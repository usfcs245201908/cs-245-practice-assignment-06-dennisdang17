import java.util.*;

public class ArrayQueue<T> implements Queue<T>
{
    private T[] a = (T[]) new Object[10];
    private int front = 0;
    private int back = 0;

    public T dequeue()
    {
        T item = a[front];
        front = (front+1) % a.length; //Remake position the front to either be 0 or bring it back by 1.
        return item;
    }

    public void enqueue(T item)
    {
        if((back+1) % a.length == front) //checks to see if array is full if it is, grow the array
        {
            grow_array();
        }
        a[back++] = item;//if not add item and increment back
        back = back % a.length;//set back to either the next item or to the first item if it is open.
    }

    public boolean empty()
    {
        return (front == back); //if front = back then the whole array is empty
    }

    protected void grow_array()
    {
        T[] newA = (T[]) new Object[a.length*2];
        if(back > front) //if the array is already in order from front to back
        {
            System.arraycopy(a, front, newA, 0, a.length-front);
        }
        else // else copy the front to the end and then the beginning to the back
        {
            System.arraycopy(a, front, newA, front, a.length-front);
            System.arraycopy(a, 0, newA, a.length - front, back);
        }
        front = 0; //reset the front to 0
        back = a.length-1; //reset the back to be the back of the array
        a = newA;
    }
}