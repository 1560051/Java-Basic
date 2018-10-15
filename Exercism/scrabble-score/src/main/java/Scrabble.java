// Letter                           Value
// A, E, I, O, U, L, N, R, S, T       1
// D, G                               2
// B, C, M, P                         3
// F, H, V, W, Y                      4
// K                                  5
// J, X                               8
// Q, Z                               10
// Examples
// "cabbage" should be scored as worth 14 points:

// 3 points for C
// 1 point for A, twice
// 3 points for B, twice
// 2 points for G
// 1 point for E
// And to total:

// 3 + 2*1 + 2*3 + 2 + 1
// = 3 + 2 + 6 + 3
// = 5 + 9
// = 14

class Scrabble {
    private String text;
    private int score=0;

    Scrabble(String word) {
        this.text=word.toLowerCase();
    }

    int getScore() {
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            if(c=='k') {
                score += 5;
                continue;
            }

            if (c=='q'||c=='z') {
                score += 10;
                continue;
            }

            if (c=='j'||c=='x') {
                score += 8;
                continue;
            }
            if (c=='f'||c=='h'||c=='v'||c=='w'||c=='y') {
                score += 4;
                continue;
            }
            if (c=='b'||c=='c'||c=='m'||c=='p') {
                score += 3;
                continue;
            }
            if (c=='d'||c=='g') {
                score += 2;
                continue;
            }
            else {
                score += 1;
                continue;
            }
        }
        return score;
    }
}
