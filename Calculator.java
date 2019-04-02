import java.util.*;
public class Calculator{


  public static double eval(String s){
    double result = 0;
    Scanner read  = new Scanner(s);
    read.useDelimiter(" ");
    MyDeque<Double> storage = new MyDeque<Double>();
    while(read.hasNext()){
      boolean test = read.hasNextDouble();
      if(!test){
        String line = read.next();
        double two = storage.removeLast();
        double one = storage.removeLast();
        result = Operate(one,two,line);
        storage.addLast(result);
      }
      else{
        double box = read.nextDouble();
        storage.addLast(box);
      }
    }
    return storage.getLast();
  }

  public static boolean isDouble(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
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
    String input = "11 3 - 4 + 2.5 *";
    double output = eval(input);
    System.out.println(output);
  }


}
