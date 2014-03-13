package org.uva.sea.ql.gui.startIDE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class IDEButtons {
	
	private JFrame frame;
	private JTextArea input;
	
	public IDEButtons(JFrame frame, JTextArea input){
		this.frame = frame;
		this.input = input;
	}

	public JButton loadButton() {
		JButton loadButton = new JButton("Load file");
		loadButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileFilter() {
			        @Override
			        public boolean accept(File f) {
			            if (f.isDirectory()) {
			                return true;
			            }
			            final String name = f.getName();
			            return name.endsWith(".dsl") || name.endsWith(".txt");
			        }

			        @Override
			        public String getDescription() {
			            return "*.dsl,*.txt";
			        }
				});
				
				int returnVal = fc.showOpenDialog(frame);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
					try {
						printFileToField(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					
				}
			}
		});
		
		return loadButton;
	}
	
	public JButton saveButton(){
		JButton saveButton = new JButton("Save file");
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BufferedWriter buffwriter = null;
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File("/home/me/Documents"));
			    int retrival = chooser.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION) {
					try {
							File file = new File(chooser.getSelectedFile()+".dsl");
							file.createNewFile();
						    buffwriter = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".dsl"));
						    buffwriter.write(input.getText());
						} 
					catch (UnsupportedEncodingException e1) {
							e1.printStackTrace();
						} 
					catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} 
					catch (IOException e1) {
							e1.printStackTrace();
						} 
					finally {
							try {
								buffwriter.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}

					} 
				}
			}
		});
		
		return saveButton;
	}
	
	public void printFileToField(File file) throws IOException {
		   BufferedReader br = new BufferedReader(new FileReader(file));
		    try {
		        String line = br.readLine();
		        while (line != null) {
		            input.append(line + '\n');
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
		
	}
}
