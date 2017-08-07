package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) {

        Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return "/WEB-INF/pages/nao-logado.jsp";
        }

        req.getSession().removeAttribute("usuarioLogado");

        return "/WEB-INF/pages/logout.jsp";
    }

}