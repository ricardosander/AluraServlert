package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresa implements Tarefa {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) {

        String nome = req.getParameter("nome");

        if (nome == null || nome.isEmpty()) {
            return "/WEB-INF/pages/empresa-sem-nome.jsp";
        }

        Empresa novaEmpresa = new Empresa(nome);

        new EmpresaDAO().adiciona(novaEmpresa);

        req.setAttribute("empresa", novaEmpresa);

        return "/WEB-INF/pages/novaEmpresa.jsp";
    }

}