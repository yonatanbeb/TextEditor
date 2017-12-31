import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;


public class MainWindow {

	protected Shell shell;
	protected StyledText styletext;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws Exception 
	 */
	
	public void open() throws Exception {
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




	String definitions = "";
	String sentence = "";
	
	
	protected void createContents() throws Exception {
		
//Creates Window		
		shell = new Shell();
		shell.setSize(800,600);
		shell.setBackground(new Color(null,192,192,192));
		shell.setText("Text Editor");
		
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 10;
		shell.setLayout(fillLayout);
		
		//Creates the outer Text(holds in it the three other composites containing the MULTI text areas)		
			Composite outer = new Composite(shell, 0);
			outer.setBackground(new Color(null,192,192,192));
		
			FormLayout formLayout = new FormLayout();
			formLayout.marginHeight = 15;
			formLayout.marginWidth = 15;
			formLayout.spacing = 15;
			outer.setLayout(formLayout);
		
				//Creates the inner top left Text(holds in it the main MULTI text area)		
					Text innertopleft = new Text(outer, SWT.MULTI);
					innertopleft.setBackground(new Color(null,255,255,255));
					innertopleft.setForeground(new Color(null,0,0,0));
		
					FormData fData = new FormData();
					fData.top = new FormAttachment(0);
					fData.left = new FormAttachment(0);
					fData.right = new FormAttachment(80); 
					fData.bottom = new FormAttachment(70);
					innertopleft.setLayoutData(fData);
				
				//Creates the inner right Text(holds in it the history MULTI text area)
					Text innerRight = new Text(outer, SWT.MULTI);
					innerRight.setBackground(new Color( null,255,255,255)); 
					innerRight.setForeground(new Color(null,0,0,0));
		
					fData = new FormData();
					fData.top = new FormAttachment(0);
					fData.left = new FormAttachment(innertopleft);
					fData.right = new FormAttachment(100);
					fData.bottom = new FormAttachment(100);
					innerRight.setLayoutData(fData);
		
				//Creates the area for inner bottom left text area and radio widget
					Composite bottomComposite = new Composite(outer, 0);
		
					FormLayout formLayout2 = new FormLayout();
					formLayout2.marginHeight = 0;
					formLayout2.marginWidth = 0;
					formLayout2.spacing = 0;
					bottomComposite.setLayout(formLayout2);
		
					fData = new FormData();
					fData.top = new FormAttachment(innertopleft);
					fData.left = new FormAttachment(0);
					fData.right = new FormAttachment(innerRight);
					fData.bottom = new FormAttachment(100);
					bottomComposite.setLayoutData(fData);
	
						//Radio Group
							Group radioGroup = new Group(bottomComposite, SWT.NONE);
							radioGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
							 
							fData = new FormData();
							fData.top = new FormAttachment(0);
							fData.left = new FormAttachment(0);
							fData.right = new FormAttachment(100);
							fData.bottom = new FormAttachment(25);
							radioGroup.setLayoutData(fData);
							
						//Creates Label for the radio group.
							Label label = new Label(radioGroup, SWT.NONE);
							label.setText("Function: ");
					
						//Radio widget
							Button wordDefineButton = new Button(radioGroup, SWT.RADIO);
							wordDefineButton.setText("Word Define");
							
							Button SearchSentence = new Button(radioGroup, SWT.RADIO);
							SearchSentence.setText("Search Sentence");
					
							Button WikipediaSearch = new Button(radioGroup, SWT.RADIO);
							WikipediaSearch.setText("Wikipedia Search");
							
							Button Clear = new Button(radioGroup, SWT.PUSH);
							Clear.setText("Reset");
						
					
						//Creates the inner bottom left Text(holds in it the MULTI text area)
							StyledText innerbottomleft = new StyledText(bottomComposite, SWT.MULTI);
							innerbottomleft.setBackground(new Color(null,255,255,255));
							innerbottomleft.setForeground(new Color(null,0,0,0));
							
							fData = new FormData();
							fData.top = new FormAttachment(radioGroup);
							fData.left = new FormAttachment(0);
							fData.right = new FormAttachment(100);
							fData.bottom = new FormAttachment(100);
							innerbottomleft.setLayoutData(fData);
		
							innerbottomleft.addKeyListener(new KeyAdapter(){
								public void keyPressed(KeyEvent e){
								
									if(e.keyCode == SWT.CR){
										//innerbottomleft.setText("");
										
										StyledText text = (StyledText) e.getSource();
										if(!text.getText().trim().isEmpty()){
											if(wordDefineButton.getSelection()){
												definitions = WordDefine.printWordDefine(text.getText().trim());
												text.setText(definitions);
									
											}
											
											if(SearchSentence.getSelection()){
												
												sentence = SentenceFinder3.printCompatibleSentence(innertopleft.getText().trim(),
																									text.getText().trim());
												text.setText(sentence);
											
											}
											
										}
									
										text.setCaretOffset(0);
						}
					}
				});
							
							Clear.addListener(SWT.Selection, new Listener() {
							      public void handleEvent(Event e) {
							          switch (e.type) {
							          case SWT.Selection:
							        	  innerbottomleft.setText("");
							        	  break;
							          }
							      }
							});
							
			}
		}

//copy drive version to new class(add alterations)
//Stop when when text is null