//Tính tổng bình phương của 1 số (từ 1 tới n)
//và bình phương của 1 tổng (từ 1 tới n)
//Tính khoảng cách giữa chứng

class DifferenceOfSquaresCalculator {

    //tổng bình phương
    int computeSquareOfSumTo(int input) {
        if(input==1)
            return 1;

        else{
            int sum=0;
            for(int i=1;i<=input;i++){
                sum+=i;
            }
            return sum*sum;
        }
    }

    //bình phương của tổng
    int computeSumOfSquaresTo(int input) {
        if(input==1)
            return 1;
        else{
            int sum=0;
            for(int i=1;i<=input;i++){
                sum+=i*i;
            }
            return sum;
        }
    }

    int computeDifferenceOfSquares(int input) {
        if(computeSquareOfSumTo(input)>computeSumOfSquaresTo(input))
            return computeSquareOfSumTo(input)-computeSumOfSquaresTo(input);
        else
            return computeSquareOfSumTo(input)-computeSumOfSquaresTo(input);
    }

}
