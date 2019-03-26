public class Calculator{


  public static double eval(String s){
    double result = 0;
    Scanner read  = new Scanner(s);
    MyDeque<Double> storage = new MyDeque<Double>();
    while(read.hasNext()){
      String line = read.next();
      if(Operator(line)){
        double one = storage.removeFirst();
        double two = storage.removeFirst();
        result == Operate(one,two,line);
      }
      else{
        double box = Double.parseDouble(line);
        storage.addFirst(box)
      }
    }
    return result;
  }

  private static boolean Operator(String g){
    if(g == "+" || g == "-" || g == "%" || g == "*" || g == "/"){
      return true;
    }
    else{return false;}
  }

  private static int Operate(double one, double two, String line){
    if(line == "*"){return one * two;}
    if(line == "-"){return one - two;}
    if(line == "+"){return one + two;}
    if(line == "/"){return one / two;}
    if(line == "%"){return one % two;}
    return -1;
  }


}
