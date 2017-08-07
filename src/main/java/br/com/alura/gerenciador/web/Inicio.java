package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inicio implements Tarefa {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) {
        return "/WebContent/index.jsp";
    }

}