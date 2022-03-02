import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Alert {

	protected Shell shell;
	private Text H;
	private Text M;
	private Text S;
	public int h = 0;
	public int m = 0;
	public int s = 0;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Alert window = new Alert();
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
		shell.setSize(450, 300);
		shell.setText("Alert");
		Main1 M1 = new Main1();
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 30, SWT.NORMAL));
		lblNewLabel.setBounds(50, 33, 73, 30);
		lblNewLabel.setText("Hour");
		
		H = new Text(shell, SWT.BORDER);
		H.setBounds(36, 80, 93, 51);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				h = Integer.parseInt(H.getText());	
				m = Integer.parseInt(M.getText());	
				s = Integer.parseInt(S.getText());	

				
				M1.ah = h;
				M1.am = m;
				M1.as = s;

				shell.close();
				
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 21, SWT.NORMAL));
		btnNewButton.setBounds(31, 158, 375, 70);
		btnNewButton.setText("Summit Alert Setting");
		
		M = new Text(shell, SWT.BORDER);
		M.setBounds(176, 80, 93, 51);
		
		S = new Text(shell, SWT.BORDER);
		S.setBounds(313, 80, 93, 51);
		
		Label lblMinute = new Label(shell, SWT.NONE);
		lblMinute.setText("Minute");
		lblMinute.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 30, SWT.NORMAL));
		lblMinute.setBounds(176, 33, 93, 30);
		
		Label lblNewLabel_3_1 = new Label(shell, SWT.NONE);
		lblNewLabel_3_1.setText("Second");
		lblNewLabel_3_1.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 30, SWT.NORMAL));
		lblNewLabel_3_1.setBounds(306, 33, 110, 30);

	}
}
