package gui.observers;

import gui.render.State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import ast.expr.Identifier;
import ast.value.Value;

public class FormSubmission implements ActionListener{
	
	private Identifier id;
	private State state; 
	
	public FormSubmission(Identifier id, State state) {
		this.id = id;
		this.state = state;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		File file = new File("..\\QLanguage\\src\\gui\\render\\out.txt");
		FileWriter fw;
		try{
			fw = new FileWriter(file, true);
			PrintWriter printer = new PrintWriter(fw);
			printer.append("#########  " + id.getIdentName() + "  #########\n");
			for(Entry<Identifier, Value> entry: state.getEnvValues().entrySet()){
				printer.append(entry.getKey().getIdentName() + " : " + entry.getValue().getValue() + "\n");
			}
			printer.close();
	 	} catch (IOException e) {
	 		 e.printStackTrace();
	 	}
	}

}
