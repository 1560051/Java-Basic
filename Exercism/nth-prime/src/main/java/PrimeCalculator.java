//liệt kê tất cả số nguyên tố đến n
//trả về số nguyên tố thứ n
//vd: input:6 {2,3,5,7,11,13} =>số nguyên tố thứ 6 là 13

class PrimeCalculator {

    int nth(int nth) {
        //nếu số <=0 
        if(nth<=0){
            throw new IllegalArgumentException();
        }

        int lastPrime=0;
        int count=0;

        //duyệt tất cả số nguyên tới nth
        for(int i=0;true;i++){
            if(count==nth)
                break;

            //nếu là số nguyên tố
            if(isPrime(i)==true) {
                lastPrime=i;
                count++;
            }
        }
        return lastPrime;
    }

    //funtion kiểm tra số nguyên tố
    boolean isPrime(int n){
        if(n<=1)
            return false;

        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

}
