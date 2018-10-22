//Đề: Kiểm tra cú pháp đóng mở ngoặc của chuỗi đã cho
//vd: "[({})]" ==> true
//     "(1+2)+(2+[[2])"  ==> false
public class BracketChecker {
    private String string;

    BracketChecker(String inputString) {
        string = inputString;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {

        //thay thế tất cả các ký tự không phải là dấu ngoặc.
        String reducedString = string.replaceAll("[^\\[\\]{}()]", "");

        //Kiểm tra có tồn tại của 1 cặp dấu ngoặc và thay thế cả cặp dấu đó
        while (reducedString.contains("{}") || reducedString.contains("[]") || reducedString.contains("()")) {
            reducedString = reducedString.replaceAll("\\(\\)|\\{}|\\[]", "");
        }

        //nếu không còn dấu ngoặc nào trong chuỗi thì cú pháp đặt dấu ngoặc đúng
        return reducedString.length() == 0;
    }
}