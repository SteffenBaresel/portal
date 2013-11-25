/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siv.systemcontrol;

import de.siv.web.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sbaresel
 */
public class UserManagement extends HttpServlet {
    Properties props = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String b64uid = Base64Coder.encodeString(request.getRemoteUser());
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("text/html; charset=utf-8");
        out.println(Html.openHtmlAndHead(null));
        out.println(Html.includeMeta(null));
        out.println("    <title>User Management - kVASy&reg; System Control</title>");
        out.println(Html.includeJs("Index"));
        out.println(Html.includeCss("Index"));
        out.println(Html.printTopMenu(null));
        out.println("        <div id='center'>\n" +
"            <div id='section_user'>Nutzer:</div>\n" +
"            <section>\n" +
"                <a href='#' class='icon' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span><b>Anlegen</b></span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"                <a href='#' class='icon' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span><b>L&ouml;schen</b></span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"                <a href='#' class='icon' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span><b>Bearbeiten</b></span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"            </section>\n" +
"            <div id='section_group'>Gruppe:</div>\n" +
"            <section>\n" +
"                <a href='#' class='twitter' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span>Anlegen</span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"                <a href='#' class='twitter' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span>L&ouml;schen</span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"                <a href='#' class='twitter' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span>Bearbeiten</span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"            </section>\n" +
"            <div id='section_role'>Rolle:</div>\n" +
"            <section>\n" +
"                <a href='#' class='twitter' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span>Anlegen</span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"                <a href='#' class='twitter' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span>L&ouml:schen</span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"                <a href='#' class='twitter' onclick=\"Configuration('" + b64uid + "')\">\n" +
"                    <span>Bearbeiten</span><br></br>\n" +
"                    <span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"                </a>\n" +
"            </section>\n" +
"        </div>\n" +
"        <div id='Configuration'></div>\n" +
"        <div id='AddLink'></div>\n");
        out.println(Html.closeBodyCloseHtml(null));
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
