//The ISBN-10 format is 9 digits (0 to 9) plus one check character (either a digit or an X only).
//In the case the check character is an X, this represents the value '10'. 

//vd: ISBN-10 3-598-21508-8 
//(3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 * 1) mod 11 == 0
class IsbnVerifier {

    IsbnVerifier(){

    }

    boolean isValid(String stringToVerify) {
         stringToVerify=stringToVerify.replace("-","");

        //nếu 9 ký tự đầu đều là số
        try {
            Integer.parseInt( stringToVerify.substring(0,9));
        }
        //nếu có có ký tự k hợp lệ =>false
        catch( Exception e) {
            return false;
        }

        //Nếu độ dài của chuỗi khác 10 và ký tự cuối không phải là số và khác 'X'
        if (stringToVerify.length() != 10 ||
                ((stringToVerify.charAt(stringToVerify.length()-1)!= 'X'
                && stringToVerify.charAt(stringToVerify.length()-1)>'9')))
            return false;

        

        int sum = 0;

        //duyệt từng ký tự trong chuỗi chuyển sang kiểu số và tính theo công thức 
        for (int i = 0, j = 10; i < stringToVerify.length(); i++, j--) {
            if (stringToVerify.charAt(i) <= '9' && stringToVerify.charAt(i) >= '0') {
                sum += Character.getNumericValue(stringToVerify.charAt(i)) * j;
            }

            //Nếu ký tự cuối là số
            else if (i==9 && stringToVerify.charAt(9)<9 && stringToVerify.charAt(9)>0){
                sum+=Character.getNumericValue(stringToVerify.charAt(9));
            }

            //Nếu ký tự cuối là X => chuyển sang int
            else if(i==9){
                String tmp = stringToVerify.toLowerCase();
                sum += tmp.charAt(9);;
            }
        }

        //nếu tổng chia hết cho 11 thì là mã ISBN
        if (sum % 11 == 0)
            return true;
        return false;
    }

}
