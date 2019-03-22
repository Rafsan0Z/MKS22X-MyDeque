public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked");
    data = new E[10];
    size = 0;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    if(initialCapacity <= 0){
      throw new IllegalArgumentException();
    }
    @SuppressWarnings("unchecked");
    data = new E[initialCapacity];
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
    data = new E[size+1];
    size++;
    for(int i = start; i < input.length; i++){
      data[i] = input[i];
    }
    for(int i = 0; i <= end; i++){
      data[i] = input[i];
    }
  }
  public void addFirst(E element){
    if(element == null){throw new NullPointerException();}
    end++;
    if(Math.abs(end-start) == 1){resize(data);}
    if(end == data.length){end = 0;}
    data[end] = element;
    size++;
  }
  public void addLast(E element){
    if(element == null){throw new NullPointerException();}
    start--;
    if(end = data.length){end = 0;}
    data[start] = element;
    size++;
  }
  public E removeFirst(){
    if(size == 0){throw new NoSuchElementException();}
    data[start] = null;
    start--;
  }
  public E removeLast(){
    if(size == 0){throw new NoSuchElementException();}
    data[end] = null;
    end--;
  }
  public E getFirst(){
    if(size == 0){throw new NoSuchElementException();}
    return data[start];
  }
  public E getLast(){
    if(size == 0){throw new NoSuchElementException();}
    return data[end];
  }
}
