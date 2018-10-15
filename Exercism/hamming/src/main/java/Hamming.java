//Tính số ký tự khác nhau của 2 DNA

class Hamming {
    String dna1;
    String dna2;
    Hamming(String leftStrand, String rightStrand)throws IllegalArgumentException {

        //ngoại lệ DNA1 có độ dài lớn hơn DNA2
        if(leftStrand.length()>rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        //ngoại lệ DNA1 có độ dài nhỏ hơn DNA2
        if(leftStrand.length()<rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.dna1=new String(leftStrand);
        this.dna2=new String(rightStrand);
    }

    int getHammingDistance() {
        int countDistance=0;

        //nếu dna1 giống dna2
        if(dna1.equals(dna2)==true)
            return countDistance;

        //nếu dna 1 và dna2 rỗng  
        if(dna1.equals("")==true && dna2.equals("")==true)
            return countDistance;

        char[]tmp1=dna1.toCharArray();
        char[]tmp2=dna2.toCharArray();

        //duyệt và so sánh 2 chuỗi dna với nhau
        for(int i=0;i<tmp1.length;i++){
            if(tmp1[i]!=tmp2[i]){
                countDistance++;
            }
        }

        return countDistance;
    }

}
