/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Joshu
 */
public class Compresion {

    public void run() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int choice = fileChooser.showOpenDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            String zipFilePath = fileChooser.getCurrentDirectory().getAbsolutePath() + File.separator + "Reportes.zip";

            try {
                // Crear archivo ZIP
                FileOutputStream fos = new FileOutputStream(zipFilePath);
                ZipOutputStream zos = new ZipOutputStream(fos);

                for (File selectedFile : selectedFiles) {
                    compress(selectedFile, selectedFile.getName(), zos);
                }

                zos.close();
                fos.close();

                System.out.println("Archivos comprimidos exitosamente en: " + zipFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void compress(File file, String fileName, ZipOutputStream zos) throws IOException {
        if (file.isDirectory()) {
            // Comprimir carpeta
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File nestedFile : files) {
                    compress(nestedFile, fileName + File.separator + nestedFile.getName(), zos);
                }
            }
        } else {
            // Comprimir archivo
            byte[] buffer = new byte[1024];
            FileInputStream fis = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(fileName));

            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
            zos.closeEntry();
        }
    }
}
