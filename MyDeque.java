import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end, capacity;

  public MyDeque(){
    this(10);
  }
  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    @SuppressWarnings("unchecked")
    E[] New = (E[]) new Object[initialCapacity];
    data = New;
    size = 0;
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
    for(int i = start; i < capacity; i++){
      result += data[i] + " ";
      if(i == end){
        finished = true;
        i = capacity;
      }
    }
    if(!finished){
    for(int i = 0; i < end; i++){
        result += data[i] + " ";
    }
  }
    return result + "}";
  }

  public void resize(){
    @SuppressWarnings("unchecked")
    E[] output = (E[])new Object[(size *2)+ 1];
    int counter = 0;
    int counter2 = output.length-1;
    if(start >= end){
      for (int i = capacity-1; i >= 0; i--) {
        output[counter2] = data[i];
        counter2--;
      }
    }
    else {
      for (int i = 0; i < end; i++){
        output[counter] = data[i];
        counter++;
      }
    }
    capacity = output.length;
    data = output;
  }
  public void addFirst(E element){
    if (element == null){ throw new NullPointerException();}
    if (start == 0){
      start = capacity-size-1;
    }
    else if (size == capacity){
      resize();
      start = 0;
    }
    else{start--;}
      data[start] = element;
      size++;
  }
  public void addLast(E element){
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
  public int getStart(){
    return start;
  }

  public int getEnd(){
    return end;
  }

  public static void main(String args[]){
    MyDeque<Integer> deque = new MyDeque<>();
    deque.addFirst(5);
    deque.addFirst(6);
    deque.addLast(10);
    System.out.println(deque);
  }
}
