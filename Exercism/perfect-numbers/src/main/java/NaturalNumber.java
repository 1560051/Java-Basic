//input: 1 số nguyên kiểm tra đó là loại số gì
//Gồm:
//PERFECT: tổng ước bằng chính nó
//DEFICIENT: tổng ước lớn hơn nó
//ABUNDANT: tổng ước nhỏ hơn nó

class NaturalNumber {  

    private int number;

    NaturalNumber(int num)throws IllegalArgumentException{

        if(num<=0){
            throw new IllegalArgumentException
            ("You must supply a natural number (positive integer)");
        }
        this.number=num;
    }


    public Classification getClassification(){
        //1 2 3 là DEFICIENT
        if(number==1||number==2||number==3)
            return Classification.DEFICIENT;

        else{
            int sum=1;
            
            //tính tổng ước
            for(int i=2;i<=number/2;i++){
                if(number%i==0){
                    sum+=i;
                }
            }

            if(sum==number)
                return Classification.PERFECT;

            else if(sum>number)
                return Classification.ABUNDANT;

            else
                return  Classification.DEFICIENT;
        }
    }
}
