package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Tarefa {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            return "/WEB-INF/pages/email-senha-invalidos.jsp";
        }

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if (usuario == null) {
            return "/WEB-INF/pages/usuario-nao-encontrado.jsp";
        }

        req.getSession().setAttribute("usuarioLogado", usuario);

        req.setAttribute("usuarioLogado", usuario);

        return "/WEB-INF/pages/login.jsp";
    }

}