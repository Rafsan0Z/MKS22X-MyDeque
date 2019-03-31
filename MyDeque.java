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
    int counter = 0;
    boolean finished = false;
    @SuppressWarnings("unchecked")
    E[] output = (E[])new Object[capacity*2];
    for(int i = start; i < capacity; i++){
      output[counter] = data[i];
      if(i == end){
        finished = true;
        i = capacity;
      }
      counter++;
    }
    if(!finished){
    for(int i = 0; i <= end; i++){
      output[counter] = data[i];
    }
  }
    data = output;
    end = counter;
    capacity = capacity*2;
    start = 0;
  }
  public void addFirst(E element){
    if(start == 0){
      start = capacity - 1;
      data[start] = element;
      size++;
    }
    else{
      if(end == start - 1){
        resize();
        data[start] = element;
        size++;
        return;
      }
      start--;
      data[start] = element;
      size++;
    }
  }
  public void addLast(E element){
    if(end == 0){

    }
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
    int limit = 5;
    System.out.println(" " + deque.getStart() + ", " + deque.getEnd());
    deque.addFirst(5);
    System.out.println(" " + deque.getStart() + ", " + deque.getEnd());
    deque.addFirst(6);
    System.out.println(" " + deque.getStart() + ", " + deque.getEnd());
    deque.addFirst(8);
    System.out.println(" " + deque.getStart() + ", " + deque.getEnd());
    System.out.println(deque);
  }
}
