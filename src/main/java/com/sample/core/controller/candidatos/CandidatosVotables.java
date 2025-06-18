package com.sample.core.controller.candidatos;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sample.core.domain.Candidato;
import com.sample.core.service.CandidatoService;
import com.sample.core.service.CandidatoServiceImp;
import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;

@WebServlet("/votar")
public class CandidatosVotables extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CandidatoService candidatoService = new CandidatoServiceImp();
    private PadronService padronService = new PadronServiceImp();
    private static final String VOTO_CANDIDATO_JSP = "/candidato/votoCandidato.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "No autorizado");
            return;
        }

        Object dniObj = session.getAttribute("CURRENT_CIUDADANO");
        if (!(dniObj instanceof Integer)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Sesión inválida");
            return;
        }

        Integer dni = (Integer) dniObj;

        try {
            boolean yaVoto = padronService.verificarSiYaVoto(dni);

            if (yaVoto) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "El ciudadano ya votó");
                return;
            }

            List<Candidato> candidatos = candidatoService.listarImagenes();
            request.setAttribute("candidatos", candidatos);
            request.getRequestDispatcher(VOTO_CANDIDATO_JSP).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }
}
