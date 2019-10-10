import java.util.*;

public class ArrayStack<T> implements Stack<T>
{
    private T[] a = (T[]) new Object[10];
    private int top = -1;

    public void push(T item)
    {
        if(a.length - 1 == top) //Check to see if the array is fill or not
        {
            grow_array();
        }
        a[++top] = item; //at the item and then increment the array
    }

    public T pop()
    {
        return a[top--]; //remove the item and then return it
    }

    public T peek()
    {
        return a[top]; //return the top item in the arrays
    }

    public boolean empty()
    {
        return (top == -1);
    }

    protected void grow_array()
    {
        T[] newA = Arrays.copyOf(a, a.length*2); //grow the array and copy it into a new array of 2 times the size.
        a = newA;
    }
}