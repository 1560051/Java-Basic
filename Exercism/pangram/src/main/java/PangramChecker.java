//Chuỗi Pangram là chuỗi mà tất cả các 
//ký tự trong bảng chữ cái đều xuất hiện trong chuỗi

public class PangramChecker {

    public boolean isPangram(String input) {
       
       //tạo chuỗi boolean có độ dài bằng 
       //26 ký tự trong bảng chữ cái
        boolean[] mark = new boolean[26]; 
  
 
        int index = 0; 
  
        // Duyệt toàn bộ ký tự trong chuỗi 
        for (int i = 0; i < input.length(); i++) 
        { 
            //nếu ký tự là chữ In
            if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') 
                          
                //-A để tính index trong mảng boolean
                index = input.charAt(i) - 'A'; 

            else if('a' <= input.charAt(i) && input.charAt(i) <= 'z') 
       
                index = input.charAt(i) - 'a'; 

            mark[index] = true; 
        } 

        //duyệt toàn bộ mảng boolean 
        //nếu tất cả đều true thì đó là Pangram
        for (int i = 0; i <= 25; i++) 
            if (mark[i] == false) 
                return (false); 
  
        return (true);
    }

}
