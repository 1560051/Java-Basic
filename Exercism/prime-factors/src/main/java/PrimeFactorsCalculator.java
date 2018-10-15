//Đề: cho số tự nhiên n
//tìm danh sách các thừa số của n sao cho tích của chúng bằng n
//vd: 30= 2*3*5 => [2,3,5]
//    60=2*2*3*5 =>[2,2,3,5]



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactorsCalculator {
    public static List<Long> calculatePrimeFactorsOf(long number){
        List<Long> primeFactors= new ArrayList<Long>();
        //trường hợp 1 không thì trả về list rỗng
        if(number==1)
            return Collections.emptyList();

        //2 thì trả về list chứa 2
        if(number==2){
            primeFactors.add(2l);
            return primeFactors;
        }
        else{
            //tích các lũy thừa của n
            long factor=1;
            long temp=number;
            //tìm các lũy thừa của n và sau đó thêm nó vào list
            for(long l=2;;){
                //nếu l là lũy thừa của n
                if(temp%l==0){
                    primeFactors.add(l);
                    temp/=l;
                    factor*=l;
                }
                //nếu l không phải là lũy thừa của n
                else if(temp%l!=0)
                    l++;
                // nếu tích lũy thừa bằng n
                if(factor==number){
                    return primeFactors;
                }
            }
            return primeFactors;
        }
    }
}
