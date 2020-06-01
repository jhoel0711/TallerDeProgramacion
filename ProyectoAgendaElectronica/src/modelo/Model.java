package Modelo;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Model {
	
	Menu ventana1;
	private JTextArea textArea;
	String texto;	

	public Model() {
		textArea=new JTextArea();
		texto=new String();
		ventana1 = new Menu();	}
	
	public String getdevolvertexto() {
		
		texto=textArea.getText();
		return texto;
	}
	public void setTexto(String txt) {
		
		texto=txt;
	}
	
	
	
	public void abrirArchivo() {
        System.out.println("Abrir archivo!!!");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(ventana1) == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();

            try {
                List<String> lineas = Files.readAllLines(Paths.get(path));

                for (String linea: lineas) {
                    textArea.append(linea+"\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	

}
