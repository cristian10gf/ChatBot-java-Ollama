package com.crisplant.chat;

import com.crisplant.chat.ui.main;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Insets;
import javax.swing.UIManager;

public class Chat {

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        UIManager.put( "Button.arc", 75);
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        main ventanaP = new main();
        ventanaP.setVisible(true);
    }
}
