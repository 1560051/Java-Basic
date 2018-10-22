//Đếm tần số xuất hiện của các từ trong 1 Chuỗi 

// For example for the input "olly olly in come free"

// olly: 2
// in: 1
// come: 1
// free: 1

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String,Integer> phrase(String str){
        //tách chuỗi thành các từ
        String[] words=str.split("\\W+");
        Map<String, Integer> map = new HashMap<>();
        //duyệt các từ trong mảng
        for (String w : words) {
            Integer n = map.get(w);

            //nếu chưa xuất hiện trong map
            if (n == null)
                n = 1;
            
            //nếu có xuất hiện
            else
                n++;
            map.put(w, n);
        }
        return map;
    }
}
