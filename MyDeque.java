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
    int index;
    for(index = start; index != end;){
      result += data[index] + " ";
      index++;
      if(index >= capacity){index = 0;}
    }
    if(size > 0){result += data[end] + " ";}
    return result + "}";
  }

  public void resize(){
    @SuppressWarnings("unchecked")
    E[] output = (E[])new Object[capacity+1];
    int index = start;
    int counter = 0;
    while(index != end){
      output[counter] = data[index];
      counter++;
      index++;
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
    addCheck();
    data[end] = element;
    size++;
  }
  public void addLast(E element){
    if (element == null){throw new NullPointerException();}
    AddCheck();
    data[start] = element;
    size++;
  }
  public E removeFirst(){
    if(size == 0){throw new NoSuchElementException();}
    E result = getFirst();
    data[end] = null;
    RemoveEnd();
    return result;
  }

  public E removeLast(){
    if(size == 0){throw new NoSuchElementException();}
    E result = getLast();
    data[start] = null;
    RemoveStart();
    return result;
  }

  public void RemoveStart(){
    if(size != 1){
      if(start+1 != capacity){start++;}
      else{start = 0;}
    }
    size--;
  }

  public void addCheck(){
    if(size != 0){end++;}
    if(end == capacity){end = 0;}
    if(start - end == 1){resize(); return;}
    else if(start == 0){resize(); return;}
    else if(capacity-1 <= end){resize();}
  }

  public void AddCheck(){
    if (start - end == 1 || (start == 0 && end == data.length-1) || data.length == 0){resize();}
    if (size != 0){start--;}
    if (start == -1){start = capacity-1;}
  }

  public void RemoveEnd(){
    if(size != 1){end = capacity - 1;}
    else if(end != 0){end--;}
    size--;
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
    for(int i = 1; i < 12; i++){
      //deque.addFirst(i);
      deque.addLast(i);
    }
    System.out.println(deque);
  }
}
