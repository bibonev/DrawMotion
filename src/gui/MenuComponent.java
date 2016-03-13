package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuComponent extends JPanel{
	public MenuComponent(){
		super();
        
       
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton clear = new JButton("Clear");
        clear.setVisible(true);
       
        JButton color = new JButton("Color");
        color.setVisible(false);
       
        buttons.add(clear);
        buttons.add(color);
       
        for(JButton button : buttons) {
            add(button,BorderLayout.NORTH);
        }
       
        JButton west = new JButton("\u25C4");
        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).isVisible()) {
                        buttons.get(i).setVisible(false);
                        if (i!= buttons.size() - 1) {
                            buttons.get(i+1).setVisible(true);
                        } else {
                            buttons.get(0).setVisible(true);
                        }
                    }
                    break;
                }
            }
        });
       
        JButton east = new JButton("\u25BA");
        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).isVisible()) {
                        buttons.get(i).setVisible(false);
                        if (i!= buttons.size() - 1) {
                            buttons.get(i-1).setVisible(true);
                        } else {
                            buttons.get(0).setVisible(true);
                        }
                    }
                    break;
                }
            }
        });
       

       
        setLayout(new BorderLayout());
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
	}
}
