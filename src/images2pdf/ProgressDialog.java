package images2pdf;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressDialog extends JDialog implements WindowListener {
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton cancelButton;
	private boolean isCancelled = false;
	
	public ProgressDialog(Component parentComponent) {
		super();
		addWindowListener(this);
		setTitle("Postęp operacji");
		setAlwaysOnTop(true);
		setSize(300, 100);
		setLayout(null);
		label = new JLabel();
		label.setBounds(0, 0, 300, 30);
		add(label);
		cancelButton = new JButton("Anuluj");
		cancelButton.setBounds(200, 40, 80, 25);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isCancelled = true;	
			}
		});
		add(cancelButton);
	}

	public void stepForward(String filePath) {
		label.setText(filePath);
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		p.x -= getWidth()/2;
		p.y -= getHeight()/2;
		setLocation(p);
	}
}
