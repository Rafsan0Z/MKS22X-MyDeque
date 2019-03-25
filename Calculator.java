public class Calculator{


  public static double eval(String s){
    double result = 0;
    Scanner read  = new Scanner(s);
    int one = 0;
    int two = 0;
    while(read.hasNext()){
      String line = read.next();
      if(Operator(line)){
        result += Operate(one,two,line);
      }
      else{
        if(one == 0){one = Integer.parseInt(line);}
        if(two == 0){two = Integer.parseInt(line);}
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

  private static int Operate(int one, int two, String line){

  }


}
