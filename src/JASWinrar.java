
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe para manipular e criar arquivos compactados com Winrar.
 * @author Julian Santos
 * @version 1.0
 * @since 07/05/2018
 */
public class JASWinrar {
    
    // CONSTANTS
    final String TYPE_RAR = "-afrar";
    final String TYPE_ZIP = "-afzip";
    final String METHOD_0_SORE = "-m0";
    final String METHOD_1_FASTEST = "-m1";
    final String METHOD_2_FAST = "-m2";
    final String METHOD_3_NORMAL = "-m3";
    final String METHOD_4_GOOD = "-m4";
    final String METHOD_5_BEST = "-m5";
    
    private File fileWinrar;
    
    private String prompt;
    private String compressionProfile;
    private String compressionMethod;
    private String password;
    
    private final boolean background = true;
    private boolean deleteFilesAfterArchiving = false;
    private boolean onlyInternalFiles = true;
    private boolean recursive = true;
    private boolean yesOnAll = false;
    private boolean waitWinrar = true;

    public JASWinrar(File fileWinrar) {
        this.fileWinrar = fileWinrar;
    }
    
    /**
     * Método para criar arquivo rar ou zip.
     * @param fileFrom - Arquivo ou diretório de origem a ser compactado.
     * @param fileTo - Arquivo rar/zip a ser criado.
     * @param type - Tipo de compressão a ser utilizado.
     */
    public void addTo(File fileFrom, File fileTo, String type) {
        
        if (fileWinrar.isFile() && fileFrom.isFile() && (type.equals("-afrar") || type.equals("-afzip"))) {
            
            prompt = "";
            prompt += "\"" + fileWinrar.getAbsoluteFile().toString() + "\" ";
            prompt += " a " + type;
            
            if (deleteFilesAfterArchiving) {
                prompt += "-dr ";
            }
            
            if (recursive) {
                prompt += "-r ";
            }
            
            if (background) {
                prompt += "-IBCK ";
            }
            
            if (onlyInternalFiles) {
                prompt += "-ep1 ";
            }
            
            if (yesOnAll) {
                prompt += "-y ";
            }
            
            if (!compressionProfile.isEmpty()) {
                prompt += "-cp" + compressionProfile + " ";
            }
            
            if (!password.isEmpty()) {
                prompt += "-p" + password + " ";
            }
            
            if (!compressionMethod.isEmpty()) {
                prompt +=  compressionMethod + " ";
            }
            
            prompt += "\"" + fileTo.getAbsoluteFile().toString() + "\" ";
            prompt += "\"" + fileFrom.getAbsoluteFile().toString() + "\" ";
            
            try {
                if (waitWinrar) {
                    Runtime.getRuntime().exec(prompt).waitFor();
                } else {
                    Runtime.getRuntime().exec(prompt);
                }
            } catch (IOException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    
    /**
     * Método para criar arquivo rar.
     * @param fileFrom - Arquivo ou diretório de origem a ser compactado.
     * @param fileTo - Arquivo rar/zip a ser criado.
     */
    public void addToRar(File fileFrom, File fileTo) {

        if (fileWinrar.isFile() && fileFrom.isFile()) {
            
            prompt = "";
            prompt += "\"" + fileWinrar.getAbsoluteFile().toString() + "\" ";
            prompt += " a -afrar ";
            
            if (deleteFilesAfterArchiving) {
                prompt += "-dr ";
            }
            
            if (recursive) {
                prompt += "-r ";
            }
            
            if (background) {
                prompt += "-IBCK ";
            }
            
            if (onlyInternalFiles) {
                prompt += "-ep1 ";
            }
            
            if (yesOnAll) {
                prompt += "-y ";
            }
            
            if (!compressionProfile.isEmpty()) {
                prompt += "-cp" + compressionProfile + " ";
            }
            
            if (!password.isEmpty()) {
                prompt += "-p" + password + " ";
            }
            
            if (!compressionMethod.isEmpty()) {
                prompt +=  compressionMethod + " ";
            }
            
            prompt += "\"" + fileTo.getAbsoluteFile().toString() + "\" ";
            prompt += "\"" + fileFrom.getAbsoluteFile().toString() + "\" ";
            
            try {
                if (waitWinrar) {
                    Runtime.getRuntime().exec(prompt).waitFor();
                } else {
                    Runtime.getRuntime().exec(prompt);
                }
            } catch (IOException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    
    /**
     * Método para criar arquivo zip.
     * @param fileFrom - Arquivo ou diretório de origem a ser compactado.
     * @param fileTo - Arquivo rar/zip a ser criado.
     */
    public void addToZip(File fileFrom, File fileTo) {

        if (fileWinrar.isFile() && fileFrom.isFile()) {
            
            prompt = "";
            prompt += "\"" + fileWinrar.getAbsoluteFile().toString() + "\" ";
            prompt += " a -afzip ";
            
            if (deleteFilesAfterArchiving) {
                prompt += "-dr ";
            }
            
            if (recursive) {
                prompt += "-r ";
            }
            
            if (background) {
                prompt += "-IBCK ";
            }
            
            if (onlyInternalFiles) {
                prompt += "-ep1 ";
            }
            
            if (yesOnAll) {
                prompt += "-y ";
            }
            
            if (!compressionProfile.isEmpty()) {
                prompt += "-cp" + compressionProfile + " ";
            }
            
            if (!password.isEmpty()) {
                prompt += "-p" + password + " ";
            }
            
            if (!compressionMethod.isEmpty()) {
                prompt +=  compressionMethod + " ";
            }
            
            prompt += "\"" + fileTo.getAbsoluteFile().toString() + "\" ";
            prompt += "\"" + fileFrom.getAbsoluteFile().toString() + "\" ";
            
            try {
                if (waitWinrar) {
                    Runtime.getRuntime().exec(prompt).waitFor();
                } else {
                    Runtime.getRuntime().exec(prompt);
                }
            } catch (IOException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } 
    }
    
    /**
     * Método para extrar arquivo rar/zip.
     * @param fileFrom - Arquivo de origem a ser descompactado.
     * @param fileTo - Diretorio de destino para descompressão.
     */
    public void extractTo (File fileFrom, File fileTo) {

        if (fileWinrar.isFile() && fileFrom.isFile() && fileTo.isDirectory()) {
            
            prompt = "";
            prompt += "\"" + fileWinrar.getAbsoluteFile().toString() + "\" ";
            prompt += " x ";
            
            if (background) {
                prompt += "-IBCK ";
            }
            
            if (yesOnAll) {
                prompt += "-y ";
            }
            
            prompt += "\"" + fileFrom.getAbsoluteFile().toString() + "\" ";
            prompt += "\"" + fileTo.getAbsoluteFile().toString() + "\" ";
            
            try {
                if (waitWinrar) {
                    Runtime.getRuntime().exec(prompt).waitFor();
                } else {
                    Runtime.getRuntime().exec(prompt);
                }
            } catch (IOException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JASWinrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            
        }
    }
    
}
