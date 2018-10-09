import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;
 
public class Grid extends JFrame{
	int fileToOpen;
	int fileToSave;
	JFileChooser fileOpen;
	JFileChooser fileSave;
	Grid(){
		MenuBar menuBar = new MenuBar();
		
		
		MenuItem menutem = new MenuItem();
		MenuItem menutem1 = new MenuItem();
		final JTextArea textArea = new JTextArea();
		Font f = new Font("MS UI Gothic", Font.BOLD,18);
		textArea.setFont(f);
		setMenuBar(menuBar);
		Menu file = new Menu("File");
		Menu file1 = new Menu("Font Size");
		menuBar.add(file);
		menuBar.add(file1);
		MenuItem newOption = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem close = new MenuItem("Exit");
		MenuItem font1 = new MenuItem("40");
		MenuItem font2 = new MenuItem("60");
		file.add(newOption);
		file.add(open);
		file.add(save);
		file.add(close);
 		file1.add(font1);
		file1.add(font2);
		getContentPane().add(textArea);
 		textArea.setBackground(Color.LIGHT_GRAY); 
		newOption.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea.setText("");
				
    				textArea.setBackground(Color.LIGHT_GRAY); 
			}
		});


		font1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Font f6 = new Font("MS UI Gothic", Font.BOLD,40);
				textArea.setFont(f6);
			}
		});
		font2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Font f7 = new Font("MS UI Gothic", Font.BOLD,60);
				textArea.setFont(f7);
			}
		});
 
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFile();
				if (fileToOpen == JFileChooser.APPROVE_OPTION){
					textArea.setText("");
					textArea.setBackground(Color.LIGHT_GRAY); 
					try{
						Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
						while (scan.hasNext())
							textArea.append(scan.nextLine());
					} catch (Exception ex){
						System.out.println(ex.getMessage());
					}
				}
			}
		});
 
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveFile();
				if (fileToSave == JFileChooser.APPROVE_OPTION){
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
						out.write(textArea.getText());
						out.close();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		});
 
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
 
	public void openFile(){
		JFileChooser open = new JFileChooser();
		int option = open.showOpenDialog(this);
		fileToOpen = option;
		fileOpen = open;
	}
 
	public void saveFile(){
		JFileChooser save = new JFileChooser();
		int option = save.showOpenDialog(this);
		fileToSave = option;
		fileSave = save;
	}
}