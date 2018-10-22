//chuỗi isogram là chuỗi mà các ký tự trong chuỗi đó là duy nhất
//vd: isogram : không có ký tự nào lặp lại 2 lần

class IsogramChecker {
    IsogramChecker(){

    }

    //nếu chuỗi rỗng
    boolean isIsogram(String phrase) {
        if(phra se=="")
            return true;

        phrase = phrase.toLowerCase();

        //duyệt từng ký tự trong chuỗi và so sánh với các ký tự sau nó
        for (int i = 0; i < phrase.length()-1; i++) {

            //nếu có chứa khoảng trắng hoặc - thì bỏ qua
            if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
                continue;
            }
            for (int j = i + 1; j < phrase.length(); j++) {

                //nếu có ký tự nào lặp lại
                if (phrase.charAt(i) == phrase.charAt(j))
                    return false;
            }
        }
        return true;
    }

}
