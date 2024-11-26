/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Setting;

import Service.SettingService;
import Util.AppSetting;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nguye
 */
public class SettingController extends HttpServlet {

    private SettingService settingService;
    
    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        settingService = new SettingService();
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SettingController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        String action = request.getParameter("action");
        request.setAttribute("action", action);
        if(action != null && !action.isEmpty()){
            if(action.trim().equalsIgnoreCase(AppSetting.addSettingAction)){
                request.setAttribute("systemSettingList", settingService.getAllSetting());
                request.getRequestDispatcher("View/SettingView/SettingDetails.jsp").forward(request, response);
                return;
            }
            else if(action.trim().equalsIgnoreCase(AppSetting.editSettingAction)){
                request.setAttribute("systemSettingList", settingService.getAllSetting());
                request.getRequestDispatcher("View/SettingView/SettingDetails.jsp").forward(request, response);
                return;
            }
        }
        request.setAttribute("addSettingAction", AppSetting.addSettingAction);
        request.setAttribute("editSettingAction", AppSetting.editSettingAction);
        request.setAttribute("settingList", settingService.getAllSetting());
        request.setAttribute("systemSettingIds", Arrays.stream(AppSetting.systemSettingIds).boxed().collect(Collectors.toList()));
        new ArrayList<>().stream();
        request.getRequestDispatcher("View/SettingView/SettingView.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action") == null ? null : request.getParameter("action") + "";
        if(action == null || action.isEmpty()){
            return;
        }
        System.out.println(action);
        String name = request.getParameter("name");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String value = request.getParameter("value");
        
        
        switch (action) {
            case AppSetting.addSettingAction: {
                
                break;
            }
            case AppSetting.editSettingAction: {
                
                break;
            }
            default:
                throw new AssertionError();
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
