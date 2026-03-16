package com.harshit.traffic_system.pdf;

import com.harshit.traffic_system.model.Challan;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ChallanPdfGenerator {

    public static void generatePdf(Challan challan) {

        try {

            Document document = new Document();

            PdfWriter.getInstance(document,
                    new FileOutputStream("challan_" + challan.getId() + ".pdf"));

            document.open();

            document.add(new Paragraph("Traffic Challan Receipt"));
            document.add(new Paragraph("-------------------------------"));

            document.add(new Paragraph("Vehicle Number: " + challan.getVehicleNumber()));
            document.add(new Paragraph("Offense: " + challan.getOffenseType()));
            document.add(new Paragraph("Fine Amount: " + challan.getFineAmount()));
            document.add(new Paragraph("Status: " + challan.getStatus()));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}