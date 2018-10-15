//có các loại protein sau:
// Codon	            Protein
//-----------------------------------
// AUG	                Methionine
// UUU, UUC	            Phenylalanine
// UUA, UUG	            Leucine
// UCU, UCC, UCA, UCG	Serine
// UAU, UAC	            Tyrosine
// UGU, UGC	            Cysteine
// UGG	                Tryptophan
// UAA, UAG, UGA	    STOP

//input 1 chuỗi DNA trả ra 1 danh 
//sách các protein có trong đó

import java.util.*;

class ProteinTranslator {

     ProteinTranslator(){

    }

    List<String> translate(String rnaSequence) {
        List<String> lS = new ArrayList<String>();

        //lấy mảng protein của Enum Protein
        Protein[] proteins=Protein.values();

        //duyệt toàn bộ ký tự và tách 3 ký tự 
        //rồi so sánh với các protein trong danh sách
        for(int i=0,j=3;j<=rnaSequence.length();i+=3,j+=3){
            String tmp=rnaSequence.substring(i,j);
            for (Protein p: proteins){
                String s=p.getName();

                //nếu chuỗi 3 ký tự có trong mảng protein
                if(tmp.equals(p.toString())==true) {
                    lS.add(p.getName());
                    break;
                }
            }
        }

        //khử các protein bị trùng trong ArrayList
        Set<String> hs=new HashSet<String>();
        hs.addAll(lS);
        lS.clear();
        lS.addAll(hs);
        return  lS;
    }
}