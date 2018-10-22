//Số Armstrong  
//
//vd: 153= 1^3 + 5^3 + 3^3 = 153 =>true
//9= 9^1 =>true
//10=1^2 +0^2 =1 =>false
class ArmstrongNumbers {
	boolean isArmstrongNumber(int numberToCheck) {
        //số có 1 chữ số chắc chắc là số amstrong
		if(numberToCheck<10 && numberToCheck>0){
            return true;
        }

        else{
            int result=0;
            int count=0;
            
            //đếm số lượng chữ số
            for(int n = numberToCheck;n>0;n/=10){
                count++;
            }

            //tính tông lũy thừa các chữ số
            for(int n=numberToCheck;n>0;n/=10){
                result+=expoential(n%10,count);
            }
            if(result==numberToCheck){
                return true;
            }
            else{
                return false;
            }
        }

    }

    //hàm tính a^n
    int expoential(int a,int n){
        if(a==1){
            return 1;
        }

        if(a==0){
            return 0;
        }

        int result=a;
        for(int i=1;i<n;i++){
            result*=a;
        }
        return result;
    }

}
