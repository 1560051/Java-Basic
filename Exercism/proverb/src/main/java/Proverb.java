// Given a list of inputs, generate the relevant proverb. For example, given the list ["nail", "shoe", "horse", "rider", "message", "battle", "kingdom"], you will output the full text of this proverbial rhyme:

// For want of a nail the shoe was lost.
// For want of a shoe the horse was lost.
// For want of a horse the rider was lost.
// For want of a rider the message was lost.
// For want of a message the battle was lost.
// For want of a battle the kingdom was lost.
// And all for the want of a nail.

class Proverb {

    private String[] listWord;
    Proverb(String[] words) {
        this.listWord=words;
    }

    String recite() {
        if(listWord==null)
            return "";

        //Duyệt phần toàn bộ phần tử mảng
        String s= new String();
        for(int i=0;i<listWord.length;i++){

            //chưa phải phần tử cuối
            if(i!=listWord.length-1){
                s+="For want of a " + listWord[i] + " the " +listWord[i+1] + " was lost.\n";
            }
            //Khi duyệt tới phần tử cuối cùng
            else
                s += "And all for the want of a " + listWord[0] + ".";

        }
        return s;
    }
}


