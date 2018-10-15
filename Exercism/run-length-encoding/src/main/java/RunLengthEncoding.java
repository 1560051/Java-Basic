//AABBBCCCC => 2A3B4C

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RunLengthEncoding {

    RunLengthEncoding(){

    }

    public static String encode(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        //Duyệt từng ký tự trong mảng
        for (char c : chars) {
            Integer n = map.get(c);

            //nếu ký tự chưa có trong map
            if (n == null)
                n = 1;

            //đã có
            else
                n++;

            //thêm vào map
            map.put(c, n);
        }
        String encodingString="";
        Set<Character> keySet = map.keySet();
        //duyệt từng phần tử trong map và chuyển thành String
        for (Character key : keySet) {
            encodingString+=map.get(key).toString()+key;
        }

        return encodingString;
    }

}
