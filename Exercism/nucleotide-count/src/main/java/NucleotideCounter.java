//Có 4 loại nucleotic: A C G T
//Viết hàm sao cho chuỗi DNA sau đó đếm số lượng các loại 
//nucleotic có trong chuỗi đó
//vd: 
//NucleotideCounter = new NucleotideCounter("AACG"")
//Trả ra [('A',2),
//        ('B',1),
//        ('C',1),            
//        ('D',0)]
//


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NucleotideCounter {
    private String dna;

    NucleotideCounter(String dnaString){
        this.dna=dnaString;
    }

    public Map<Character, Integer> nucleotideCounts() extends Exception{

        //Tạo HashMap nucleotic
        Map<Character,Integer> nucleotide=new HashMap<Character, Integer>();
        nucleotide.put('A',0);
        nucleotide.put('C',0);
        nucleotide.put('G',0);
        nucleotide.put('T',0);


        Set<Character> nameNucleotide = nucleotide.keySet();
        //duyệt theo key trong danh sách nucleotic
        for(Character key:nameNucleotide){
            int count =0;
            //duyệt chuỗi DNA và so sánh từng ký tự với nucleotic
            for(int i=0;i<dna.length();i++){
                //trường hợp chưas ký tự không hợp lệ
                if(dna.charAt(i)!=65 && dna.charAt(i)!=67
            && dna.charAt(i)!= 84 && dna.charAt(i)!=71)
                 throw new Exception();
                //Nếu chuỗi xuất hiện trong danh sách nucleotic
                if(key == dna.charAt(i))
                    count++;
            }
            nucleotide.put(key,count);
        }

        return nucleotide;
    }
}
