package com.sample.core.controller.ticket;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.sample.core.domain.LoginCiudadano;
import com.sample.core.domain.Padron;
import com.sample.core.service.LoginCiudadanoService;
import com.sample.core.service.LoginCiudadanoServiceImp;
import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;
import com.sample.core.service.MesaService;
import com.sample.core.service.MesaServiceImp;
import com.sample.core.domain.Padron;
import com.sample.core.domain.Mesa;



@WebServlet("/GenerarTicketVoto")
public class GenerarTicketVoto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoginCiudadanoService ciudadanoService = new LoginCiudadanoServiceImp();
    private PadronService padronService = new PadronServiceImp();
    private MesaService mesaService = new MesaServiceImp();

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false); // false para no crear una nueva si no existe
        if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            response.getWriter().write("{\"error\":\"No hay sesión activa o DNI no encontrado\"}");
            return;
        }

        Integer DNI = (Integer) session.getAttribute("CURRENT_CIUDADANO");

    	
    	
    	
        // Indica que la respuesta será un PDF
        response.setContentType("application/pdf");
        // Indica al navegador que el PDF se descargue
        response.setHeader("Content-Disposition", "attachment; filename=\"ticket_voto.pdf\"");

        // Escribiendo el PDF directamente en la respuesta HTTP
        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        try {
            LoginCiudadano ciudadano = ciudadanoService.buscarPorDni(DNI);
            Padron padron = padronService.buscarPadronPorDni(DNI);
            Mesa mesa = mesaService.buscarMesaPorDni(DNI);

            document.add(new Paragraph("TICKET DE VOTACIÓN"));
            document.add(new Paragraph("DNI: " + ciudadano.getDni()));
            document.add(new Paragraph("Nombre: " + ciudadano.getNombre()));
            document.add(new Paragraph("Apellido: " + ciudadano.getApellido()));
            document.add(new Paragraph("Sexo: " + ciudadano.getSexo()));
            document.add(new Paragraph("Nacionalidad: " + ciudadano.getNacionalidad()));
            document.add(new Paragraph("Distrito: " + padron.getDistrito()));
            document.add(new Paragraph("Mesa: " + mesa.getMesa()));
            document.add(new Paragraph("Orden: " + mesa.getOrden()));
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Error al obtener datos\"}");
        }
        
        
        
        // Datos de prueba (luego los podés sacar de sesión o de DB)


        document.close();
    }
}
