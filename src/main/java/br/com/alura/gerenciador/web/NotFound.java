package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFound implements Tarefa {
    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) {

        resp.setStatus(404);

        return "/WEB-INF/pages/404.jsp";
    }
}