package com.sample.core.controller.ticket;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@WebServlet("/GenerarTicketVoto")
public class GenerarTicketVoto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Indica que la respuesta será un PDF
        response.setContentType("application/pdf");
        // Indica al navegador que el PDF se descargue
        response.setHeader("Content-Disposition", "attachment; filename=\"ticket_voto.pdf\"");

        // Escribiendo el PDF directamente en la respuesta HTTP
        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Datos de prueba (luego los podés sacar de sesión o de DB)
        document.add(new Paragraph("TICKET DE VOTACIÓN"));
        document.add(new Paragraph("DNI: 12345678"));
        document.add(new Paragraph("Nombre: Juan Perez"));
        document.add(new Paragraph("Distrito: Capital Federal"));
        document.add(new Paragraph("Mesa: 15"));
        document.add(new Paragraph("Fecha: 17/06/2025"));

        document.close();
    }
}
