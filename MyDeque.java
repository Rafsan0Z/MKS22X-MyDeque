import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    if(initialCapacity <= 0){
      throw new IllegalArgumentException();
    }
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String result = "{";
    for(int i = 0; i < size; i++){
      result = data[i] + " ";
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
    end++;
    if(end == data.length){end = 0;}
    if(Math.abs(end-start) == 1){resize(data);}
    data[end] = element;
    size++;
  }
  public void addLast(E element){
    if(element == null){throw new NullPointerException();}
    start--;
    if(size < 0){size = data.length - 1;}
    if(Math.abs(end-start) == 1){resize(data);}
    if(end = data.length){end = 0;}
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
}
