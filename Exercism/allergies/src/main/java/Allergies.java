// Given a person's allergy score, determine whether or not they're allergic 
//to a given item, and their full list of allergies.
// An allergy test produces a single numeric score which contains the information 
//about all the allergies the person has (that they were tested for).
// The list of items (and their value) that were tested are:

// eggs (1)
// peanuts (2)
// shellfish (4)
// strawberries (8)
// tomatoes (16)
// chocolate (32)
// pollen (64)
// cats (128)

//vd:
//nếu allergy score = 3 => 2+1 [egg, peanut]]]


import java.util.*;

public class Allergies {
    private int allergyScore;

    //255 là số điểm tối đa mà có tất cả các Allergen
    Allergies(int number){
        if(number>255){
            while (number>255)
                number-=255;
        }

        this.allergyScore=number;
    }

// funtion kiểm tra loại Allergen mà obj hiện tại có tồn tại
    public boolean isAllergicTo(Allergen allergen){
        //nếu số điểm Allergy = với loại allergen
        if(allergen.getScore()==allergyScore)
            return true;

        //nếu Alergen cần kiểm tra vượt quá số điểm 
        if(allergen.getScore()>this.allergyScore)
            return false;

        //trường hợp nếu hợp lệ
        if(allergen.getScore()<this.allergyScore){
            Allergen[] allergens=Allergen.values();
            int scoreRemaining=this.allergyScore;

            //duyệt tất cả các Alergen cho tới khi giá trị của Alergen <= với điểm 
            for(int i=7;i>=0;i--){
                if(allergens[i].getScore()<=scoreRemaining){
                    //nếu trùng đồng thời số điểm lớn hơn loại Alergen đó
                    if(allergens[i].getScore()<=scoreRemaining
                       && allergens[i]==allergen)
                        return true;

                    //nếu lượng điểm còn lại quá thấp so với Alergen
                    if(allergen.getScore()>scoreRemaining)
                        return false;

                    scoreRemaining-=allergens[i].getScore();
                }
            }
        }

        return false;
    }

    //Lấy danh sách Allergen
    public List<Allergen> getList() {
        List<Allergen> allergiesList = new ArrayList<Allergen>();
        Allergen[] allergens = Allergen.values();
        int scoreRemaining = this.allergyScore;

        //duyệt tất cả các Alergen và thêm vào array nếu phù hợp
        for (int i = 7; i >= 0; i--) {
            if (allergens[i].getScore() <= scoreRemaining) {
                allergiesList.add(allergens[i]);
                scoreRemaining -= allergens[i].getScore();
            }
        }

        return allergiesList;
    }

}


