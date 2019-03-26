public class Calculator{


  public static double eval(String s){
    double result = 0;
    Scanner read  = new Scanner(s);
    MyDeque<Double> storage = new MyDeque<Double>();
    int one = 0;
    int two = 0;
    while(read.hasNext()){
      String line = read.next();
      if(Operator(line)){
        result += Operate(one,two,line);
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
  }


}
