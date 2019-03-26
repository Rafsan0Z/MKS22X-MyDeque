import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end, capacity;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[10];
    size = 5;
    start = 0;
    end = 0;
    capacity = 10;
  }
  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    size = initialCapacity/2;
    start = 0;
    end = 0;
    capacity = initialCapacity;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String result = "{";
    boolean finished = false;
    for(int i = start; i < end; i++){
      result = data[i] + " ";
      if(i == end - 1){finished = true;}
    }
    if(!finished){
    for(int i = 0; i < end; i++){
        result += data[i] + " ";
    }
  }
    return result + "}";
  }

  public void resize(E[] input){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size*2];
    for(int i = start+1; i < input.length; i++){
      data[i] = input[i-1];
    }
    for(int i = 0; i <= end; i++){
      data[i] = input[i];
    }
    data = d;
    size++;
    start++;
  }
  public void addFirst(E element){
    if(element == null){throw new NullPointerException();}
    if(size > 0){end++;}
    if(end == capacity){end = 0;}
    if(Math.abs(end-start) == 1){resize(data);}
    if(end >= capacity && start == 0){resize(data);}
    data[end] = element;
    size++;
  }
  public void addLast(E element){
    if(element == null){throw new NullPointerException();}
    if(size != 0){start--;}
    if(size < 0){size = data.length - 1;}
    if(Math.abs(end-start) == 1){resize(data);}
    if(end == data.length){end = 0;}
    data[start] = element;
    size++;
  }
  public E removeFirst(){
    if(size == 0){throw new NoSuchElementException();}
    E result = getFirst();
    data[end] = null;
    end--;
    size--;
    return result;
  }
  public E removeLast(){
    if(size == 0){throw new NoSuchElementException();}
    E result = getLast();
    data[start] = null;
    start--;
    size--;
    return result;
  }
  public E getFirst(){
    if(size == 0){throw new NoSuchElementException();}
    return data[end];
  }
  public E getLast(){
    if(size == 0){throw new NoSuchElementException();}
    return data[start];
  }

  public static void main(String args[]){
    MyDeque<Integer> deque = new MyDeque<>();
    deque.addFirst(10);
    System.out.println(deque);
  }
}
