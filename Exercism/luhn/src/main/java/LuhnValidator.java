
//4539 1488 0343 6467

//The first step of the Luhn algorithm is to double every second digit
//, starting from the right. We will be doubling
//4_3_ 1_8_ 0_4_ 6_6_

//If doubling the number results in a number greater than 9 
//then subtract 9 from the product. The results of our doubling:
//8569 2478 0383 3437

//Then sum all of the digits:
//8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80

//If the sum is evenly divisible by 10, then the number is valid. This number is valid!

class LuhnValidator {

    boolean isValid(String candidate) {
        //bỏ ký tự khoảng trắng
        candidate=candidate.replace(" ","");

        //nếu đôj dài <2
        if(candidate.length()<2)
            return false;
        int sum=0;
        
        //duyệt từng ký tự từ phải sang cách nhau 1 ký tự 
        //và *2 sau đó cộng tất cả lại
        for(int i=candidate.length()-2,j=i+1;i>=0;i=i-2,j=j-2){

            //Nếu 1 ký tự không phải là số
            if(Character.isDigit(candidate.charAt(i))==false
                    ||Character.isDigit(candidate.charAt(j))==false)
                return false;

            //nếu số *2 > 9 thì trừ cho 9
            if(Character.getNumericValue(candidate.charAt(i))*2>9)
                sum+=Character.getNumericValue(candidate.charAt(i))*2-9;

            //nếu *2 < 9 thì cộng lại
            else if(Character.getNumericValue(candidate.charAt(i))*2<9)
                sum+=Character.getNumericValue(candidate.charAt(i))*2;

            sum+=Character.getNumericValue(candidate.charAt(j));
        }

        //nếu tổng tất car số chia hết cho 10
        if(sum%10==0)
            return true;
        return false;
    }

}
