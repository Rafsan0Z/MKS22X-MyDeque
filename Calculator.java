import java.util.*;
public class Calculator{


  public static double eval(String s){
    double result = 0;
    Scanner read  = new Scanner(s);
    read.useDelimiter("");
    MyDeque<Double> storage = new MyDeque<Double>();
    while(read.hasNext()){
      String line = read.next();
      if(Operator(line)){
        double one = storage.removeFirst();
        double two = storage.removeFirst();
        result = Operate(one,two,line);
        if(read.hasNext()){line = read.next();}
      }
      else{
        double box = Double.parseDouble(line);
        storage.addFirst(box);
        if(read.hasNext()){line = read.next();}
      }
      System.out.println(storage);
    }
    return result;
  }

  private static boolean Operator(String g){
    if(g.equals("+") || g.equals("-") || g.equals("%") || g.equals("*") || g.equals("/")){
      return true;
    }
    else{return false;}
  }

  private static double Operate(double one, double two, String line){
    if(line.equals("*")){return one * two;}
    if(line.equals("-")){return one - two;}
    if(line.equals("+")){return one + two;}
    if(line.equals("/")){return one / two;}
    if(line.equals("%")){return one % two;}
    return -1;
  }

  public static void main(String args[]){
    String input = "1 -2 +";
    double output = eval(input);
    System.out.println(output);
  }


}
