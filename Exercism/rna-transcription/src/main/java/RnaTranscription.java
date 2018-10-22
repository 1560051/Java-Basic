//Chuyền chuỗi DNA thành RNA
class RnaTranscription {

    String transcribe(String dnaStrand) {
        char[] c=dnaStrand.toCharArray();
        for(int i=0;i<c.length;i++){

            if(c[i]=='G')
                c[i]='C';

            else if(c[i]=='C')
                c[i]='G';

            else if(c[i]=='T')
                c[i]='A';

            else if(c[i]=='A')
                c[i]='U';

        }
        String str= new String(c);
        return str;
    }

}
