/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Joshu
 */
public class Encriptacion {

   static String KEY = "JohnnyLovi";
    
    public static SecretKeySpec miClave(String key) throws NoSuchAlgorithmException{
        try {
            byte[] cadena = KEY.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec sKS = new SecretKeySpec(cadena, "AES");
            return sKS;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String encriptar(String cadena){
        try {
            SecretKeySpec sKS = miClave(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sKS);
            byte[] cadenaEncriptar = cadena.getBytes("UTF-8");
            byte[] cadenaEncriptada = cipher.doFinal(cadenaEncriptar);
            String mensajeEncriptado = Base64.getEncoder().encodeToString(cadenaEncriptada);
            return mensajeEncriptado;
        
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String desEncriptar(String cadena){
        try {
            SecretKeySpec sKS = miClave(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, sKS);
            byte[] cadenaDesencriptar = Base64.getDecoder().decode(cadena);
            byte[] cadenaDesencriptada = cipher.doFinal(cadenaDesencriptar);
            String mensajeDesencriptado = new String(cadenaDesencriptada);
            return mensajeDesencriptado;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
        
    }
}
