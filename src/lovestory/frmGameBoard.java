package lovestory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;


/**
 *
 * @author mayibo
 */
public final class frmGameBoard extends JFrame implements ActionListener, KeyListener {
    //Declaring Widgets
    JButton btnHomePage; //Click to go back to home page
    JButton btnNewGame; //Click to start a new 2048 game.
    JButton btnRight; //Click to do the right merge
    JButton btnLeft; //Click to do the left merge
    JButton btnUp; //Click to do the up merge
    JButton btnDown; //Click to do the down merge
    JTextField txtHighest; //The textfield to shows the highest score.
    JTextField txtScore; //The textfield to shows current score.
    Cell [][]Grid; //The Game Board Cells.
    int intHighest; //Highest score.
    int intScore = 0; //Current score.
    ArrayList<Integer> intScores;
    JLabel lblBackground; //The lblBackground.
    //ImageIcons for the game.
    ImageIcon img1 = new ImageIcon("picture2.jpg"); //image with 1 cartoon.
    
    public frmGameBoard(int _intHighest, ArrayList<Integer> _intScores) {
        intScores = _intScores;
        intHighest = _intHighest;
        resize(1440,900);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        //Setting up the New Game button;
        btnHomePage = new JButton("Homepage");
        //Changing the font of the display
        btnHomePage.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnHomePage.setSize(180,52);
        btnHomePage.setLocation(164,805);
        btnHomePage.setActionCommand("Homepage");
        btnHomePage.addActionListener(this);
        add(btnHomePage);//adding the button into JFrame
        
        //Setting up the New Game button;
        btnNewGame = new JButton("New Game");
        //Changing the font of the display
        btnNewGame.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnNewGame.setSize(180,52);
        btnNewGame.setLocation(418,803);
        btnNewGame.setActionCommand("New Game");
        btnNewGame.addActionListener(this);
        add(btnNewGame);//adding the button into JFrame
        
        //Setting up the right button;
        btnRight = new JButton("Right");
        //Changing the font of the display
        btnRight.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnRight.setSize(100,100);
        btnRight.setLocation(1115,550);
        btnRight.setActionCommand("Right");
        btnRight.addActionListener(this);
        add(btnRight);//adding the button into JFrame
        
        //Setting up the left button;
        btnLeft = new JButton("Left");
        //Changing the font of the display
        btnLeft.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnLeft.setSize(100,100);
        btnLeft.setLocation(885,550);
        btnLeft.setActionCommand("Left");
        btnLeft.addActionListener(this);
        add(btnLeft);//adding the button into JFrame
        
        //Setting up the up button;
        btnUp = new JButton("Up");
        //Changing the font of the display
        btnUp.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnUp.setSize(100,100);
        btnUp.setLocation(1000,435);
        btnUp.setActionCommand("Up");
        btnUp.addActionListener(this);
        add(btnUp);//adding the button into JFrame
        
        //Setting up the down button;
        btnDown = new JButton("Down");
        //Changing the font of the display
        btnDown.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnDown.setSize(100,100);
        btnDown.setLocation(1000,665);
        btnDown.setActionCommand("Down");
        btnDown.addActionListener(this);
        add(btnDown);//adding the button into JFrame
        
        
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
        
        //Layout the cells
        int intX = 166, intY = 178;
        Grid = new Cell[4][4];//The Game Board Cells
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                Grid[i][j] = new Cell(1);
                Grid[i][j].setSize(100,100);
                Grid[i][j].setLocation(intX, intY);
                Grid[i][j].setValue(0);
                add(Grid[i][j]);
                intX += 110;
            }
            intX = 166;
            intY += 110;
        }
        
        //Setting up the game backgound label.
        lblBackground = new JLabel();
        //Changing the font of the display
        lblBackground.setFont(new Font(Font.SERIF, Font.BOLD, 36));
        //Setting up the location and size
        lblBackground.setIcon(img1);
        lblBackground.setSize(1440,900);
        lblBackground.setLocation(0,0);
        add(lblBackground);//adding the label into JFrame
        
        intScore = 0;
        GenerateNewBlock();
        GenerateNewBlock();
        txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        txtScore.setText("Score: " + String.valueOf(intScore));  
        addKeyListener(this);
    }
    
    
    public boolean RightMerge(){
        boolean Win = false;
        boolean Moved = false;
        for(int i = 0; i < 4; i++){
            for(int j = 2; j >= 0; j--){
                for(int k = j; k < 3; k++) {
                    if(Grid[i][k].getValue() != 0 && Grid[i][k + 1].getValue() == 0) {
                        Grid[i][k + 1].setValue(Grid[i][k].getValue());
                        Grid[i][k].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 2; j >= 0; j--){
                if(Grid[i][j].getValue() == Grid[i][j + 1].getValue() &&
                        Grid[i][j].getValue() != 0) {
                    Grid[i][j].setValue(0);
                    Grid[i][j + 1].setValue(Grid[i][j + 1].getValue() * 2);
                    intScore += Grid[i][j + 1].getValue();
                    if(Grid[i][j + 1].getValue() == 2048) {
                        Win = true;
                    }
                    Moved = true;
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 2; j >= 0; j--){
                for(int k = j; k < 3; k++) {
                    if(Grid[i][k].getValue() != 0 && Grid[i][k + 1].getValue() == 0) {
                        Grid[i][k + 1].setValue(Grid[i][k].getValue());
                        Grid[i][k].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        if(intScore >= intHighest) {
            intHighest = intScore;
            txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        txtScore.setText("Score: " + String.valueOf(intScore));
        if(Win) {
            intScores.add(intScore);
            frmGameOver myGame = new frmGameOver(intHighest, intScore, true, intScores, 0);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
    
    public boolean LeftMerge(){
        boolean Win = false;
        boolean Moved = false;
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 4; j++){
                for(int k = j; k > 0; k--) {
                    if(Grid[i][k].getValue() != 0 && Grid[i][k - 1].getValue() == 0) {
                        Grid[i][k - 1].setValue(Grid[i][k].getValue());
                        Grid[i][k].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 4; j++){
                if(Grid[i][j].getValue() == Grid[i][j - 1].getValue() &&
                        Grid[i][j].getValue() != 0) {
                    Grid[i][j].setValue(0);
                    Grid[i][j - 1].setValue(Grid[i][j - 1].getValue() * 2);
                    intScore += Grid[i][j - 1].getValue();
                    if(Grid[i][j - 1].getValue() == 2048) {
                        Win = true;
                    }
                    Moved = true;
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 4; j++){
                for(int k = j; k > 0; k--) {
                    if(Grid[i][k].getValue() != 0 && Grid[i][k - 1].getValue() == 0) {
                        Grid[i][k - 1].setValue(Grid[i][k].getValue());
                        Grid[i][k].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        if(intScore >= intHighest) {
            intHighest = intScore;
            txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        txtScore.setText("Score: " + String.valueOf(intScore));
        if(Win) {
            intScores.add(intScore);
            frmGameOver myGame = new frmGameOver(intHighest, intScore, true, intScores, 0);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
        
    public boolean UpMerge(){
        boolean Win = false;
        boolean Moved = false;
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 4; j++){
                for(int k = j; k > 0; k--) {
                    if(Grid[k][i].getValue() != 0 && Grid[k - 1][i].getValue() == 0) {
                        Grid[k - 1][i].setValue(Grid[k][i].getValue());
                        Grid[k][i].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 4; j++){
                if(Grid[j][i].getValue() == Grid[j - 1][i].getValue() &&
                        Grid[j][i].getValue() != 0) {
                    Grid[j][i].setValue(0);
                    Grid[j - 1][i].setValue(Grid[j - 1][i].getValue() * 2);
                    intScore += Grid[j - 1][i].getValue();
                    if(Grid[j - 1][i].getValue() == 2048) {
                        Win = true;
                    }
                    Moved = true;
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 4; j++){
                for(int k = j; k > 0; k--) {
                    if(Grid[k][i].getValue() != 0 && Grid[k - 1][i].getValue() == 0) {
                        Grid[k - 1][i].setValue(Grid[k][i].getValue());
                        Grid[k][i].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        if(intScore >= intHighest) {
            intHighest = intScore;
            txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        txtScore.setText("Score: " + String.valueOf(intScore));
        if(Win) {
            intScores.add(intScore);
            frmGameOver myGame = new frmGameOver(intHighest, intScore, true, intScores, 0);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
            
    public boolean DownMerge(){
        boolean Win = false;
        boolean Moved = false;
        for(int i = 0; i < 4; i++){
            for(int j = 2; j >= 0; j--){
                for(int k = j; k < 3; k++) {
                    if(Grid[k][i].getValue() != 0 && Grid[k + 1][i].getValue() == 0) {
                        Grid[k + 1][i].setValue(Grid[k][i].getValue());
                        Grid[k][i].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 2; j >= 0; j--){
                if(Grid[j][i].getValue() == Grid[j + 1][i].getValue() &&
                        Grid[j][i].getValue() != 0) {
                    Grid[j][i].setValue(0);
                    Grid[j + 1][i].setValue(Grid[j + 1][i].getValue() * 2);
                    intScore += Grid[j + 1][i].getValue();
                    if(Grid[j + 1][i].getValue() == 2048) {
                        Win = true;
                    }
                    Moved = true;
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 2; j >= 0; j--){
                for(int k = j; k < 3; k++) {
                    if(Grid[k][i].getValue() != 0 && Grid[k + 1][i].getValue() == 0) {
                        Grid[k + 1][i].setValue(Grid[k][i].getValue());
                        Grid[k][i].setValue(0);
                        Moved = true;
                    } else {
                        break;
                    }
                }
            }
        }
        if(intScore >= intHighest) {
            intHighest = intScore;
            txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        txtScore.setText("Score: " + String.valueOf(intScore));
        if(Win) {
            intScores.add(intScore);
            frmGameOver myGame = new frmGameOver(intHighest, intScore, true, intScores, 0);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setFocusable(true);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
    
    public void GenerateNewBlock(){
        ArrayList<Integer> RowNumbers = new ArrayList<>();
        ArrayList<Integer> ColumnNumbers = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(Grid[i][j].getValue() == 0) {
                    RowNumbers.add(i);
                    ColumnNumbers.add(j);
                }
            }
        }
        if(RowNumbers.isEmpty()){
            return;
        }
        int intBlockMax = 10;
        int intBlockMin = 1;
        int intBlockRange = intBlockMax - intBlockMin + 1;
        int intNewBlock  = (int)(Math.random() * intBlockRange) + intBlockMin;
        if(intNewBlock == 1) intNewBlock = 4;
        else intNewBlock = 2;
        
        int intMax = RowNumbers.size() - 1;
        int intMin = 0;
        int intRange = intMax - intMin + 1;
        // generate random numbers within 0 to RowNumbers.size();
        int intRandom = (int)(Math.random() * intRange) + intMin;
        Grid[RowNumbers.get(intRandom)][ColumnNumbers.get(intRandom)].setValue(intNewBlock);
    }
    
    public void CheckLose(){
        boolean full = true;
        boolean mergable = false;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(Grid[i][j].getValue() == 0) {
                    full = false;
                }
                if(i < 3) {
                    if(Grid[i][j].getValue() == Grid[i + 1][j].getValue()) {
                        mergable = true;
                    }
                }
                if(j < 3) {
                    if(Grid[i][j].getValue() == Grid[i][j + 1].getValue()) {
                        mergable = true;
                    }
                }
            }
        }
        if(full && !mergable) {
            //intScores.add(intScore);
            frmGameOver myGame = new frmGameOver(intHighest, intScore, false, intScores, 1);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        //checking to see whether the btnUserGuide is pressed
        if(e.getActionCommand().equals("Right")){
            if(RightMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getActionCommand().equals("Left")){
            if(LeftMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getActionCommand().equals("Up")){
            if(UpMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getActionCommand().equals("Down")){
            if(DownMerge()) {
                GenerateNewBlock();
                CheckLose();
            }            
        }
        if(e.getActionCommand().equals("Homepage")){
            frmHomepage myGame = new frmHomepage(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose(); //This will close the currently active Frame
        }
        if(e.getActionCommand().equals("New Game")){
            frmGameBoard myGame = new frmGameBoard(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setFocusable(true);
            myGame.setVisible(true);
            this.dispose(); //This will close the currently active Frame
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(RightMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            if(LeftMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_W){
            if(UpMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_S){
            if(DownMerge()) {
                GenerateNewBlock();
                CheckLose();
            }            
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(RightMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(LeftMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            if(UpMerge()) {
                GenerateNewBlock();
                CheckLose();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if(DownMerge()) {
                GenerateNewBlock();
                CheckLose();
            }            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}