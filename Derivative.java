import java.util.Scanner;
//for now let's have this just in case we need it.
public class Derivative{
  public static void main(String[] args) {
    System.out.println("Hello world");
    Double a;
    Double b;
    char opp = '+';
    String function = "";
    String durr;
    //durr is short for derivative. I thought it'd be funny to spell it like that.
    while (opp != '0'){
      System.out.println("enter the coeffiecient");
      a = TextIO.getlnDouble();
      System.out.println("enter the exponent");
      b = TextIO.getlnDouble();
      durr =  powerRule(a,b);
      function = function + durr;
      //pieces together a derivative function term by term.
      System.out.println("enter the next opperator or 0 to stop.");
      opp = TextIO.getlnChar();
      //asks for the opperator to sepperate the terms. IF we want to go through with this then we need to have it do different things for different opperators.
      if(opp !='0' && durr != ""){
        //0 must be in single quotes because it's a char.
        function = function + " " + opp + " ";
        //doesn't add anything if the opperator is 0 (end command) or if the derivative isn't actually a thing.
      }
    }
    System.out.println(function);
  }
  public static String powerRule(Double a,Double b){
    a = a * b;
    b = b-1;
    String d = "";
    String coeff = "" + a;
    if(b != 0.0){
      d = "^"+b;
    }
    else{
      d = "";
    }

    String derivative;
    if(a == 0.0){
      derivative = "";
      //if the derivative of that term is 0 then it returns an empty string.
    }
    else{
      if(b !=0){
        derivative = coeff + "x"+d;
      }
      else{
        derivative = coeff;
        //just returns the coeffiecient if the exponent is 0.
      }
    }
    return derivative;
  }
}
