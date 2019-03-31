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
    E[] output = (E[])new Object[(capacity + 1) * 2];
    int index;
    int counter = 0;
    for(index = start; index != end; index++){
      output[counter] = data[index];
      counter++;
      if(index >= capacity){index = 0;}
    }
    if (size != 0){output[counter] = data[index];}
    data = output;
    start = 0;
    end = counter;
    capacity = output.length;
  }
  public void addFirst(E element){
    if(element == null){throw new NullPointerException();}
    if(size != 0){end++;}
    if(end == capacity){end = 0;}
    if(start - end == 1){resize();}
    else if(start == 0){resize();}
    else if(capacity-1 <= end){resize();}
    data[end] = element;
    size++;
  }
  public void addLast(E element){
    if (element == null){throw new NullPointerException();}
    if (size != 0){start--;}
    if (start < 0){start = capacity-1;}
    if (start - end == 1 || (start == 0 && end == data.length-1) || data.length == 0){resize();}
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
