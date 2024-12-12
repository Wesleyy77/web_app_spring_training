package fr.lernejo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ApplicationIdentifierFilter implements Filter {

    private final String applicationId;

    public ApplicationIdentifierFilter() {
        this.applicationId = UUID.randomUUID().toString();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        try {
            response.setContentType("text/plain");
            response.getWriter().write("Application-ID: " + applicationId + "\n");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture de la réponse : " + e.getMessage());
            throw e;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}

