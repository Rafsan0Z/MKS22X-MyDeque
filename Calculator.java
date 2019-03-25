public class Calculator{


  public static double eval(String s){
    Scanner read  = new Scanner(s);
    while(read.hasNext()){
      String line = read.next();
      if(Operator(line)){

      }
    }
  }

  private static boolean Operator(String g){
    if(g == "+" || g == "-" || g == "%" || g == "*" || g == "/"){
      return true;
    }
    else{return false;}
  }


}
