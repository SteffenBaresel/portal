/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siv.systemcontrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.siv.web.*;

/**
 *
 * @author sbaresel
 */
public class Index extends HttpServlet {
    Properties props = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter(); 
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("text/html; charset=utf-8");
        out.println(Html.openHtmlAndHead(null));
        out.println(Html.includeMeta(null));
        out.println(" <title>Startseite - kVASy&reg; System Control</title>");
        out.println(Html.includeJs("Index"));
        out.println(Html.includeCss("Index"));
        out.println("             <script>\n" +
"                $(function() {\n" +
"                    jQuery.support.cors = true;\n" +
"                    GetUserConfig();\n" +
"                });\n" +
"            </script>\n");
        out.println(Html.closeHeadOpenBody(null));
        out.println(Html.printTopMenu(null));
        out.println("<div id='center'>\n" +
"			<section>\n" +
"                                <a href='#' class='icon' onclick=\"Configuration('" + Base64Coder.encodeString(request.getRemoteUser()) + "')\">\n" +
"					<img src='layout/images/gear_icon.png' alt='games' width='148' height='148'>\n" +
"				</a>\n" +
"				<a href='hosts/' class='twitter'>\n" +
"					<span>Hosts</span><br></br>\n" +
"					<span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Server.</span>\n" +
"				</a>\n" +
"				<a href='services/' class='twitter'>\n" +
"					<span>Services</span><br></br>\n" +
"					<span class='sub-grid'>Eine &Uuml;bersicht &uuml;ber alle eingerichteten Services.</span>\n" +
"				</a>\n" +
"                               <div id='DashboardLinks'></div>\n" +
"				<!--a href='#' class='AddNext' onclick='AddLink();'>\n" +
"                                    <img src='layout/images/white/add.png' alt='AddNext' title='F&uuml;ge weiteren Men&uuml;punkt hinzu!' width='50' height='50'>\n" +
"				</a-->\n" +
"			</section>\n" +
"		 </div>\n" +
"                <div id='Configuration'></div>\n" +
"                <div id='AddLink'></div>\n");
        out.println("<div onclick='MailTest();'>Mail Test</div><div id='MailForm'></div><div id='MailSendSuccess'></div>");
        out.println(Html.printSidebars(null));
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
        //
    }
}
