public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){ 
    data = new E[10];
    size = 10;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){ 
    data = new E[initialCapacity];
    size = initialCapacity;
    start = 0;
    end = 0;
  }
  public int size(){ }
  public String toString(){
    String result = "{";
    for(int i = 0; i < size; i++){
      result = data[i] + " ";
    }
    return result + "}";
  }
  public void resize(){}
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
