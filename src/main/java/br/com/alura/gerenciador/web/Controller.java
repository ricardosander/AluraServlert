package br.com.alura.gerenciador.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Controller extends HttpServlet {

    private Tarefa getTarefa(HttpServletRequest req) {

        String requestURI = req.getRequestURI();

        String[] partes = requestURI.split("/");

        if (partes.length < 2) {
            return new Inicio();
        }

        String tarefaName = "br.com.alura.gerenciador.web." + partes[1].substring(0, 1).toUpperCase() + partes[1].substring(1);

        try {

            Class<?> tarefa = Class.forName(tarefaName);

            return (Tarefa) tarefa.newInstance();

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new NotFound();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tarefa tarefa = this.getTarefa(req);

        String destino = tarefa.executar(req, resp);

        req.getRequestDispatcher(destino).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tarefa tarefa = this.getTarefa(req);
        String destino = tarefa.executar(req, resp);

        req.getRequestDispatcher(destino).forward(req, resp);
    }
}