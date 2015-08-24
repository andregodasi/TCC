/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorpngdicom;

import java.io.File;

/**
 *
 * @author ANDRE
 */
public class Conversor {
    private String caminhoXMedCon;
    private String caminhoDaImagem;
    private String nome;
    /**
     * Os nomes de variáveis declaradas constantes de classes e de constantes 
     * ANSI deve ser todo em letras maiúsculas com palavras separadas por sublinhados ("_").
     */
    static final String SEPARADOR = java.io.File.separator;
    static final String CAMINHO_DE_DESTINO = "C:" + SEPARADOR + "tcc" + SEPARADOR + "xmedcon_imagem_descricao";

    public String getCaminhoXMedCon() {
        return caminhoXMedCon;
    }

    public void setCaminhoXMedCon(String caminhoXMedCon) {
        this.caminhoXMedCon = caminhoXMedCon;
    }

    public String getCaminhoDaImagem() {
        return caminhoDaImagem;
    }

    public void setCaminhoDaImagem(String caminhoDaImagem) {
        this.caminhoDaImagem = caminhoDaImagem;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Verica se existe a pasta de destino no caminho C:tcc\xmedcon_imagem_descricao, caso não exista
     * ele cria as pastas.
     * @return 
     */
     public boolean verificaPastaDeDestino(){
        String nomeDiretorio;
        try {
            nomeDiretorio = "C:" + SEPARADOR + "tcc";
            if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
            }
            String nomeDiretorio_ = "C:" + SEPARADOR + "tcc" + SEPARADOR + "xmedcon_imagem_descricao";
            if (!new File(nomeDiretorio_).exists()) { // Verifica se o diretório existe.   
                (new File(nomeDiretorio_)).mkdir();   // Cria o diretório   
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao criar ou achar a pasta de destino. Erro: "+e);
        }
        return false;

    }
    
    /**
     * Inicializa o prompt de comando como administrador, e executa o comando 
     * passado pela o array de String.
     * @param cmds 
     */
     public void executaComandoDeLinha(String[] cmds) {
        try {
            ProcessBuilder builder;
            builder = new ProcessBuilder("cmd", "/c",
                    String.join("& ", cmds));
            Process p = builder.start();
        } catch (Exception e) {
            System.out.println("Erro na execusão de linha de comando:" + e);
        }
    }

}
