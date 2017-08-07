package br.com.alura.gerenciador;

import javax.servlet.http.Cookie;

public class Cookies {

    private final Cookie[] cookies;

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie getUsuarioLogado() {

        if (this.cookies == null || this.cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("usuarioLogado")) {
                return cookie;
            }
        }

        return null;
    }

}