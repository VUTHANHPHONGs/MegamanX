
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.userinterface;

import GameObject.GameWorld;
import com.mycompany.effect.CacheDataLoader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.Card;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ThisPC
 */
public class GameFrame_Multi_Player_Mode extends JFrame{
    //kich_thuoc_man_game
    public static final int SCREEN_WIDTH=1000;
    public static final int SCREEN_HEIGHT=600;

    GamePanel gamePanel;
    public GameFrame_Multi_Player_Mode(){
        
        Toolkit toolkit = this.getToolkit();
        //kich_thuoc 
        Dimension dimension = toolkit.getScreenSize();
        //xu_li_ngoai_le_do_CacheDataLoader
        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (Exception e) {
        }
        //dat_tai_vi_tri_trung tam_cua_man,kich thuoc 1000x600;
        this.setBounds((dimension.width-SCREEN_WIDTH)/2,
                (dimension.height-SCREEN_HEIGHT)/2 , SCREEN_WIDTH, SCREEN_HEIGHT);
        //dong_code_khi_dong_man
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       
        gamePanel = new GamePanel();
        add(gamePanel);       
        gamePanel.startGame();        
        this.addKeyListener(gamePanel);
    }
    public void startGame(){
        gamePanel.startGame();
    }
    public static void main(String[] args) {        
        GameFrame_Multi_Player_Mode gameFrame = new GameFrame_Multi_Player_Mode();
        gameFrame.setTitle("MegaMan_Java");
        gameFrame.setVisible(true);
        gameFrame.startGame();  
    }   
}
//3.17