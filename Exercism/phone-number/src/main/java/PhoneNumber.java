//Chuẩn hóa số điện thoại


public class PhoneNumber {
    private String phoneNumber;

    PhoneNumber(String number){
        this.phoneNumber=number;
    }

    String getNumber(){
        String s=phoneNumber;
        //nếu số đầu tiên là 1
        if(s.charAt(0)=='1' && s.charAt(1)==' ')
            throw new IllegalArgumentException();

        s=s.replaceAll("[^0-9]","");

        //nếu độ dài sdt <10
        if(s.length()<10)
            throw new IllegalArgumentException("Number must be 10 or 11 digits");

        //nếu độ dài = 11 và có số 1 đầu tiên
        if(s.length()==11&&s.charAt(0)=='1')
            s=s.substring(1,s.length());

        //độ dài lớn hơn = 11 và ký tự đầu tiên khác 1
        else if(s.length()>=11&&s.charAt(0)!='1')
            throw new IllegalArgumentException();

        //ký tự đầu bằng 0
        else if(s.charAt(0)=='0')
            throw new IllegalArgumentException();

        //ký tự đầu = 1 và độ dài = 10
        else if(s.charAt(0)=='1'&&s.length()==10)
            throw new IllegalArgumentException();
        return s;
    }
}

