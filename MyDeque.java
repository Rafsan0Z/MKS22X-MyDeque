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
  public void resize(E[] input){
    data = new E[size+1];
    size++;
    for(int i = start; i <= end; i++){
      data[i] = input[i];
    }
  }
  public void addFirst(E element){
    data[start+1] = element;
    start++;
  }
  public void addLast(E element){
    data[end+1] = element;
    end++;
  }
  public E removeFirst(){
    data[start] = null;
    start--;
  }
  public E removeLast(){
    data[end] = null;
    end--;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
