package Modelo;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;





public class MControl implements ActionListener{

	Menu ventana;
	Model modelo;
	InterfazVista vista;	
	
	
	public MControl(Model modelo,InterfazVista vista) {
		this.modelo=modelo;
		this.vista=vista;
		ventana=new Menu();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(InterfazVista.ABRIR)) {
			
			modelo.abrirArchivo();
			vista.setTexto(modelo.getdevolvertexto());
			System.out.println("presionaste Abrir");
			
			
		}else {
			
			   if(e.getActionCommand().equals(InterfazVista.NUEVO)) {
				JOptionPane.showMessageDialog(null, "gracias");
				vista.limpiartexto();
				
			   }else {
			       	if(e.getActionCommand().equals(InterfazVista.GUARDAR)) {
					
					
					guardarArchivo();
					//JOptionPane.showMessageDialog(null,"");
					vista.limpiartexto();
					
			
					
			      	}else 
					
					   System.out.println("no seas puto ");
				
				
			  }
			
		}
			
			
	}
	private void guardarArchivo() {
        System.out.println("Guardar Archivo!!");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showSaveDialog(ventana) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            FileWriter escritor = null;

            try {
                escritor = new FileWriter(archivo);
                escritor.write(vista.getTexto());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    escritor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
		
		
	}
