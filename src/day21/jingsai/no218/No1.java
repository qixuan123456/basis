package day21.jingsai.no218;

public class No1 {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }
    public static String interpret(String command) {
        StringBuilder stringBuilder =new StringBuilder();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='G'){
                stringBuilder.append('G');
            }else if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')'){
                    stringBuilder.append('o');
                    i++;
                }
                else {
                    stringBuilder.append("al");
                    i += 2;
                }
            }
        }
        return stringBuilder.toString();
    }
}
