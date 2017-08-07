package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class BuscaEmpresa implements Tarefa {

    public String executar(HttpServletRequest req, HttpServletResponse resp) {

        String filtro = req.getParameter("filtro");

        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

        req.setAttribute("empresas", empresas);

        return "/WEB-INF/pages/buscaEmpresas.jsp";
    }

}