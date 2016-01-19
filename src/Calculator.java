import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{
	final double MAX=Double.MAX_VALUE;
	
	
	private JButton jbt1=new JButton("1");
	private JButton jbt2=new JButton("2");
	private JButton jbt3=new JButton("3");
	private JButton jbt4=new JButton("4");
	private JButton jbt5=new JButton("5");
	private JButton jbt6=new JButton("6");
	private JButton jbt7=new JButton("7");
	private JButton jbt8=new JButton("8");
	private JButton jbt9=new JButton("9");
	private JButton jbt0=new JButton("0");
	private JButton jbtPlu=new JButton("+");
	private JButton jbtSub=new JButton("-");
	private JButton jbtMul=new JButton("*");
	private JButton jbtDiv=new JButton("/");
	private JButton jbtSqr=new JButton("Sqrt");
	private JButton jbtMod=new JButton("MOD");
	private JButton jbtRec=new JButton("1/x");
	private JButton jbtInv=new JButton("¡À");
	private JButton jbtBak=new JButton("Back");
	private JButton jbtCleanE=new JButton("CE");		//CE
	private JButton jbtClean=new JButton("C");		//C
	private JButton jbtPnt=new JButton(".");
	private JButton jbtEqu=new JButton("=");
	
	private JTextField jtfScreen=new JTextField(30);
	private JTextField jtfSign=new JTextField(1);
	
	private double num1=MAX,num2=MAX,res=MAX;
	private char operateType=' ';
	private String tempInput="";
	private boolean pointed=false;
	private boolean sign=true;	//trueÕý false¸º
	
	
	public static void main(String[] args){
		Calculator frame=new Calculator();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public Calculator(){
		JPanel jpScreen=new JPanel(new FlowLayout());
		jpScreen.add(jtfSign);
		jpScreen.add(jtfScreen);
		add(jpScreen, BorderLayout.NORTH);
		
		JPanel jpFunctionButtons=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jpFunctionButtons.add(jbtCleanE);
		jpFunctionButtons.add(jbtClean);
		jpFunctionButtons.add(jbtBak);
		add(jpFunctionButtons,BorderLayout.CENTER);
		
		JPanel jpButtons=new JPanel(new GridLayout(4, 5));
		jpButtons.add(jbt7);
		jpButtons.add(jbt8);
		jpButtons.add(jbt9);
		jpButtons.add(jbtDiv);
		jpButtons.add(jbtSqr);
		jpButtons.add(jbt4);
		jpButtons.add(jbt5);
		jpButtons.add(jbt6);
		jpButtons.add(jbtMul);
		jpButtons.add(jbtMod);
		jpButtons.add(jbt1);
		jpButtons.add(jbt2);
		jpButtons.add(jbt3);
		jpButtons.add(jbtSub);
		jpButtons.add(jbtRec);
		jpButtons.add(jbt0);
		jpButtons.add(jbtInv);
		jpButtons.add(jbtPnt);
		jpButtons.add(jbtPlu);
		jpButtons.add(jbtEqu);
		add(jpButtons,BorderLayout.SOUTH);
		
		jbt0.addActionListener(new ButtonsListener());
		jbt1.addActionListener(new ButtonsListener());
		jbt2.addActionListener(new ButtonsListener());
		jbt3.addActionListener(new ButtonsListener());
		jbt4.addActionListener(new ButtonsListener());
		jbt5.addActionListener(new ButtonsListener());
		jbt6.addActionListener(new ButtonsListener());
		jbt7.addActionListener(new ButtonsListener());
		jbt8.addActionListener(new ButtonsListener());
		jbt9.addActionListener(new ButtonsListener());
		jbtPlu.addActionListener(new ButtonsListener());
		jbtSub.addActionListener(new ButtonsListener());
		jbtDiv.addActionListener(new ButtonsListener());
		jbtMul.addActionListener(new ButtonsListener());
		jbtSqr.addActionListener(new ButtonsListener());
		jbtMod.addActionListener(new ButtonsListener());
		jbtRec.addActionListener(new ButtonsListener());
		jbtInv.addActionListener(new ButtonsListener());
		jbtBak.addActionListener(new ButtonsListener());
		jbtCleanE.addActionListener(new ButtonsListener());
		jbtClean.addActionListener(new ButtonsListener());
		jbtPnt.addActionListener(new ButtonsListener());
		jbtEqu.addActionListener(new ButtonsListener());
		
		jtfScreen.setEditable(false	);
		jtfSign.setEditable(false);
		jtfSign.setText(sign?"+":"-");
	}
	
	class ButtonsListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==jbt0){
				tempInput+="0";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt1){
				tempInput+="1";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt2){
				tempInput+="2";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt3){
				tempInput+="3";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt4){
				tempInput+="4";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt5){
				tempInput+="5";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt6){
				tempInput+="6";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt7){
				tempInput+="7";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt8){
				tempInput+="8";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbt9){
				tempInput+="9";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbtPnt && !pointed){
				tempInput+=".";
				pointed=true;
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbtInv){
				setSign(sign?false:true);
			}
			else if(event.getSource()==jbtBak){
				if(tempInput.length()>0){
					tempInput=tempInput.substring(0, tempInput.length()-1);
					setScreenText(tempInput);
				}
			}
			else if(event.getSource()==jbtCleanE){
				tempInput="";
				setScreenText(tempInput);
			}
			else if(event.getSource()==jbtClean){
				tempInput="";
				operateType=' ';
				num1=num2=res=MAX;
				setSign(true);
				setScreenText(tempInput);
			}
			
			else if(event.getSource()==jbtPlu){
				if(num1==MAX && num2==MAX && res==MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('+');
					setScreenText(tempInput="");
				}
				else if(num2==MAX && res==MAX && tempInput.length()!=0){
					num1+=Double.parseDouble(tempInput);
					setOperateType('+');
					tempInput="";
					setScreenText(num1+"");
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()==0){
					num1=res;
					res=MAX;
					//num2=Double.parseDouble(tempInput);
					setOperateType('+');
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('+');
					setScreenText(tempInput="");
				}
			}
			else if(event.getSource()==jbtSub){
				if(num1==MAX && num2==MAX && res==MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('-');
					setScreenText(tempInput="");
				}
				else if(num2==MAX && res==MAX && tempInput.length()!=0){
					num1+=Double.parseDouble(tempInput);
					setOperateType('-');
					tempInput="";
					setScreenText(num1+"");
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()==0){
					num1=res;
					res=MAX;
					//num2=Double.parseDouble(tempInput);
					setOperateType('-');
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('-');
					setScreenText(tempInput="");
				}
				else if(num1==MAX && num2==MAX && res==MAX && tempInput.length()==0){
					if(getSign())
						setSign(false);
					else 
						setSign(true);
				}
			}
			else if(event.getSource()==jbtMul){
				if(num1==MAX && num2==MAX && res==MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('*');
					setScreenText(tempInput="");
				}
				else if(num2==MAX && res==MAX && tempInput.length()!=0){
					num1+=Double.parseDouble(tempInput);
					setOperateType('*');
					tempInput="";
					setScreenText(num1+"");
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()==0){
					num1=res;
					res=MAX;
					//num2=Double.parseDouble(tempInput);
					setOperateType('*');
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('*');
					setScreenText(tempInput="");
				}
			}
			else if(event.getSource()==jbtDiv){
				if(num1==MAX && num2==MAX && res==MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('/');
					setScreenText(tempInput="");
				}
				else if(num2==MAX && res==MAX && tempInput.length()!=0){
					num1+=Double.parseDouble(tempInput);
					setOperateType('/');
					tempInput="";
					setScreenText(num1+"");
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()==0){
					num1=res;
					res=MAX;
					//num2=Double.parseDouble(tempInput);
					setOperateType('/');
				}
				else if(num1==MAX && num2==MAX && res!=MAX && tempInput.length()!=0){
					num1=Double.parseDouble(tempInput);
					if(!getSign())
						num1=-num1;
					setOperateType('/');
					setScreenText(tempInput="");
				}
			}
			else if(event.getSource()==jbtEqu){
				if(num2==MAX && getOperateType()!=' '){
					num2=Double.parseDouble(tempInput);
					switch(getOperateType()){
					case '+':
						res=num1+num2;
						setScreenText(res+"");
						tempInput="";
						num1=num2=MAX;
						setOperateType(' ');
						break;
					case '-':
						res=num1-num2;
						setScreenText(res+"");
						tempInput="";
						num1=num2=MAX;
						setOperateType(' ');
						break;
					case '*':
						res=num1*num2;
						setScreenText(res+"");
						tempInput="";
						num1=num2=MAX;
						setOperateType(' ');
						break;
					case '/':
						res=num1/num2;
						setScreenText(res+"");
						tempInput="";
						num1=num2=MAX;
						setOperateType(' ');
						break;
					case '%':
						res=num1%num2;
						setScreenText(res+"");
						tempInput="";
						num1=num2=MAX;
						setOperateType(' ');
						break;
					}
				}
				//else if(num1!=MAX)
			}
//			else if(event.getSource()=jbt){
//				
//			}
//			else if(event.getSource()=jbt){
//				
//			}
//			else if(event.getSource()=jbt){
//				
//			}
			
		}
	}
	
	private void setScreenText(String text){
		jtfScreen.setText(text);
	}
	
	private void setSign(boolean sign){
		this.sign=sign;
		jtfSign.setText(sign?"+":"-");
	}
	
	private String getText(){
		return tempInput;
	}
	
	private boolean getSign(){
		return sign;
	}
	
	private void setOperateType(char tyep){
		this.operateType=tyep;
	}
	
	private char getOperateType(){
		return this.operateType;
	}
}