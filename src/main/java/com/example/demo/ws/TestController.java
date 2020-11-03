//package com.example.demo.ws;
//
//import com.example.demo.util.QrCodeUtils;
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @ClassName TestController
// * @Description TODO
// * @Autor ansonglin
// * @Date 2019/6/26 9:35
// * @Version 1.0
// **/
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//
//    private static final String QR_CODE_IMAGE_PATH = "D:\\a.png";
//
//    /**
//     * 生成二维码保存到指定路径
//     * @param response
//     */
//    @GetMapping("/qrCode")
//    public void QrCodeTest(HttpServletResponse response){
//        try {
//            QrCodeUtils.generateQRCodeImage("hello word", 100, 500,QR_CODE_IMAGE_PATH);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 生成二维码在前台展现
//     * @param requset
//     * @param response
//     */
//    @GetMapping("/qrCode01")
//    public void QrCodeTest(HttpServletRequest requset, HttpServletResponse response){
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//
//        BitMatrix bitMatrix = null;
//        try {
//            bitMatrix = qrCodeWriter.encode("hello word", BarcodeFormat.QR_CODE, 2500, 2500);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//        try {
//            MatrixToImageWriter.writeToStream(bitMatrix, "png", response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//