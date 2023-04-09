package lovestory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author mayibo
 */
public class frmUserGuide extends JFrame implements ActionListener{
    //Declaring Widgets
    JButton btnClose; //Click to go back to homepage.
    JTextArea txtIntroduction;//text area to introduce how to play this game.
    int intHighest;
    ArrayList<Integer> intScores;
    JLabel lblBackground; //The lblBackground.
    //ImageIcons for the game.
    ImageIcon img1 = new ImageIcon("userguide.jpg"); //image with 1 cartoon.
    
    public frmUserGuide(int _intHighest, ArrayList<Integer> _intScores) {
        intScores = _intScores;
        intHighest = _intHighest;
        resize(1440,900);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        //Setting up the Close button;
        btnClose = new JButton("Close");
       //Changing the font of the display
        btnClose.setFont(new Font(Font.SERIF, Font.BOLD, 20));
       //Setting up the location and size
        btnClose.setSize(180,52);
        btnClose.setLocation(418,803);
        btnClose.setActionCommand("Close");
        btnClose.addActionListener(this);
        add(btnClose);//adding the button into JFrame
        
        //Setting up the game backgound label.
        lblBackground = new JLabel();
        //Changing the font of the display
        lblBackground.setFont(new Font(Font.SERIF, Font.BOLD, 36));
        //Setting up the location and size
        lblBackground.setIcon(img1);
        lblBackground.setSize(1440,900);
        lblBackground.setLocation(0,0);
        add(lblBackground);//adding the label into JFrame
        
    }
       
    @Override
    public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equals("Close")){
            frmHomepage myGame = new frmHomepage(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose(); //This will close the currently active Frame
        }
    }   
}

