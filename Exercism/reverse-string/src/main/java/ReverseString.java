
//Đảo ngược chuỗi 
class ReverseString {

    String reverse(String inputString) {
        StringBuilder sb= new StringBuilder(inputString);
        sb.reverse();
        inputString = sb.toString();
        return inputString;
    }
  
}