public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){  }
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
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
