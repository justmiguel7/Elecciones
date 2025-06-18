package com.sample.core.controller.votos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.VotoService;
import com.sample.core.service.VotoServiceImp;
import com.google.gson.Gson;
import com.sample.core.dao.VotoDao;
import com.sample.core.dao.VotosDaoImp;
import com.sample.core.domain.Voto;
import com.sample.core.domain.VotoResumen;

@WebServlet("/votosPorRol")
public class VotosPorRolController extends HttpServlet {

    private VotoService votoService = new VotoServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rol = req.getParameter("rol");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            List<VotoResumen> lista = votoService.contarVotosPorPartido(rol);

            List<String> labels = new ArrayList<>();
            List<Integer> data = new ArrayList<>();

            for (VotoResumen vr : lista) {
                labels.add(vr.getPartido());
                data.add(vr.getCantidad());
            }

            Map<String, Object> json = new HashMap<>();
            json.put("labels", labels);
            json.put("data", data);

            out.print(new Gson().toJson(json));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}