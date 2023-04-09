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
public final class frmTwoPlayersBoard extends JFrame implements ActionListener, KeyListener {
    //Declaring Widgets
    JButton btnHomePage; //Click to go back to home page
    JButton btnNewGame; //Click to start a new 2048 game.
    JTextField txtHighest; //The textfield to shows the highest score.
    JTextField txtHighest2; //The textfield to shows the highest score.
    JTextField txtScore1; //The textfield to shows current score.
    JTextField txtScore2; //The textfield to shows current score.
    Cell [][]Grid1; //The Game Board Cells.
    Cell [][]Grid2; //The Game Board2 Cells.
    Cell [][]GameOver;
    int intHighest; //Highest score.
    int intScore1 = 0; //Current score.
    int intScore2 = 0; //Current score.
    ArrayList<Integer> intScores;
    JLabel lblBackground; //The lblBackground.
    //ImageIcons for the game.
    ImageIcon img1 = new ImageIcon("picture3.jpg"); //image with 1 cartoon.
    
    
    public frmTwoPlayersBoard(int _intHighest, ArrayList<Integer> _intScores) {
        intScores = _intScores;
        intHighest = _intHighest;
        GameOver = null;
        resize(1440,900);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);       
        
        //Setting up the New Game button;
        btnHomePage = new JButton("Homepage");
        //Changing the font of the display
        btnHomePage.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnHomePage.setSize(180,52);
        btnHomePage.setLocation(847,802);
        btnHomePage.setActionCommand("Homepage");
        btnHomePage.addActionListener(this);
        add(btnHomePage);//adding the button into JFrame
        
        //Setting up the New Game button;
        btnNewGame = new JButton("New Game");
        //Changing the font of the display
        btnNewGame.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        btnNewGame.setSize(180,52);
        btnNewGame.setLocation(1100,802);
        btnNewGame.setActionCommand("New Game");
        btnNewGame.addActionListener(this);
        add(btnNewGame);//adding the button into JFrame
       
        
        //Setting up the TextFild
        txtHighest = new JTextField();
        //Changing the font of the display
        txtHighest.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        txtHighest.setSize(200,50);
        txtHighest.setLocation(175, 55);
        add(txtHighest);//adding the label into JFrame
        
        //Setting up the TextFild
        txtHighest2 = new JTextField();
        //Changing the font of the display
        txtHighest2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        txtHighest2.setSize(200,50);
        txtHighest2.setLocation(857, 55);
        add(txtHighest2);//adding the label into JFrame
        
        //Setting up the TextFild
        txtScore1 = new JTextField();
        //Changing the font of the display
        txtScore1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        txtScore1.setSize(200,50);
        txtScore1.setLocation(385, 55);
        add(txtScore1);//adding the label into JFrame
        
        //Setting up the TextFild
        txtScore2 = new JTextField();
        //Changing the font of the display
        txtScore2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //Setting up the location and size
        txtScore2.setSize(200,50);
        txtScore2.setLocation(1067, 55);
        add(txtScore2);//adding the label into JFrame
        
        //Layout the cells
        int intX = 166, intY = 178;
        Grid1 = new Cell[4][4];//The Game Board Cells
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                Grid1[i][j] = new Cell(1);
                Grid1[i][j].setSize(100,100);
                Grid1[i][j].setLocation(intX, intY);
                Grid1[i][j].setValue(0);
                add(Grid1[i][j]);
                intX += 110;
            }
            intX = 166;
            intY += 110;
        }
        intScore1 = 0;
        GenerateNewBlock(Grid1);
        GenerateNewBlock(Grid1);
        txtHighest.setText("Highest Score: " + String.valueOf(intHighest)); 
        txtScore1.setText("Score: " + String.valueOf(intScore1)); 
        
        //Layout the cells
        int intX2 = 848, intY2 = 178;
        Grid2 = new Cell[4][4];//The Game Board Cells
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                Grid2[i][j] = new Cell(2);
                Grid2[i][j].setSize(100,100);
                Grid2[i][j].setLocation(intX2, intY2);
                Grid2[i][j].setValue(0);
                add(Grid2[i][j]);
                intX2 += 110;
            }
            intX2 = 848;
            intY2 += 110;
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
        
        intScore2 = 0;
        GenerateNewBlock(Grid2);
        GenerateNewBlock(Grid2);
        txtHighest2.setText("Highest Score: " + String.valueOf(intHighest)); 
        txtScore2.setText("Score: " + String.valueOf(intScore2)); 
  
        addKeyListener(this);
    }
    
    
    public boolean RightMerge(Cell[][] Grid, int GridIdx){
        int intScore;
        if(GridIdx == 1) {
            intScore = intScore1;
        } else {
            intScore = intScore2;
        }
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
            txtHighest2.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        if(GridIdx == 1) {
            if(intScore1 != intScore) {
                intScore1 = intScore;
                txtScore1.setText("Score: " + String.valueOf(intScore1));
            }
        } else {
            if(intScore2 != intScore) {
                intScore2 = intScore;
                txtScore2.setText("Score: " + String.valueOf(intScore2));
            }
        }
        if(Win) {
            frmGameOver myGame;
            if(Grid == Grid1) myGame = new frmGameOver(intHighest, intScore1, false, intScores, 2);
            else myGame = new frmGameOver(intHighest, intScore2, false, intScores, 3);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
    
    public boolean LeftMerge(Cell[][] Grid, int GridIdx){
        int intScore;
        if(GridIdx == 1) {
            intScore = intScore1;
        } else {
            intScore = intScore2;
        }
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
            txtHighest2.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        if(GridIdx == 1) {
            if(intScore1 != intScore) {
                intScore1 = intScore;
                txtScore1.setText("Score: " + String.valueOf(intScore1));
            }
        } else {
            if(intScore2 != intScore) {
                intScore2 = intScore;
                txtScore2.setText("Score: " + String.valueOf(intScore2));
            }
        }
        if(Win) {
            frmGameOver myGame;
            if(Grid == Grid1) myGame = new frmGameOver(intHighest, intScore1, false, intScores, 2);
            else myGame = new frmGameOver(intHighest, intScore2, false, intScores, 3);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
        
    public boolean UpMerge(Cell[][] Grid, int GridIdx){
        int intScore;
        if(GridIdx == 1) {
            intScore = intScore1;
        } else {
            intScore = intScore2;
        }
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
            txtHighest2.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        if(GridIdx == 1) {
            if(intScore1 != intScore) {
                intScore1 = intScore;
                txtScore1.setText("Score: " + String.valueOf(intScore1));
            }
        } else {
            if(intScore2 != intScore) {
                intScore2 = intScore;
                txtScore2.setText("Score: " + String.valueOf(intScore2));
            }
        }
        if(Win) {
            frmGameOver myGame;
            if(Grid == Grid1) myGame = new frmGameOver(intHighest, intScore1, false, intScores, 2);
            else myGame = new frmGameOver(intHighest, intScore2, false, intScores, 3);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
            
    public boolean DownMerge(Cell[][] Grid, int GridIdx){
        int intScore;
        if(GridIdx == 1) {
            intScore = intScore1;
        } else {
            intScore = intScore2;
        }
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
            txtHighest2.setText("Highest Score: " + String.valueOf(intHighest)); 
        }
        if(GridIdx == 1) {
            if(intScore1 != intScore) {
                intScore1 = intScore;
                txtScore1.setText("Score: " + String.valueOf(intScore1));
            }
        } else {
            if(intScore2 != intScore) {
                intScore2 = intScore;
                txtScore2.setText("Score: " + String.valueOf(intScore2));
            }
        }
        if(Win) {
            frmGameOver myGame;
            if(Grid == Grid1) myGame = new frmGameOver(intHighest, intScore1, false, intScores, 2);
            else myGame = new frmGameOver(intHighest, intScore2, false, intScores, 3);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame            
        }
        return Moved;
    }
    
    public void GenerateNewBlock(Cell[][] Grid){
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
        if(RowNumbers.isEmpty()) {
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
    
    public void CheckLose(Cell[][] Grid){
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
            //intScores.add(intScore)
            if(GameOver == null || GameOver == Grid) {
                GameOver = Grid;
                if(Grid == Grid1) txtScore1.setText("GameOver: " + String.valueOf(intScore1));
                else txtScore2.setText("GameOver: " + String.valueOf(intScore2));
            } else if(GameOver != Grid) {
                frmGameOver myGame;
                if(intScore1 > intScore2) myGame = new frmGameOver(intHighest, intScore1, false, intScores, 2);
                else if (intScore2 > intScore1) myGame = new frmGameOver(intHighest, intScore2, false, intScores, 3);
                else myGame = new frmGameOver(intHighest, intScore1, false, intScores, 4);
                myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myGame.setVisible(true);
                this.dispose();//This will close the currently active Frame
            }
        }
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Homepage")){
            frmHomepage myGame = new frmHomepage(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose(); //This will close the currently active Frame
        }        
        if(e.getActionCommand().equals("New Game")){
            frmTwoPlayersBoard myGame = new frmTwoPlayersBoard(intHighest, intScores);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setFocusable(true);
            myGame.setVisible(true);
            this.dispose(); //This will close the currently active Frame
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(RightMerge(Grid1, 1)) {
                GenerateNewBlock(Grid1);
                CheckLose(Grid1);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            if(LeftMerge(Grid1, 1)) {
                GenerateNewBlock(Grid1);
                CheckLose(Grid1);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_W){
            if(UpMerge(Grid1, 1)) {
                GenerateNewBlock(Grid1);
                CheckLose(Grid1);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_S){
            if(DownMerge(Grid1, 1)) {
                GenerateNewBlock(Grid1);
                CheckLose(Grid1);
            }            
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(RightMerge(Grid2, 2)) {
                GenerateNewBlock(Grid2);
                CheckLose(Grid2);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(LeftMerge(Grid2, 2)) {
                GenerateNewBlock(Grid2);
                CheckLose(Grid2);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            if(UpMerge(Grid2, 2)) {
                GenerateNewBlock(Grid2);
                CheckLose(Grid2);
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if(DownMerge(Grid2, 2)) {
                GenerateNewBlock(Grid2);
                CheckLose(Grid2);
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