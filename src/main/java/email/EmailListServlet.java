
package email;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import business.User;
import data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String url = "/index.html";

        // Get current action
        String action = request.getParameter("action");

        if (action == null) {
            action = "join";
        }

        // Perform action
        if (action.equals("join")) {

            url = "/index.html";

        } else if (action.equals("add")) {

            // Get parameters from request
            String firstName =
                    request.getParameter("firstName");

            String lastName =
                    request.getParameter("lastName");

            String email =
                    request.getParameter("email");

            // Create User object
            User user = new User(
                    email,
                    firstName,
                    lastName
            );

            // Save User object
            UserDB.insert(user);

            // Send User to JSP
            request.setAttribute("user", user);

            url = "/thanks.jsp";
        }

        // Forward request and response
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}
