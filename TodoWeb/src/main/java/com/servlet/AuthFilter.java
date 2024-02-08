//package com.servlet;
//
//import java.io.IOException;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//
//public class AuthFilter implements Filter {
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = httpRequest.getSession(false);
//
//        // Vérifiez si l'utilisateur est authentifié
//        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);
//
//        String requestURI = httpRequest.getRequestURI();
//
//        // Si l'utilisateur n'est pas authentifié et accède à une page sécurisée, redirigez-le vers la page de connexion
//        if (!isLoggedIn && requestURI.startsWith(httpRequest.getContextPath() + "/secured/")) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "Connexion.jsp");
//            return;
//        }
//
//        // L'utilisateur est authentifié ou accède à une page publique, continuez la chaîne de filtres
//        chain.doFilter(request, response);
//    }
//
//    public void init(FilterConfig fConfig) throws ServletException {
//        // Initiation du filtre si nécessaire
//    }
//
//    public void destroy() {
//        // Libération des ressources si nécessaire
//    }
//}
