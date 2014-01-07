/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siv.style;

import de.siv.modules.Functions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sbaresel
 */
public class UserBasics extends HttpServlet {
    Properties props = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String Uid)
            throws ServletException, IOException, FileNotFoundException, NamingException, SQLException {
        PrintWriter out = response.getWriter(); 
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("text/css; charset=utf-8");
        
        if(Functions.UserIsPermitted(Uid,"config_web")) {
            
            out.println("" +
                "#MailCC,#MailEsk1,#MailEsk2,#MailEsk3 { padding: 2px; }" +
                "#MailCC input,#MailEsk1 input,#MailEsk2 input,#MailEsk3 input { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 400px; padding: 5px; height: 21px; }" +
                "#MailCC span,#MailEsk1 span,#MailEsk2 span,#MailEsk3 span { margin-left: 33px; margin-right: 25px; }" +
                "#MailCC button,#MailEsk1 button,#MailEsk2 button,#MailEsk3 button { position: absolute; margin-left: 5px; }" +
                "#MailSG div.jqte { height: 125px; }" +
                "#MailSG .jqte_editor,#MailSG .jqte_source { height: 76px; }" +
            "");
            
        }
        
        // Index Page
        
        if(Functions.UserIsPermitted(Uid,"profile")) {
        
            out.println("" +
                "#UserProfileImg { position: absolute; margin-top: 5px; margin-left: 5px; }" +
                "#UserProfileImg img { width: 150px;  height: 150px; }" +
                "#UserProfileUid { position: absolute; left: 200px; top: 35px; width: 350px; }" +
                "#UserProfileName { position: absolute; left: 200px; top: 70px; width: 350px; }" +
                "#UserProfileMail { position: absolute; left: 200px; top: 105px; width: 350px; }" +
                "#UserProfileGroup { position: absolute; left: 15px; top: 185px; width: 158px; border: 1px solid #82abcc; height: 300px; cursor: default; }" +
                "#UserProfilePerm { position: absolute; left: 183px; top: 185px; width: 402px; border: 1px solid #82abcc; height: 300px; cursor: default; }" +
                "#UserProfileGroupCnt { padding: 5px; margin-top: 30px; height: 250px; overflow-y: auto; }" +
                "#UserProfilePermCnt { padding: 5px; margin-top: 30px; height: 250px; overflow-y: auto; }" +
                "#UserProfileDialog input { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 265px; padding: 5px; float: right; }" +
                "#UserProfileDialog span { padding: 8px; float: left; font-size: 12px; font-weight: bold; }" +
                "#UserProfileImgHover { display: none; position: absolute; width: 130px; padding: 10px; background-color: #82abcc; margin-left: 5px; top: 118px; cursor: pointer; text-align: center; font-weight: bold; color: #004279; }" +
            "");
        
        }
        
        if(Functions.UserIsPermitted(Uid,"config_usermanagement")) {
        
            out.println("" +
                "#UserMgmntUserList,#UserMgmntGroupList,#UserMgmntPrivList,#UserMgmntRoleList { margin-top: -297px; margin-left: 300px; width: 792px; height: 295px; border: 1px solid #82abcc; overflow-y: scroll; background-color: #004279; }" +
                "#UserMgmntUserMenu,#UserMgmntGroupMenu,#UserMgmntPrivMenu,#UserMgmntRoleMenu { width: 285px; height: 295px; }" +
                "#UserMgmntUsGrList,#UserMgmntGrRoList,#UserMgmntRoPrList { width: 1092px; height: 175px; border: 1px solid #82abcc; overflow-y: scroll; }" +
                "#UserMgmntUserMenu table,#UserMgmntGroupMenu table,#UserMgmntRoleMenu table,#UserMgmntPrivMenu table { width: 285px; table-layout: fixed; border-spacing: 0; border-collapse: collapse; font-size: 12px; font-weight: bold; cursor: default; }" +
                "#UserMgmntUserMenu table td,#UserMgmntGroupMenu table td,#UserMgmntRoleMenu table td,#UserMgmntPrivMenu table td { padding: 2px; }" +
                "#UserMgmntUserMenu table input,#UserMgmntGroupMenu table input,#UserMgmntRoleMenu table input,#UserMgmntPrivMenu table input { width: 270px; border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; padding: 5px; font-size: 16px; cursor: text; }" +
                "#UserMgmntUserMenu button,#UserMgmntGroupMenu button,#UserMgmntRoleMenu button,#UserMgmntPrivMenu button { margin-left: 10px; margin-top: 10px; }" +
                "#UserMgmntUserList table,#UserMgmntGroupList table,#UserMgmntRoleList table,#UserMgmntPrivList table { width: 774px; table-layout: fixed; border-spacing: 0; border-collapse: collapse; cursor: default; }" +
                "#UserMgmntUserList table td,#UserMgmntGroupList table td,#UserMgmntRoleList table td,#UserMgmntPrivList table td { padding: 5px; text-align: left; }" +
                "#UserMgmntUserList table tr:hover,#UserMgmntGroupList table tr:hover,#UserMgmntRoleList table tr:hover,#UserMgmntPrivList table tr:hover { background-color: #004279; }" +
                "#UserMgmntUserList table tr,#UserMgmntGroupList table tr,#UserMgmntRoleList table tr,#UserMgmntPrivList table tr { font-size: 14px; background-color: #004c8a; }" +
                "#UserMgmntUserList table tr:first-child th,#UserMgmntGroupList table tr:first-child th,#UserMgmntRoleList table tr:first-child th,#UserMgmntPrivList table tr:first-child th { font-size: 12px; padding: 5px; background-color: #004279; }" +
                "#UserMgmntUserList table th:last-child,#UserMgmntGroupList table th:last-child,#UserMgmntRoleList table th:last-child,#UserMgmntPrivList table th:last-child { width: 25px; text-align: center; }" +
                "#UserMgmntUserList table td:last-child,#UserMgmntGroupList table td:last-child,#UserMgmntRoleList table td:last-child,#UserMgmntPrivList table td:last-child { border-left: 1px solid #82abcc; background-color: #004279; text-align: center; } " +
                "#UserMgmntUserList table td img,#UserMgmntGroupList table td img,#UserMgmntRoleList table td img,#UserMgmntPrivList table td img { margin-bottom: -3px; cursor: pointer; } " +
                "#UserMgmntUserList table td:first-child,#UserMgmntGroupList table td:first-child,#UserMgmntRoleList table td:first-child,#UserMgmntPrivList table td:first-child { border-bottom: 1px solid #82abcc; } " +
                "#UserMgmntUserList table th:first-child,#UserMgmntGroupList table th:first-child,#UserMgmntRoleList table th:first-child,#UserMgmntPrivList table th:first-child { width: 350px; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntUserList table th:first-child + th,#UserMgmntUserList table td:first-child + td { width: 125px; text-align: center; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntUserList table th:first-child + th + th,#UserMgmntUserList table td:first-child + td + td { width: 125px; text-align: center; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntUserList table th:first-child + th + th + th,#UserMgmntUserList table td:first-child + td + td + td { width: 50px; text-align: center; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntGroupList table th:first-child + th,#UserMgmntRoleList table th:first-child + th,#UserMgmntPrivList table th:first-child + th { width: 350px; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntGroupList table td:first-child + td,#UserMgmntRoleList table td:first-child + td,#UserMgmntPrivList table td:first-child + td { width: 350px; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntRoPrList1 { float: left; width: 374px; border-right: 1px solid #82abcc; font-size: 14px; font-weight: bold; }" +
                "#UserMgmntRoPrList1 table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; width: 100%; cursor: default; }" +
                "#UserMgmntRoPrList2 table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; cursor: default; }" +
                "#UserMgmntRoPrList1 table td { padding: 5px; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntRoPrList2 table td { padding: 10px; text-align: center; border-bottom: 1px solid #82abcc; border-right: 1px solid #82abcc; }" +
                "#UserMgmntRoPrList1 table tr,#UserMgmntRoPrList2 table tr { height: 40px; background-color: #004c8a; }" +
                "#UserMgmntRoPrList1 table tr:first-child,#UserMgmntRoPrList2 table tr:first-child { height: 20px; font-size: 12px; }" +
                "#UserMgmntRoPrList1 table th { padding: 5px; color: #fff; border-bottom: 1px solid #82abcc; background-color: #004279; }" +
                "#UserMgmntRoPrList2 table th { min-width: 125px; padding: 5px; color: #fff; border-bottom: 1px solid #82abcc; border-right: 1px solid #82abcc; background-color: #004279; }" +
                "#UserMgmntRoPrList2 { float: right; width: 700px; font-size: 14px; font-weight: bold; overflow-x: auto; }" +
                "#UserMgmntGrRoList1 { float: left; width: 194px; border-right: 1px solid #82abcc; font-size: 14px; font-weight: bold; }" +
                "#UserMgmntGrRoList1 table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; width: 100%; cursor: default; }" +
                "#UserMgmntGrRoList2 table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; cursor: default; }" +
                "#UserMgmntGrRoList1 table td { padding: 5px; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntGrRoList2 table td { padding: 10px; text-align: center; border-bottom: 1px solid #82abcc; border-right: 1px solid #82abcc; }" +
                "#UserMgmntGrRoList1 table tr,#UserMgmntGrRoList2 table tr { height: 40px; background-color: #004c8a; }" +
                "#UserMgmntGrRoList1 table tr:first-child,#UserMgmntGrRoList2 table tr:first-child { height: 20px; font-size: 12px; }" +
                "#UserMgmntGrRoList1 table th { padding: 5px; color: #fff; border-bottom: 1px solid #82abcc; background-color: #004279; }" +
                "#UserMgmntGrRoList2 table th { min-width: 125px; padding: 5px; color: #fff; border-bottom: 1px solid #82abcc; border-right: 1px solid #82abcc; background-color: #004279; }" +
                "#UserMgmntGrRoList2 { float: right; width: 880px; font-size: 14px; font-weight: bold; overflow-x: auto; }" +
                "#UserMgmntUsGrList1 { float: left; width: 174px; border-right: 1px solid #82abcc; font-size: 14px; font-weight: bold; }" +
                "#UserMgmntUsGrList1 table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; width: 100%; cursor: default; }" +
                "#UserMgmntUsGrList2 table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; cursor: default; }" +
                "#UserMgmntUsGrList1 table td { padding: 5px; border-bottom: 1px solid #82abcc; }" +
                "#UserMgmntUsGrList2 table td { padding: 10px; text-align: center; border-bottom: 1px solid #82abcc; border-right: 1px solid #82abcc; }" +
                "#UserMgmntUsGrList1 table tr,#UserMgmntUsGrList2 table tr { height: 40px; background-color: #004c8a; }" +
                "#UserMgmntUsGrList1 table tr:first-child,#UserMgmntUsGrList2 table tr:first-child { height: 20px; font-size: 12px; }" +
                "#UserMgmntUsGrList1 table th { padding: 5px; color: #fff; border-bottom: 1px solid #82abcc; background-color: #004279; }" +
                "#UserMgmntUsGrList2 table th { min-width: 125px; padding: 5px; color: #fff; border-bottom: 1px solid #82abcc; border-right: 1px solid #82abcc; background-color: #004279; }" +
                "#UserMgmntUsGrList2 { float: right; width: 900px; font-size: 14px; font-weight: bold; overflow-x: auto; }" +
                "#UserMgmntUsGrList2 img,#UserMgmntRoPrList2 img,#UserMgmntGrRoList2 img { cursor: pointer; }" +
                "#UserMgmntUsGrList,#UserMgmntRoPrList,#UserMgmntGrRoList { background-color: #004279; }" +
            "");
            
        }
        
        if(Functions.UserIsPermitted(Uid,"config_mail")) {
            
            out.println("" +
                "#MailHContent {  }" +
                "#MailFContent {  }" +
                "#MailH div.jqte { height: 175px; }" +
                "#MailH .jqte_editor,#MailH .jqte_source { height: 126px; }" +
                "#MailF div.jqte { height: 325px; }" +
                "#MailF .jqte_editor,#MailF .jqte_source { height: 276px; }" +
            "");
            
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response, request.getRemoteUser());
        } catch (NamingException ex) {
            Logger.getLogger(UserBasics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserBasics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
    }
}
