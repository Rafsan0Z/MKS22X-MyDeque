public class CalcDriver{
  public static void main(String[]args){
    String[] inputs = {
      //a big pile of single operation tests
      "1 1 +",
      "6 4 -",
      "3 3 -",
      "1 -1 +",
      "5.4 -1 +",
      "5.4 3.3 +",
      "9 2 *",
      "9 -2 *",
      "10 .1 *",
      ".3 4 *",
      "9 2 /",
      "-8 -16 /",
      "-9 9 /",
      "3 -12 /",
      "5 4 %",
      "9 9 %",
      "0 4 %",
      //k's tests from his website
      "10 2.0 +",
      "11 3 - 4 + 2.5 *",
      "8 2 + 99 9 - * 2 + 9 -",
      "1 2 3 4 5 + * - -",
      //more than ten operators on stack
      "4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 + + + + + + + + + + + + + + + + + + + + + + + + + +",
      "2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 * / * / * / * / * / * / * / * / * / *"
      //
    };
    double[] outputs = {
      2,2,0,0,4.4,8.7,18,-18,1,1.2,4.5,.5,-1,-.25,1,0,0,12,30,893,26,108,1
    };
    int passed = 0;
    for(int i=0;i<inputs.length;i++){
      double testOut = Calculator.eval(inputs[i]);
      if(testOut == outputs[i]){
        System.out.println("PASS test case "+i+": "+inputs[i]+" == "+testOut);
        passed++;
      }else{
        System.out.println("FAIL test case "+i+": "+inputs[i]+" == "+outputs[i]+", returned "+testOut);
      }
    }
    System.out.println("\n"+(100.0*passed/outputs.length)+"%: "+passed+" of "+outputs.length+" test cases passed");
  }
}
