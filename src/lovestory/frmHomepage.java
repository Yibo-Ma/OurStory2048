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
import javax.swing.JTextField;

/**
 *
 * @author mayibo
 */
public final class frmHomepage extends JFrame implements ActionListener{
    //Declaring Widgets
    JLabel lblBackground; //The lblBackground.
    JButton btnUserGuide; //Click to go to the User Guide page.
    JButton btnNewGame; //Click to start a new single player 2048 game.
    JButton btnTPGame; //Click to start a new two player 2048 game.
    //ImageIcons for the game.
    ImageIcon img1 = new ImageIcon("picture1.jpg"); //image with 1 cartoon.
    JTextField txtHighest; //The textfield to shows the highest score.
    JTextArea txtScoresList; //The textarea to shows the scores.
    int intHighest; //The highest score.
    ArrayList<Integer> intScores;
    
    public frmHomepage(int _intHighest, ArrayList<Integer> _intScores) {
        intScores = _intScores;
        intHighest = _intHighest;
        resize(1440,900);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Setting up the User Guide button;
        btnUserGuide = new JButton("User Guide");
        //Changing the font of the display
        btnUserGuide.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnUserGuide.setSize(170,55);
        btnUserGuide.setLocation(340,430);
        btnUserGuide.setActionCommand("User Guide");
        btnUserGuide.addActionListener(this);
        add(btnUserGuide);//adding the button into JFrame
        
        //Setting up the New Game button;
        btnNewGame = new JButton("1 Player");
        //Changing the font of the display
        btnNewGame.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnNewGame.setSize(170,48);
        btnNewGame.setLocation(242,518);
        btnNewGame.setActionCommand("单人模式");
        btnNewGame.addActionListener(this);
        add(btnNewGame);//adding the button into JFrame
        
        //Setting up the New TP button;
        btnTPGame = new JButton("2 Players");
        //Changing the font of the display
        btnTPGame.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnTPGame.setSize(170,48);
        btnTPGame.setLocation(242,600);
        btnTPGame.setActionCommand("情侣模式");
        btnTPGame.addActionListener(this);
        add(btnTPGame);//adding the button into JFrame
                
        //Setting up the TextFild
        txtHighest = new JTextField();
        //Changing the font of the display
        txtHighest.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        txtHighest.setSize(185,40);
        txtHighest.setLocation(1035,390);
        add(txtHighest);//adding the label into JFrame
        
        txtHighest.setText("Highest Score:" + String.valueOf(_intHighest));
        
        //Setting up the game background label.
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
        //checking to see whether the btnUserGuide is pressed
        if(e.getActionCommand().equals("User Guide")){
            frmUserGuide myGame = new frmUserGuide(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
        //checking to see whether the btnNewGame is pressed
        if(e.getActionCommand().equals("单人模式")){
            frmGameBoard myGame = new frmGameBoard(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setFocusable(true);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
        if(e.getActionCommand().equals("情侣模式")){
            frmTwoPlayersBoard myGame = new frmTwoPlayersBoard(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setFocusable(true);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
    }
}
    
   