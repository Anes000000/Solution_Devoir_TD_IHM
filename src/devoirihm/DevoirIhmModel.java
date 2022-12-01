package devoirihm;
public class DevoirIhmModel{
    private int Number1=0;
    private int Number2=0;
    public void setNumbers(String number1,String number2){
        Number1=Integer.parseInt(number1);
        Number2=Integer.parseInt(number2);
    }
    public void setNumbersInt(int number1,int number2){
        Number1=number1;
        Number2=number2;
    }
      public String AddAndGetResult(){
        int ResultA=Number1+Number2;
         String Result=Integer.toString(ResultA);
        return Result;
    }
       public String SousAndGetResult() {
           int Result = Number1 - Number2;
           String FinalResult = Integer.toString(Result);
           return FinalResult;
       }
}