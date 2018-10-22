//Tính tổng các bội số của 1 list số tự nhiên nhỏ hơn n

// Given a number, find the sum of all the unique multiples
// of particular numbers up to but not including that number.

// If we list all the natural numbers below 20 that are multiples
// of 3 or 5, we get 3, 5, 6, 9, 10, 12, 15, and 18.

// The sum of these multiples is 78.

import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {
    private int num;
    private int[]sets;

    SumOfMultiples(int number, int[] set) {
        this.num=number;
        this.sets=set;
    }

    int getSum() {

        //nếu độ dài 
        if(sets.length<=0)
            return 0;
            
        int sum=0;
        Set<Integer> mutipleSet=mutiples(sets);
        //duyệt và tính tổng bội danh sách
        for(Integer i : mutipleSet){
            sum+=i;
        }
        return sum;
    }

    //danh sách bội của 1 list
    public Set<Integer> mutiples(int[] a){
        Set<Integer> mutiple=new HashSet<Integer>();
        for(int i =0;i< sets.length;i++){
            for(int j=1;a[i]*j<num;j++){
                mutiple.add(a[i]*j);
            }
        }
        return mutiple;
    }

}
