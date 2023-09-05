import java.util.ArrayList;
import java.util.Arrays;

public class ttt_winner {
    private String documentation = "I have no clue how to document code in this so the format of the position of the board is 111222333 row then position. See the display function for an example of the board";

    private String position;
    private ArrayList parts;
    static String[] x_boards = {"xxxaaaaaa", "aaaxxxaaa", "aaaaaaxxx", "xaaxaaxaa", "axaaxaaxa", "aaxaaxaax", "xaaaxaaax", "aaxaxaxaa"};
    static String[] o_boards = new String[x_boards.length];

    public ttt_winner(String position) {
        this.position = position;
        this.parts = new ArrayList();
        this.convert();

        String a = this.position.substring(0,3);
        String b = this.position.substring(3,6);
        String c = this.position.substring(6,9);
        this.parts.add(a);
        this.parts.add(b);
        this.parts.add(c);
    }


    private void convert() {
        for (int j = 0; j< this.x_boards.length; j++) {
            String b = this.x_boards[j];
            String s = "";
            for (int i = 0; i< b.length(); i++) {
                if (b.charAt(i) == 'x') {
                    s += 'o';
                }
                else {
                    s+= 'a';
                }
            }
            this.o_boards[j] = s;
        }
    }

    private String det_winner(){
        int x = 0;
        int o = 0;
        String pos = this.position;

        for (int l = 0; l<pos.length(); l++){
            if (pos.charAt(l) == 'x'){
                x+=1;
            }
            else{
                o+=1;
            }
        }

        if (!((x == 5 && o == 4) || (x == 4 && o == 5))){
            return "Invalid Position";
        }
        else {
            for (int i = 0; i< this.x_boards.length; i++) {
                String b = this.x_boards[i];
                int counter = 0;
                for (int j = 0; j < b.length(); j++){
                    if (b.charAt(j) == this.position.charAt(j)){
                        counter += 1;
                    }
                }
                if (counter == 3){
                    return "x wins";
                }
            }

            for (int i = 0; i< this.o_boards.length; i++) {
                String b = this.o_boards[i];
                int counter = 0;
                for (int j = 0; j < b.length(); j++){
                    if (b.charAt(j) == this.position.charAt(j)){
                        counter += 1;
                    }
                }
                if (counter == 3){
                    return "o wins";
                }
            }

            return "draw";
        }
    }

    private void display(){
        for (Object l : this.parts) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        String pos = "xxoooxxox";
        ttt_winner winner = new ttt_winner(pos);
        winner.display();
        System.out.println(winner.det_winner());
    }
}
