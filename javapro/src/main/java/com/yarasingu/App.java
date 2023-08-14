package com.yarasingu;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

// import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        String text = "https://yarasingu.com"; // Change this to the desired URL or text

        int width = 300; // QR code width in pixels
        int height = 300; // QR code height in pixels
        String format = "png"; // QR code image format

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
            Path path = Paths.get("qrcode.png"); // Change this to the desired output file path
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);
            System.out.println("QR code generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

