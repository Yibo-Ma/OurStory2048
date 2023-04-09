package lovestory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mayibo
 */
public class frmGameOver extends JFrame implements ActionListener{
    JButton btnHome; //Click to go back to homepage.
    JButton btnExit; //Click to exit the application.
    JLabel lblBackground; //The lblBackground.
    //ImageIcons for the game.
    ImageIcon img0 = new ImageIcon("gameover0.jpg");//image with 1
    ImageIcon img1 = new ImageIcon("gameover1.jpg");//image with 1
    ImageIcon img2 = new ImageIcon("gameover2.jpg");//iamge with 2
    ImageIcon img3 = new ImageIcon("gameover3.jpg");//iamge with 3
    ImageIcon img4 = new ImageIcon("gameover4.jpg");//iamge with 4
    
    JTextField txtHighest; //The textfield to shows the highest score.
    JTextField txtScore; //The textfield to shows current score.
    int intHighest;
    ArrayList<Integer> intScores;
    
    public frmGameOver(int _intHighest, int intScore, boolean Win, ArrayList<Integer> _intScores, int Index) {
        intScores = _intScores;
        intHighest = _intHighest;
        resize(1440,900);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Setting up the Home Button;
        btnHome = new JButton("Homepage");
        //Changing the font of the display
        btnHome.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnHome.setSize(180,52);
        btnHome.setLocation(164,805);
        btnHome.setActionCommand("Home");
        btnHome.addActionListener(this);
        add(btnHome);//adding the label into JFrame
        
        //Setting up the Exit button;
        btnExit = new JButton("Exit");
       //Changing the font of the display
        btnExit.setFont(new Font(Font.SERIF, Font.BOLD, 20));
       //Setting up the location and size
        btnExit.setSize(180,52);
        btnExit.setLocation(418,803);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(this);
        add(btnExit);//adding the button into JFrame
        
        //Setting up the TextFild
        txtHighest = new JTextField();
       //Changing the font of the display
        txtHighest.setFont(new Font(Font.SERIF, Font.BOLD, 20));
       //Setting up the location and size
        txtHighest.setSize(200,50);
        txtHighest.setLocation(175, 55);
        add(txtHighest);//adding the label into JFrame
        
        //Setting up the TextFild
        txtScore = new JTextField();
       //Changing the font of the display
        txtScore.setFont(new Font(Font.SERIF, Font.BOLD, 20));
       //Setting up the location and size
        txtScore.setSize(200,50);
        txtScore.setLocation(385, 55);
        add(txtScore);//adding the label into JFrame
        
        txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        txtScore.setText("Score: " + String.valueOf(intScore)); 
        
        //Setting up the game backgound label.
        lblBackground = new JLabel();
        //Changing the font of the display
        lblBackground.setFont(new Font(Font.SERIF, Font.BOLD, 36));
        //Setting up the location and size
        if(Index == 0) lblBackground.setIcon(img0);
        else if(Index == 1) lblBackground.setIcon(img1);
        else if(Index == 2) lblBackground.setIcon(img2);
        else if(Index == 3) lblBackground.setIcon(img3);
        else if(Index == 4) lblBackground.setIcon(img4);
        lblBackground.setSize(1440,900);
        lblBackground.setLocation(0,0);
        add(lblBackground);//adding the label into JFrame
    }
       
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Exit")){
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("highest.txt"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                writer.write(String.valueOf(intHighest));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0); // Exit the application.
        }
        if(e.getActionCommand().equals("Home")){
          frmHomepage myGame = new frmHomepage(intHighest, intScores);
          myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          myGame.setVisible(true);
          this.dispose();//This will close the currently active Frame
        }
    }
}
