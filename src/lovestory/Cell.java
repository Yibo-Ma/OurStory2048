package lovestory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mayibo
 */
public class Cell extends JLabel{
    ImageIcon back = new ImageIcon("cellback.jpg");
    ImageIcon image2 = new ImageIcon("2.jpg");
    ImageIcon image4 = new ImageIcon("4.jpg");
    ImageIcon image8 = new ImageIcon("8.jpg");
    ImageIcon image16 = new ImageIcon("16.jpg");
    ImageIcon image32 = new ImageIcon("32.jpg");
    ImageIcon image64 = new ImageIcon("64.jpg");
    ImageIcon image128 = new ImageIcon("128.jpg");
    ImageIcon image256 = new ImageIcon("256.jpg");
    ImageIcon image512 = new ImageIcon("512.jpg");
    ImageIcon image1024 = new ImageIcon("1024.jpg");
    ImageIcon image2048 = new ImageIcon("2048.jpg");
    
    ImageIcon back2 = new ImageIcon("cellback.jpg");
    ImageIcon image22 = new ImageIcon("22.jpg");
    ImageIcon image42 = new ImageIcon("42.jpg");
    ImageIcon image82 = new ImageIcon("82.jpg");
    ImageIcon image162 = new ImageIcon("162.jpg");
    ImageIcon image322 = new ImageIcon("322.jpg");
    ImageIcon image642 = new ImageIcon("642.jpg");
    ImageIcon image1282 = new ImageIcon("1282.jpg");
    ImageIcon image2562 = new ImageIcon("2562.jpg");
    ImageIcon image5122 = new ImageIcon("5122.jpg");
    ImageIcon image10242 = new ImageIcon("10242.jpg");
    ImageIcon image20482 = new ImageIcon("20482.jpg");
    
    int intValue = 0;
    int GridIdx = 0;
    
    public Cell(int _GridIdx) {
        intValue = 0;
        GridIdx = _GridIdx;
        setIcon(back);
    }
    
    public int getValue() {
        return intValue;
    }
    
    public void setValue(int Value) {
        intValue = Value;
        if(GridIdx == 1) {
            if(intValue == 0) {
                setIcon(back);
            }
            if(intValue == 2) {
                setIcon(image2);
            }
            if(intValue == 4) {
                setIcon(image4);
            }
            if(intValue == 8) {
                setIcon(image8);
            }
            if(intValue == 16) {
                setIcon(image16);
            }
            if(intValue == 32) {
                setIcon(image32);
            }
            if(intValue == 64) {
                setIcon(image64);
            }
            if(intValue == 128) {
                setIcon(image128);
            }
            if(intValue == 256) {
                setIcon(image256);
            }
            if(intValue == 512) {
                setIcon(image512);
            }
            if(intValue == 1024) {
                setIcon(image1024);
            }
            if(intValue == 2048) {
                setIcon(image2048);
            }
        } else {
            if(intValue == 0) {
                setIcon(back2);
            }
            if(intValue == 2) {
                setIcon(image22);
            }
            if(intValue == 4) {
                setIcon(image42);
            }
            if(intValue == 8) {
                setIcon(image82);
            }
            if(intValue == 16) {
                setIcon(image162);
            }
            if(intValue == 32) {
                setIcon(image322);
            }
            if(intValue == 64) {
                setIcon(image642);
            }
            if(intValue == 128) {
                setIcon(image1282);
            }
            if(intValue == 256) {
                setIcon(image2562);
            }
            if(intValue == 512) {
                setIcon(image5122);
            }
            if(intValue == 1024) {
                setIcon(image10242);
            }
            if(intValue == 2048) {
                setIcon(image20482);
            }
        }
    }
    
   
    void setActionCommand(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

