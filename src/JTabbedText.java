import javax.swing.*;

public class JTabbedText extends JFrame{
	public static void main(String []args){
		JTabbedText frame=new JTabbedText();
		frame.setLocationRelativeTo(null);
		frame.setSize(500,300);
		frame.setTitle("hello");
		frame.setVisible(true);
	}
	public JTabbedText(){
		JTabbedPane pane=new JTabbedPane();
		JPanel pane1=new JPanel();
		pane1.add(new JLabel("adf"));
		JPanel pane2=new JPanel();
		pane2.add(new JLabel("zxcv"));
		pane.addTab("hello", pane1);
		pane.addTab("world", pane2);
		add(pane);
	}
}

//Œ“æÕ ‘ ‘