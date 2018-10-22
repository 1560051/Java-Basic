//Tìm số nguyên tố qua thuật toán Sieve

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sieve {
    private int number;

    Sieve(int maxPrime) {
        this.number=maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<Integer>();
        if(number<2)
            return primes= Collections.emptyList();
        
        boolean[] check=new boolean[number+1];
        for(int i=2;i<=number;i++){
            if(check[i]==false){
                for(int j=2*i;j<=number;j+=i){
                    check[j]=true;
                }
            }

        }
        for(int i=2;i<=number;i++){
            if(check[i]==false)
                primes.add(i);
        }
        return primes;
    }
}
