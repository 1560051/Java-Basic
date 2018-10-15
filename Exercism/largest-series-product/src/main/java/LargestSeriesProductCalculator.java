//Đề: Cho chuỗi gồm 1 dãy số nguyên, tính tích n chữ số lớn nhất trong dãy
// vd:s="1234" n=3 => max=2*3*4


class LargestSeriesProductCalculator {
    private String numberString;

    LargestSeriesProductCalculator(String inputNumber) {

        //Nếu chuỗi có chứa ký tự không phải là số nguyên
        if(inputNumber.matches("\\d+")==false && inputNumber!=""){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        else {
            this.numberString = inputNumber;
        }
    }

    //funtion tính tích n số lượng chữ số lớn nhất
    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        //nếu số lượng chữ số cần tính bằng 0
        if(numberOfDigits == 0){
            return 1;
        }

        //trường hợp số lượng chữ số(n) vượt quá độ dài chuỗi
        else if(numberOfDigits>this.numberString.length()){
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to" +
                            " the length of the string to search.");
        }

        //trường hợp số lượng chữ số truyền vào là >0
        else if(numberOfDigits<0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        else {
            int max = 0;

            //tách các chuỗi thành n ký tự
            for (int i = 0; i <= this.numberString.length() - numberOfDigits; i++) {
                String str = this.numberString.substring(i, i + numberOfDigits);
                int sum = 1;

                //tính tích các ký tự đã tính
                for (int j = 0; j < str.length(); j++) {
                    sum *= Character.getNumericValue(str.charAt(j));
                }
                if (sum > max)
                    max = sum;
            }
            return max;
        }
    }
}
