package com.yarasingu.QRcodes;


    
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRcodes {

    // This code is used for decode the QR Given in png 
    public static void main(String[] args) {
        File qrCodeFile = new File("qrcode.png"); // Replace with the path to your QR code image
        try {
            BufferedImage bufferedImage = ImageIO.read(qrCodeFile);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            Result result = new MultiFormatReader().decode(binaryBitmap);
            System.out.println("Decoded text: " + result.getText());
        } catch (NotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

