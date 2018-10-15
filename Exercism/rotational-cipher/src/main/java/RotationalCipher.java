//The Caesar cipher is a simple shift cipher that 
// relies on transposing all the letters in the alphabet 
// using an integer key between 0 and 26. Using a key of 
// 0 or 26 will always yield the same output due to modular 
// arithmetic. The letter is shifted for as many values as 
// the value of the key.

// The general notation for rotational ciphers is ROT 
// + <key>. The most commonly used rotational cipher is ROT13.

// Examples
// ROT5 omg gives trl
// ROT0 c gives c
// ROT26 Cool gives Cool

// ROT13 The quick brown fox jumps over the lazy dog. 
//gives Gur dhvpx oebja sbk whzcf bire gur ynml qbt.

// ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. 
//gives The quick brown fox jumps over the lazy dog.

class RotationalCipher {

    private int rot;
    RotationalCipher(int shiftKey) {
        this.rot=shiftKey;
    }

    String rotate(String data) {
        StringBuilder dataSB=new StringBuilder();

        for(int i=0;i<data.length();i++){
            char c=data.charAt(i);

            //nếu input + ký tự mã hóa vượt qua ký tự chữ 
            if((c+rot>122 && c>=97 && c<=122)||
                    (c+rot>90 && c>=65 && c<=90)){
                dataSB.append(((char) (c + rot - 26)));
            }

            //nếu ký tự là 1 chữ
            else if((c>=65 && c<=90)||c>=97 && c<=122)
                dataSB.append(((char) (c + rot)));
            else
                dataSB.append(c);
        }
        return dataSB.toString();
    }

}
