package fr.lernejo.todo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {

    private final String instanceId = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        if (response instanceof HttpServletResponse httpServletResponse) {
            httpServletResponse.setHeader("Instance-Id", instanceId);
        }
        chain.doFilter(request, response);
    }
}

