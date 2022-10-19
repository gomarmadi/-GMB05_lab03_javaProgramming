package gmb_lab3;

import java.io.IOException;
import static java.lang.Math.pow;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gmb_lab3.ResultQE;

public class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Main() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Обрабатываем кнопку <input type="submit" name="calcQE" value="Решить" /> <br />
        if (request.getParameter("calcQE") != null) {
            ResultQE resultQE = null;
            try {
                double a = Double.parseDouble(request.getParameter("a"));
                double b = Double.parseDouble(request.getParameter("b"));
                double x = Double.parseDouble(request.getParameter("x"));
                double y;
                if (x >= 8){
                    y = (pow(a,2)+4*pow(x,2) + b)/(2*x);
                }
                else{
                y = pow(a,2)-2*pow(x,2);
                        }
                resultQE = new ResultQE(y);
            } catch (Exception e) {
            }
            request.setAttribute("resultQE", resultQE);
            getServletContext().getRequestDispatcher("/result_qe.jsp").forward(request, response);
            return;
        }


        // Если пришел неизвестный запрос,то переход на стартовую страницу
        getServletContext().getRequestDispatcher("/start.jsp").forward(request, response);
    }

}
