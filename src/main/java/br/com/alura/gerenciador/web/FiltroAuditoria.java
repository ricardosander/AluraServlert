package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FiltroAuditoria implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String usuario = this.getUsuario(httpServletRequest);

        System.out.println("Usuário " + usuario + " acessando URI " + httpServletRequest.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private String getUsuario(HttpServletRequest httpServletRequest) {

        String usuario = "<deslogado>";

        Usuario usuarioLogado = (Usuario) httpServletRequest.getSession().getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return usuario;
        }

        httpServletRequest.getSession().setAttribute("usuarioLogado", usuarioLogado);
        return usuarioLogado.getEmail();
    }

}