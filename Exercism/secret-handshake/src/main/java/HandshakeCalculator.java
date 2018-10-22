You and your fellow cohort of those in the "know" when it comes to binary decide to come up with a secret "handshake".

// 1 = wink
// 10 = double blink
// 100 = close your eyes
// 1000 = jump


// 10000 = Reverse the order of the operations in the secret handshake.
// Given a decimal number, convert it to the appropriate 
// sequence of events for a secret handshake.

// Here's a couple of examples:

// Given the input 3, the function would return the array 
//["wink", "double blink"] because 3 is 11 in binary.

// Given the input 19, the function would return the array 
//["double blink", "wink"] because 19 is 10011 in binary. 
//Notice that the addition of 16 (10000 in binary) has caused 
//the array to be reversed.




import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class HandshakeCalculator {

    public static List<Signal> calculateHandshake(int number) {
        List<Signal>handShakes =new ArrayList<Signal>();
        String s=Integer.toBinaryString(number);

        //theo đề nếu lớn hơn bằng 16 thì trừ 16 r
        if(number>=16)
            s=Integer.toBinaryString(number-16);
        Signal[] signals =Signal.values();
        int i=Integer.parseInt(s);

        //1 = wink
        if(i%10==1)
            handShakes.add(Signal.WINK);

        //10 = double blink
        if(i%100>=10)
            handShakes.add(Signal.DOUBLE_BLINK);

        //100 = close your eyes
        if(i%1000>=100)
            handShakes.add(Signal.CLOSE_YOUR_EYES);

        //1000 = jump
        if(i%10000>=1000)
            handShakes.add(Signal.JUMP);

        //nếu lớn hơn 16 thì phải reverse Array
        if(number>=16)
            Collections.reverse(handShakes);
        return handShakes;
    }

}
