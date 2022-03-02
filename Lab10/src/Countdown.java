import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import javax.swing.Timer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
public class Countdown {

	protected Shell shell;
	private Text text1;
	private Text text2;
	private Text text3;
	
	Timer timer;
	int sec,min,hour;
	int usesec1,usesec2,usesec3;
	String sec1= "";
	String min1= "";
	String hour1= "";
	private Label la3;
	private Label la2;
	private Label la1;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Countdown window = new Countdown();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(364, 275);
		shell.setText("Count down");
		
		text1 = new Text(shell, SWT.BORDER);
		text1.setBounds(10, 67, 84, 34);
		
		text2 = new Text(shell, SWT.BORDER);
		text2.setBounds(132, 67, 84, 34);
		
		text3 = new Text(shell, SWT.BORDER);
		text3.setBounds(254, 67, 84, 34);
		
		Button button1 = new Button(shell, SWT.NONE);
		button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hour1 = text1.getText();
				la1.setText(hour1);
				usesec1 = Integer.parseInt(hour1);
				
				min1 = text2.getText();
				la2.setText(min1);
				usesec2 = Integer.parseInt(min1);
				
				sec1 = text3.getText();		
				la3.setText(sec1);	
				usesec3 = Integer.parseInt(sec1);
				
				new Thread(new Runnable() {
				      public void run() {
				         while (true) {
				            try { Thread.sleep(1000); } catch (Exception e) { }
				            Display.getDefault().asyncExec(new Runnable() {
				               public void run() {
				            	   if(usesec3 < 62){
					   					usesec3--;
										String usetime3 = Integer.toString(usesec3);
										//JOptionPane.showMessageDialog(null,"show number get: "+usetime1);
										la3.setText(""+usetime3);
										if(usesec3 == 0) {
											usesec3 = 60;
											if(usesec2 == 0) {
												usesec2 = 60;
												usesec1--;
												String usetime1 = Integer.toString(usesec1);
												la1.setText(""+usetime1);
											}
										usesec2--;
										String usetime2 = Integer.toString(usesec2);
										la2.setText(""+usetime2);
				            	     }
				            	  }
				               }
				            }); //if(usesec1 == 0) {
				            	//	break;
				            	//}
				            
				         }
				      }
				   }).start();
			}
		});
		button1.setBounds(80, 153, 174, 52);
		button1.setText("Submit Stop Setting");
		
		la3 = new Label(shell, SWT.NONE);
		la3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		la3.setBounds(276, 40, 24, 21);
		la3.setText("0");
		
		la2 = new Label(shell, SWT.NONE);
		la2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		la2.setBounds(156, 40, 24, 21);
		la2.setText("0");
		
		la1 = new Label(shell, SWT.NONE);
		la1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		la1.setText("0");
		la1.setBounds(32, 40, 24, 21);
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel.setBounds(307, 40, 44, 21);
		lblNewLabel.setText("\u0E27\u0E34\u0E19\u0E32\u0E17\u0E35");
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel_1.setText("\u0E19\u0E32\u0E17\u0E35");
		lblNewLabel_1.setBounds(188, 40, 39, 21);
		
		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel_2.setText("\u0E0A\u0E31\u0E48\u0E27\u0E42\u0E21\u0E07");
		lblNewLabel_2.setBounds(62, 40, 44, 21);

	}

}
