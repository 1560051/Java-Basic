//cho số n ban đầu cứ chia cho 2 cho tới khi không chia hết
//thì 3*n+1 sau đó tiếp tục chia 2, lặp lại cho tới khi =1

class CollatzCalculator {

    int computeStepCount(int start) {
         if(start<=0){
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }
        int i=0;
        while (true){
            if(start==1)
                return i;
            if(start%2==0){
                start/=2;
            }
            else{
                start=start*3+1;
            }
            i++;
        }
    }

}
