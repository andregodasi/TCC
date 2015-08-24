/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorpngdicom;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ANDRE
 */
public class ConversorPngDicom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int verificador = 0;
        Scanner scn = new Scanner(System.in);
        do{
        try{
        Conversor conversor = new Conversor();

        
        System.out.println("Conversor de imagem Dicom para PNG.");
        
        System.out.println("Digite o caminho da pasta bin do programa XMedCon.");
        conversor.setCaminhoXMedCon(scn.nextLine());
        
        System.out.println("Digite o caminho da imagem DICON.");
        conversor.setCaminhoDaImagem(scn.next());
        
        System.out.println("Digite o nome que deseja dar a nova imagem.");
        conversor.setNome(scn.next());
        
        if(!conversor.verificaPastaDeDestino()){
            System.out.println("Erro a verificar existência ou criar pasta no caminho C:\\tcc\\xmedcon_imagem_descricao");
        }
        
      
        String[] cmds = {"cd " + conversor.getCaminhoXMedCon(), 
            "medcon -f " + conversor.getCaminhoDaImagem() + " > " + conversor.CAMINHO_DE_DESTINO + conversor.SEPARADOR + conversor.getNome() + ".txt",
            "medcon -f " + conversor.getCaminhoDaImagem() + " -c png --output-name " + conversor.CAMINHO_DE_DESTINO + conversor.SEPARADOR + conversor.getNome()
        };
        
        conversor.executaComandoDeLinha(cmds);
        
        }catch(Exception e){
        
            System.out.println("erro "+e);
        }
        
        System.out.println("Deseja converter outra imagem \n se sim digite s \n caso não digite n");
        String ver = scn.next();
        if(ver.equals("s") || ver.equals("sim")){
            verificador = 0;
        }else{
            verificador = 1;
        }
        
        
    }while(verificador != 1);
   }
    
}
