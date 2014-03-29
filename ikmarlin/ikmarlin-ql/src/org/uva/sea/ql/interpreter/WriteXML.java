package org.uva.sea.ql.interpreter;


import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.interpreter.value.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class WriteXML {
	
	String form;
	Map<String, Value<?>> values;
	String rootTag = "form";
	
	public WriteXML(Form form, Map<String, Value<?>> values){
		this.form = form.getIdent().getName();
		this.values = values;
	}
	
	public File writeFile(){
		File file = null;
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = null;
			Element root = null;
			
			file = new File("C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\results\\"+form+".xml");
			if(file.exists()){
				doc = docBuilder.parse(file);
				root = doc.getDocumentElement();
			}else{
				doc = docBuilder.newDocument();
				root = doc.createElement(rootTag);
				doc.appendChild(root);
				root.setAttribute("id", form);
			}
			Element result = doc.createElement("result");
			root.appendChild(result);
			
			for(Map.Entry<String, Value<?>> entry : values.entrySet()){
				Element value = doc.createElement(entry.getKey());
				value.appendChild(doc.createTextNode(entry.getValue().toString()));
				result.appendChild(value);
			}

			DOMSource source = new DOMSource(doc);
			StreamResult results = new StreamResult(file);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(source, results);
 		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return file;
	}

}
