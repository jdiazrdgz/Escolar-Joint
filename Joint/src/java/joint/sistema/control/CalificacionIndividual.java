package joint.sistema.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import joint.sistema.gestion.GestionEstadistica;
import joint.sistema.gestion.GestionadorTrabajador;
import joint.sistema.principal.Trabajador;

/**
 *
 * @author jdiaz
 */
public class CalificacionIndividual extends HttpServlet {
    private GestionEstadistica ge;
    private GestionadorTrabajador gt;
    private Trabajador t;
    private void iniciarGestion(){
        ge=new GestionEstadistica();
        gt=new GestionadorTrabajador();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("idTrabajador")!=null){
            int idTrabajador=Integer.parseInt(request.getParameter("idTrabajador"));
            iniciarGestion();
            int promedio=ge.getPromedioTrabajador(idTrabajador);
            request.setAttribute("promedio", promedio);
            System.out.println(promedio);
            t=gt.getInformacionTrabajador(idTrabajador);
            request.setAttribute("trabajador", t);
             request.getRequestDispatcher("sistema/vista/accion/acciones/Gerente/respuestaCalificacionIndividual.jsp").forward(request, response); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
