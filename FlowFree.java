//Name: TO DO: Ravishan Thanarajah
//Date: TO DO: July 10 2023
//Purpose: TO DO: Free Flow

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.applet.*;
import java.util.*;
import java.text.*;
import sun.audio.*;
import java.io.*;
import java.io.FileInputStream.*;

public class Puzzle15 extends Applet implements ActionListener
{
    //For screens
    Panel p_card;
    Panel card1, card2, card3, card4;
    CardLayout cdLayout = new CardLayout ();
    JTextField txtName, txtName2;
    JProgressBar z;
    int i = countDone ();

    //Game screen
    JLabel turnPic;
    int turn = 1;
    int last = -1;
    int number = 1;
    //grid
    int row = 4;
    int col = 4;
    JButton a[] = new JButton [row * col];
    //LEVEL 1
    int b[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 0}};
    int ans[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 0, 1}};
    int r[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 0}};
    //LEVEL 2 ()
    int b1[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 0}};
    int ans1[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 0, 1}};
    int r1[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 0}};
    //LEVEL 3 (a)
    int b2[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {7, 6, 5, 0}, {8, 4, 3, 1}};
    int ans2[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 0, 1}};
    int r2[] [] = {{16, 15, 14, 13}, {12, 11, 10, 9}, {7, 6, 5, 0}, {8, 4, 3, 1}};
    //LEVEL 4 (b)
    int b3[] [] = {{15, 14, 13, 9}, {12, 11, 10, 5}, {8, 7, 6, 1}, {4, 3, 2, 0}};
    int ans3[] [] = {{0, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
    int r3[] [] = {{15, 14, 13, 9}, {12, 11, 10, 5}, {8, 7, 6, 1}, {4, 3, 2, 0}};
    //LEVEL 5 (c)
    int b4[] [] = {{4, 5, 6, 7}, {3, 2, 1, 8}, {14, 15, 0, 9}, {13, 12, 11, 10}};
    int ans4[] [] = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
    int r4[] [] = {{4, 5, 6, 7}, {3, 2, 1, 8}, {14, 15, 0, 9}, {13, 12, 11, 10}};
    //LEVEL 6 (d)
    int b5[] [] = {{1, 3, 5, 7}, {8, 10, 12, 9}, {6, 0, 14, 11}, {4, 2, 15, 13}};
    int ans5[] [] = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
    int r5[] [] = {{1, 3, 5, 7}, {8, 10, 12, 9}, {6, 0, 14, 11}, {4, 2, 15, 13}};
    //LEVEL 7 (e)
    int b6[] [] = {{1, 2, 4, 3}, {0, 9, 11, 6}, {14, 13, 15, 8}, {5, 12, 10, 7}};
    int ans6[] [] = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
    int r6[] [] = {{1, 2, 4, 3}, {0, 9, 11, 6}, {14, 13, 15, 8}, {5, 12, 10, 7}};
    //LEVEL 8 (f)
    int b7[] [] = {{0, 12, 8, 4}, {15, 11, 7, 3}, {14, 10, 6, 2}, {13, 9, 5, 1}};
    int ans7[] [] = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
    int r7[] [] = {{0, 12, 8, 4}, {15, 11, 7, 3}, {14, 10, 6, 2}, {13, 9, 5, 1}};
    //LEVEL 9 (g)
    int b8[] [] = {{4, 5, 12, 13}, {3, 6, 11, 14}, {2, 7, 10, 15}, {1, 8, 9, 0}};
    int ans8[] [] = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
    int r8[] [] = {{4, 5, 12, 13}, {3, 6, 11, 14}, {2, 7, 10, 15}, {1, 8, 9, 0}};
    //LEVEL 10 (h)
    int b9[] [] = {{0, 9, 8, 1}, {15, 10, 7, 2}, {14, 11, 6, 3}, {13, 12, 5, 4}};
    int ans9[] [] = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
    int r9[] [] = {{0, 9, 8, 1}, {15, 10, 7, 2}, {14, 11, 6, 3}, {13, 12, 5, 4}};
    //LEVEL INFO
    int levelCount = 10;
    int level = 1;

    //Formatting
    Color backgroundColour = new Color (1, 174, 217);
    Color buttonColour = new Color (255, 221, 0);
    Color buttonText = Color.black;
    Color titleColour = Color.white;
    Font titleFont = new Font ("Haettenschweiler", Font.BOLD, 15);
    Font promptFont = new Font ("Haettenschweiler", Font.BOLD, 15);
    Dimension boardSquare = new Dimension (87, 87);
    AudioClip soundFile;

    public void init ()
    {
        p_card = new Panel ();
        p_card.setLayout (cdLayout);
        //Init
        opening ();
        instructions ();
        settings ();
        gameScreen ();
        resize (350, 500);
        setLayout (new BorderLayout ());
        add ("Center", p_card);
        //Music
        soundFile = getAudioClip (getDocumentBase (), "simpsons.snd");
        soundFile.loop ();
    }


    public void opening ()
    { //TO DO: Opening
        card1 = new Panel ();
        card1.setBackground (backgroundColour);
        JLabel titlebeg = new JLabel (createImageIcon ("title2.png"));
        JLabel title = new JLabel (createImageIcon ("simp.png"));
        JButton next = new JButton ("Start");
        next.setPreferredSize (new Dimension (320, 40));
        next.setActionCommand ("card2");
        next.addActionListener (this);
        next.setBackground (buttonColour);
        next.setForeground (buttonText);
        next.setFont (titleFont);
        card1.add (titlebeg);
        card1.add (title);
        card1.add (next);
        p_card.add ("1", card1);
    }


    public void instructions ()
    { //TO DO:Instructions
        card2 = new Panel ();
        card2.setBackground (backgroundColour);
        JLabel title = new JLabel (createImageIcon ("title2.png"));
        title.setFont (titleFont);
        title.setForeground (titleColour);
        JLabel info = new JLabel (createImageIcon ("instructions2.png"));
        Panel p = new Panel ();
        JButton settings = new JButton ("Settings");
        settings.setActionCommand ("card3");
        settings.addActionListener (this);
        settings.setPreferredSize (new Dimension (150, 30));
        settings.setBackground (buttonColour);
        settings.setForeground (buttonText);
        settings.setFont (titleFont);
        JButton gameScreen = new JButton ("Game");
        gameScreen.setActionCommand ("card4");
        gameScreen.addActionListener (this);
        gameScreen.setPreferredSize (new Dimension (150, 30));
        gameScreen.setBackground (buttonColour);
        gameScreen.setForeground (buttonText);
        gameScreen.setFont (titleFont);

        card2.add (title);
        card2.add (info);
        p.add (settings);
        p.add (gameScreen);
        card2.add (p);
        p_card.add ("2", card2);
    }


    public void settings ()
    { //TO DO: Settings
        card3 = new Panel ();
        card3.setBackground (backgroundColour);
        JLabel title = new JLabel (createImageIcon ("set.png"));
        JButton haha = new JButton (createImageIcon ("hehe.png"));
        haha.addActionListener (this);
        haha.setActionCommand ("haha");
        haha.setPreferredSize (new Dimension (255, 155));
        haha.setBackground (buttonColour);
        JButton entrance = new JButton ("To the game");
        entrance.setActionCommand ("card4");
        entrance.addActionListener (this);
        entrance.setPreferredSize (new Dimension (100, 50));
        entrance.setBackground (buttonColour);
        entrance.setForeground (buttonText);
        entrance.setFont (titleFont);
        //Save Button
        JButton save = new JButton ("Save");
        save.addActionListener (this);
        save.setActionCommand ("save");
        save.setBackground (buttonColour);
        save.setForeground (buttonText);
        save.setFont (titleFont);
        add (save);
        JButton open = new JButton ("Open");
        open.addActionListener (this);
        open.setActionCommand ("open");
        open.setBackground (buttonColour);
        open.setForeground (buttonText);
        open.setFont (titleFont);
        add (open);

        JLabel lvlPmt = new JLabel (createImageIcon ("levels.png"));
        lvlPmt.setFont (promptFont);
        Panel lvlPanel = new Panel (new GridLayout (2, levelCount / 2));
        JButton lvl[] = new JButton [levelCount];
        for (int i = 0 ; i < levelCount ; i++)
        {
            lvl [i] = new JButton ("" + (i + 1));
            lvl [i].setBackground (buttonColour);
            lvl [i].setPreferredSize (new Dimension (60, 40));
            lvl [i].addActionListener (this);
            lvl [i].setFont (promptFont);
            lvl [i].setActionCommand ("lvl" + (i + 1));
            lvlPanel.add (lvl [i]);
        }

        card3.add (title);
        card3.add (haha);
        card3.add (lvlPmt);
        card3.add (lvlPanel);
        card3.add (save);
        card3.add (entrance);
        card3.add (open);
        p_card.add ("3", card3);
    }


    public void gameScreen ()
    { //TO DO: Gamescreen
        card4 = new Panel ();
        card4.setBackground (backgroundColour);
        JLabel title = new JLabel (createImageIcon ("title2b.png"));
        card4.add (title);
        //Set up grid
        Panel p2 = new Panel (new GridLayout (row, col));
        int m = 0;
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                a [m] = new JButton (createImageIcon (b [i] [j] + ".png"));
                a [m].setBackground (backgroundColour);
                a [m].setPreferredSize (boardSquare);
                a [m].addActionListener (this);
                a [m].setBorder (null);
                a [m].setActionCommand ("" + m);
                p2.add (a [m]);
                m++;
            }
        }

        //TO DO: Buttons
        Panel p3 = new Panel ();
        JButton reset = new JButton ("Reset");
        reset.addActionListener (this);
        reset.setActionCommand ("reset");
        reset.setPreferredSize (new Dimension (67, 30));
        reset.setBackground (buttonColour);
        reset.setForeground (buttonText);
        reset.setFont (promptFont);
        p3.add (reset);
        //Instructions Button
        JButton instruct = new JButton ("Huh?");
        instruct.addActionListener (this);
        instruct.setActionCommand ("instruct");
        instruct.setPreferredSize (new Dimension (67, 30));
        instruct.setBackground (buttonColour);
        instruct.setForeground (buttonText);
        instruct.setFont (promptFont);
        p3.add (instruct);
        //Settings Button
        JButton settings = new JButton ("Settings");
        settings.addActionListener (this);
        settings.setActionCommand ("settings");
        settings.setPreferredSize (new Dimension (82, 30));
        settings.setBackground (buttonColour);
        settings.setForeground (buttonText);
        settings.setFont (promptFont);
        p3.add (settings);
        //Previous Button
        JButton previous = new JButton ("-");
        previous.addActionListener (this);
        previous.setActionCommand ("previous");
        previous.setPreferredSize (new Dimension (44, 30));
        previous.setBackground (buttonColour);
        previous.setForeground (buttonText);
        previous.setFont (promptFont);
        p3.add (previous);
        //Next Button
        JButton next = new JButton ("+");
        next.addActionListener (this);
        next.setActionCommand ("next");
        next.setPreferredSize (new Dimension (44, 30));
        next.setBackground (buttonColour);
        next.setForeground (buttonText);
        next.setFont (promptFont);
        p3.add (next);
        //Progress Bar
        z = new JProgressBar (0, 0, 100);
        z.setValue (25);
        z.setStringPainted (true);
        z.setForeground (backgroundColour);
        z.setBackground (buttonColour);
        card4.add (p2);
        add (z);
        card4.add (z);
        card4.add (p3);
        p_card.add ("4", card4);
    }


    public int countDone ()
    {
        int c = 0;
        //returns true if user has won, false otherwise
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                if (b [i] [j] == ans [i] [j])
                    c++;
            }
        }
        return c;

    }


    public boolean win ()
    {
        //returns true if user has won, false otherwise
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                if (b [i] [j] != ans [i] [j])
                    //found a piece that doesn't match
                    return false;
            }
        }
        //made it all the way through, no errors
        return true;

    }


    public void redraw ()
    {
        int m = 0;
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                if (level == 1)
                    a [m].setIcon (createImageIcon (b [i] [j] + ".png"));
                else if (level == 2)
                    a [m].setIcon (createImageIcon ("a" + b [i] [j] + ".png"));
                else if (level == 3)
                    a [m].setIcon (createImageIcon ("b" + b [i] [j] + ".png"));
                else if (level == 4)
                    a [m].setIcon (createImageIcon ("c" + b [i] [j] + ".png"));
                else if (level == 5)
                    a [m].setIcon (createImageIcon ("d" + b [i] [j] + ".png"));
                else if (level == 6)
                    a [m].setIcon (createImageIcon ("e" + b [i] [j] + ".png"));
                else if (level == 7)
                    a [m].setIcon (createImageIcon ("f" + b [i] [j] + ".png"));
                else if (level == 8)
                    a [m].setIcon (createImageIcon ("g" + b [i] [j] + ".png"));
                else if (level == 9)
                    a [m].setIcon (createImageIcon ("h" + b [i] [j] + ".png"));
                m++;
            }
        }
    }


    public boolean canGoLeft (int last, int n)
    {
        int startX = last / col;
        int startY = last % col;
        int endX = n / col;
        int endY = n % col;
        if (b [startX] [startY] != 0 && b [endX] [endY] != 0)
            return false;
        else if (startX == endX && startY - 1 == endY)
            return true;
        else
            return false;
    }


    public boolean canGoRight (int last, int n)
    {
        int startX = last / col;
        int startY = last % col;
        int endX = n / col;
        int endY = n % col;
        if (b [startX] [startY] != 0 && b [endX] [endY] != 0)
            return false;
        else if (startX == endX && startY + 1 == endY)
            return true;

        else
            return false;
    }


    public boolean canGoUp (int last, int n)
    {
        int startX = last / col;
        int startY = last % col;
        int endX = n / col;
        int endY = n % col;
        if (b [startX] [startY] != 0 && b [endX] [endY] != 0)
            return false;
        else if (startX - 1 == endX && startY == endY)
            return true;
        else
            return false;
    }


    public boolean canGoDown (int last, int n)
    {
        int startX = last / col;
        int startY = last % col;
        int endX = n / col;
        int endY = n % col;
        if (b [startX] [startY] != 0 && b [endX] [endY] != 0)
            return false;
        else if (startX + 1 == endX && startY == endY)
            return true;
        else
            return false;
    }


    public void swap (int last, int n)
    {
        int startX = last / col;
        int startY = last % col;
        int endX = n / col;
        int endY = n % col;
        int temp = b [startX] [startY];
        b [startX] [startY] = b [endX] [endY];
        b [endX] [endY] = temp;
    }


    public void copyOver (int a[] [], int b[] [])
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                a [i] [j] = b [i] [j];
            }
        }
    }


    public void next ()
    {
        number++;
        if (number == 2)
        {
            copyOver (b, b2);
            copyOver (r, b2);
            copyOver (ans, ans2);
            level = 2;

        }
        else if (number == 3)
        {
            copyOver (b, b3);
            copyOver (r, b3);
            copyOver (ans, ans3);
            level = 3;
        }
        else if (number == 4)
        {
            copyOver (b, b4);
            copyOver (r, b4);
            copyOver (ans, ans4);
            level = 4;
        }
        else if (number == 5)
        {
            copyOver (b, b5);
            copyOver (r, b5);
            copyOver (ans, ans5);
            level = 5;
        }
        else if (number == 6)
        {
            copyOver (b, b6);
            copyOver (r, b6);
            copyOver (ans, ans5);
            level = 6;
        }
        else if (number == 7)
        {
            copyOver (b, b7);
            copyOver (r, b7);
            copyOver (ans, ans7);
            level = 7;
        }
        else if (number == 8)
        {
            copyOver (b, b8);
            copyOver (r, b8);
            copyOver (ans, ans8);
            level = 8;
        }
        else if (number == 9)
        {
            copyOver (b, b9);
            copyOver (r, b9);
            copyOver (ans, ans9);
            level = 9;
        }
        else
        {
            copyOver (b, b);
            copyOver (r, b);
            copyOver (ans, ans);
            level = 1;
            number = 1;
        }
        redraw ();

    }


    public void previous ()
    {
        number--;
        if (number == 2)
        {
            level = 1;
            copyOver (b, b2);
            copyOver (r, b1);
        }
        else if (number == 3)
        {
            level = 2;
            copyOver (b, b3);
            copyOver (r, b2);
        }
        else if (number == 4)
        {
            level = 3;
            copyOver (b, b4);
            copyOver (r, b3);
        }
        else if (number == 5)
        {
            level = 4;
            copyOver (b, b5);
            copyOver (r, b4);
        }
        else if (number == 6)
        {
            level = 5;
            copyOver (b, b6);
            copyOver (r, b5);
        }
        else if (number == 7)
        {
            level = 6;
            copyOver (b, b7);
            copyOver (r, b6);
        }
        else if (number == 8)
        {
            level = 7;
            copyOver (b, b8);
            copyOver (r, b7);
        }
        else if (number == 9)
        {
            level = 8;
            copyOver (b, b9);
            copyOver (r, b8);
        }
        else
        {
            copyOver (b, b1);
            copyOver (r, b9);
            number = 1;
        }
        redraw ();

    }


    public void actionPerformed (ActionEvent e)
    { //ACTIONPERFORMED
        i++;
        z.setValue (i);
        if (e.getActionCommand ().equals ("card1"))
        {
            cdLayout.show (p_card, "1");
        }
        else if (e.getActionCommand ().equals ("card2"))
        {
            JOptionPane.showMessageDialog (null, "By: Ravi Thanarajah", "Simpsons", JOptionPane.INFORMATION_MESSAGE);
            cdLayout.show (p_card, "2");
        }
        else if (e.getActionCommand ().equals ("card3"))
        {
            cdLayout.show (p_card, "3");
        }
        else if (e.getActionCommand ().equals ("card4"))
        {
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl1"))
        {
            level = 1;
            number = 1;
            copyOver (b, b1);
            copyOver (r, b1);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl2"))
        {
            level = 2;
            number = 2;
            copyOver (b, b2);
            copyOver (r, b2);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl3"))
        {
            level = 3;
            number = 3;
            copyOver (b, b3);
            copyOver (r, b3);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl4"))
        {
            level = 4;
            number = 4;
            copyOver (b, b4);
            copyOver (r, b4);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl5"))
        {
            level = 5;
            number = 5;
            copyOver (b, b5);
            copyOver (r, b5);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl6"))
        {
            level = 6;
            number = 6;
            copyOver (b, b6);
            copyOver (r, b6);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl7"))
        {
            level = 7;
            number = 7;
            copyOver (b, b7);
            copyOver (r, b7);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl8"))
        {
            level = 8;
            number = 8;
            copyOver (b, b8);
            copyOver (r, b8);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl9"))
        {
            level = 9;
            number = 9;
            copyOver (b, b9);
            copyOver (r, b9);
            redraw ();
            cdLayout.show (p_card, "4");
        }
        else if (e.getActionCommand ().equals ("lvl10"))
        {
            level = 10;
            number = 10;
            copyOver (b, b9);
            copyOver (r, b9);
            redraw ();
            cdLayout.show (p_card, "4");
        }

        //RESET
        else if (e.getActionCommand ().equals ("reset"))
        {
            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    b [i] [j] = r [i] [j];
                }
            }
            redraw ();
        }

        //SETTINGS
        else if (e.getActionCommand ().equals ("settings"))
        {
            cdLayout.show (p_card, "3");
        }

        //INSTRUCTIONS
        else if (e.getActionCommand ().equals ("instruct"))
        {
            soundEffect ("danger");
            cdLayout.show (p_card, "2");
        }
        //NEXT
        else if (e.getActionCommand ().equals ("next"))
        {
            next ();
        }
        //PREVIOUS
        else if (e.getActionCommand ().equals ("previous"))
        {
            previous ();
        }
        //Sound Effect
        else if (e.getActionCommand ().equals ("haha"))
        {
            soundEffect ("haha");
        }
        //Save
        else if (e.getActionCommand ().equals ("save"))
        {
            save ("file.txt");
        }
        else if (e.getActionCommand ().equals ("open"))
        {
            openfile ("file.txt");
        }

        //DIRECTIONS
        else
        {
            int n = Integer.parseInt (e.getActionCommand ());
            if (last == -1)
            {
                last = n;
            }
            else
            {
                if (canGoLeft (last, n))
                    swap (last, n);
                else if (canGoRight (last, n))
                    swap (last, n);
                else if (canGoDown (last, n))
                    swap (last, n);
                else if (canGoUp (last, n))
                    swap (last, n);
                last = -1;
            }
            redraw ();
            i = countDone ();
            //update
        }
        if (win ())
            JOptionPane.showMessageDialog (null, "Nice", "Winner", JOptionPane.INFORMATION_MESSAGE);

    }


    public void save (String filename)
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter (new FileWriter ("saves.txt"));
            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    out.println (b [i] [j]);
                }
            }
            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    out.println (r [i] [j]);
                }
            }
            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    out.println (ans [i] [j]);
                }
            }
            out.println (level);
            out.close ();
        }


        catch (IOException e)
        {
            System.out.println ("Error opening file " + e);
        }
    }



    public void openfile (String filename)
    {
        BufferedReader in;
        try
        {
            in = new BufferedReader (new FileReader ("saves.txt"));

            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    b [i] [j] = Integer.parseInt (in.readLine ());

                }
            }
            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    r [i] [j] = Integer.parseInt (in.readLine ());

                }
            }
            for (int i = 0 ; i < row ; i++)
            {
                for (int j = 0 ; j < col ; j++)
                {
                    ans [i] [j] = Integer.parseInt (in.readLine ());

                }
            }
            level = Integer.parseInt (in.readLine ());
            in.close ();
        }
        catch (IOException e)
        {
            System.out.println ("Error opening file " + e);
        }
    }



    public void soundEffect (String filepath)
    {
        //initialize objects
        //declare sound effect player
        AudioPlayer SEP = AudioPlayer.player;
        //declare sound effect
        AudioStream SE;
        //declare audio data
        AudioData MA;
        //set as single run (NOT LOOP)
        AudioDataStream play = null;

        try
        {
            //set file
            SE = new AudioStream (new FileInputStream (filepath + ".wav"));
            MA = SE.getData ();
            //set data to play once (NOT LOOP)
            play = new AudioDataStream (MA);
        }
        catch (IOException error)
        {
            System.out.println ("Audio - File not found.");
        }
        SEP.start (play);
    }


    public void reset ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                b [i] [j] = r [i] [j];
            }
        }
        redraw ();
    }


    protected static ImageIcon createImageIcon (String path)
    {
        java.net.URL imgURL = Puzzle15.class.getResource (path);
        if (imgURL != null)
        {
            return new ImageIcon (imgURL);
        }


        else
        {
            System.err.println ("Couldn't find file: " + path);
            return null;

        }
    }
}

