package com.java;

import lombok.extern.java.Log;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Log
public class ImgUtil {
    public static List<String> convertPDFPagesToImages(String sourceFilePath, String desFilePath){
        List<String> urlList = new ArrayList<>();
        try {
            File sourceFile = new File(sourceFilePath);
            File destinationFile = new File(desFilePath);
            if (!destinationFile.exists()) {
                destinationFile.mkdir();
                log.info("Folder Created ->:{} ", destinationFile.getAbsolutePath());
            }
            if (sourceFile.exists()) {
                log.info("Images copied to Folder Location: ", destinationFile.getAbsolutePath());
                PDDocument document = PDDocument.load(sourceFile);
                PDFRenderer pdfRenderer = new PDFRenderer(document);

                int numberOfPages = document.getNumberOfPages();
                log.info("Total files to be converting ->{} ", numberOfPages);

                String fileName = sourceFile.getName().replace(".pdf", "");
                String fileExtension = "png";
                /*
                 * 600 dpi give good image clarity but size of each image is 2x times of 300 dpi.
                 * Ex:  1. For 300dpi 04-Request-Headers_2.png expected size is 797 KB
                 *      2. For 600dpi 04-Request-Headers_2.png expected size is 2.42 MB
                 */
                int dpi = 300;// use less dpi for to save more space in harddisk. For professional usage you can use more than 300dpi

                for (int i = 0; i < numberOfPages; ++i) {
                    File outPutFile = new File(desFilePath + fileName +"_"+ (i+1) +"."+ fileExtension);
                    BufferedImage bImage = pdfRenderer.renderImageWithDPI(i, dpi, ImageType.RGB);
                    ImageIO.write(bImage, fileExtension, outPutFile);
                    urlList.add(outPutFile.getPath().replaceAll("\\\\", "/"));
                }

                document.close();
                log.info("Converted Images are saved at ->{} ", destinationFile.getAbsolutePath());
            } else {
                log.error(sourceFile.getName() +" File not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlList;
    }

    public static void main(String[] args) {

        convertPDFPagesToImages("D:\\tmp\\report\\pdfPath\\61199020100754118.pdf", "D:\\tmp\\report\\pdfPath\\");

    }
}
