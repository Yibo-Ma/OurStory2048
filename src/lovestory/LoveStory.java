package lovestory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author mayibo
 */
public class LoveStory {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> intScores = new ArrayList<>();
        BufferedReader br = null;
        String word = "0";
        try {
            br = new BufferedReader(new FileReader("highest.txt"));
            if ((word = br.readLine()) == null) {
                word = "0";
            }
        } catch (IOException e) {
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        frmHomepage myGame = new frmHomepage(Integer.valueOf(word), intScores);
        myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGame.setVisible(true);
    }    
}
