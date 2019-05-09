package QuickMaker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MakerFrame extends JFrame{

	public MakerFrame() {
			setSize(500, 500);
			setVisible(true);
			
			JPanel p = new JPanel();
			JTextArea text = new JTextArea();
			text.setPreferredSize(new Dimension(500,400));
			p.add(text);
			JButton button = new JButton();
			button.setText("make");
			button.setPreferredSize(new Dimension(50,20));
			CreateButtonAction createButtonAction = new CreateButtonAction();
			createButtonAction.setText(text);
			button.addActionListener(createButtonAction);
			p.add(button);
		    Container contentPane = getContentPane();
		    contentPane.add(p, BorderLayout.CENTER);

	}
}
