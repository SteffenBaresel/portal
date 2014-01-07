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
public class ManagedServiceBasics extends HttpServlet {
    Properties props = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String Uid)
            throws ServletException, IOException, FileNotFoundException, NamingException, SQLException {
        PrintWriter out = response.getWriter(); 
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("text/css; charset=utf-8");
        
        if(Functions.UserIsPermitted(Uid,"managed_services")) {
        
        out.println("" +
                "#ManagedServiceMenus { position: absolute; width: 225px; top: 325px; bottom: 65px; left: 10px; border: 2px solid #82abcc; background-color: #004c8a; }" +
                "#MS_CustActions { padding: 15px;  }" +
                "#WhosLoggedInH { position: absolute; width: 205px; top: -37px; left: -2px; border: 2px solid #82abcc; background-color: #004c8a; font-size: 12px; color: #82abcc; padding: 10px; height: 13px; }" +
                "#WhosLoggedIn { width: 225px; overflow-y: auto; }" +
                "#LoggedInUser { width: 219px; height: 50px; background-color: #004c8a; border: 1px solid #82abcc; cursor: default; font-size: 16px; letter-spacing: -1px; margin-left: 2px; margin-top: 2px; margin-right: 2px; margin-bottom: 2px; }" +
                "#LoggedInUser:hover { background-color: #004279; }" +
                "#LoggedInUser img { margin-right: 5px;  }" +
                "#LoggedInUser span#LIU_Head { float: left; cursor: default; margin-top: 10px; }" +
                "#LoggedInUser span.ui-icon { float: left; cursor: pointer; margin-top: 9px; }" +
                "#LoggedInUser span:last-child { color: #82abcc; font-size: 12px; font-weight: bold; letter-spacing: 0px; }" +
                "#WhosLoggedIn span#WLI_Cont { font-size: 14px; color: #fff; float: left; width: 203px; }" +
                "#MS_CustActions button { width: 214px; margin-top: 3px; margin-bottom: 2px; }" +
                "#MenuSidebar { display: none; position: absolute; width: 123px; top: 0; bottom: 0; left: 0px; border-right: 2px solid #004279; background-color: #82abcc; }" +
                "#MenuSidebar a.menu { background: #004c8a; border:1px solid #004279; }" +
                "#MenuSidebar a.menu:hover { background: #004279; border:1px solid #004c8a; }" +
                "#MenuSidebar a.menu:hover>span { color: #fff; }" +
                "#MenuSidebar a.menu { height: 60px; width: 60px; }" +
                "#MenuSidebar a.menu span { font-size:14px; letter-spacing:0px; }" +
                "#MenuSidebar a { display:block; float:left; margin:4px; padding:15px; z-index:0; color:#fff; text-decoration:none; cursor: pointer; }" +
                "#MenuSidebar a.icon { background: #004c8a; border:1px solid #004279; }" +
                "#MenuSidebar a.icon:hover { background: #004279; border:1px solid #004c8a; }" +
                "#MS_srv { height: 85px; }" +
                "#MS_cc { height: 285px; }" +
                "#MS_vt { height: 225px; }" +
                "#MenuSidebar .UserDesc { font-size: 14px; margin-bottom: 5px; margin-top: 25px; color: #004279; }" +
                "#MenuSidebarSmall { position: absolute; width: 25px; top: 150px; bottom: 150px; left:0; z-index: 30; cursor: pointer; }" +
                "#MenuSidebarSmall:hover { border-right: 1px dotted #004c8a; border-bottom: 1px dotted #004c8a; border-top: 1px dotted #004c8a; }" +
                "#StatusSummaryHead { position: absolute; top: 290px; left: 10px; right: 10px; border: 2px solid #82abcc; height: 33px; background-color: #004c8a;}" +
                "#StatusSummary { position: absolute; top: 123px; left: 10px; right: 10px; height: 160px;}" +
                "#HostStatusSummary { left: 2px; width: 246px;}" +
                "#ServiceStatusSummary { left: 255px; right: 2px;}" +
                "#ServiceStatusSummary, #HostStatusSummary { position: absolute; margin-top: 23px; height: 133px; overflow-x: hidden; overflow-y: auto;} " +
                "#HostStatusSummaryHead, #ServiceStatusSummaryHead { position: absolute; margin-top: 6px; font-size: 12px; cursor: default;}" +
                "#HostStatusSummaryHead { left: 10px;}" +
                "#ServiceStatusSummaryHead { left: 265px;}" +
                "#SummaryBox { display: block; border: 1px solid #82abcc; width: 20px; height: 20px; float: left; margin: 1px; cursor: default;}" +
                "#ServicesHost { position: absolute; margin-top: -20px; right: 200px; left: 800px; height: 48px; overflow-y: hidden; } " +
                "#HostGridSelect { position: absolute; left: 12px; top: 293px; width: 450px; height: 31px; color: white; background-color: #004c8a; z-index: 5; border-right: 1px dotted #82abcc; }" +
                "#ShowGridSearchBar { position: absolute; top: 10px; right: 300px; color: white; cursor: pointer; font-size: 12px; width: 200px; z-index:5; text-align: right; }" +
                ".hcr { background-color: #9c1919; }" +
                ".hun { background-color: #6c006c; }" +
                ".hwa { background-color: orange; }" +
                ".hok { background-color: #088A08; }" +
                ".hpe { background-color: grey; }" +
                ".hack { background-color: #5D5D5D; }" +
        "");
        
        out.println("" +
                "#CreateCustomerLeft,#CreateCustomerMiddle,#CreateCustomerRight { position: absolute; width: 390px; height: 490px; font-size: 16px; }" +
                "#CreateCustomerLeft { left: 10px; }" +
                "#CreateCustomerMiddle { left: 405px; }" +
                "#CreateCustomerRight { left: 800px; }" +
                "#CreateCustomerLeft input { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 375px; padding: 5px; margin-top: 3px; margin-bottom: 10px; }" +
                "#caddress { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 375px; height: 212px; padding: 5px; margin-top: 3px; margin-bottom: 10px; resize: none; font-size: 16px; font-weight: normal; overflow-y: auto; white-space: pre-wrap; }" +
                "#caddressE { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 375px; height: 215px; padding: 5px; margin-top: 3px; margin-bottom: 10px; resize: none; font-size: 16px; font-weight: normal; overflow-y: auto; white-space: pre-wrap; }" +
                "#CreateCustomerLeft table tr td:first-child,#CreateCustomerMiddle table tr td:first-child,#CreateCustomerRight table tr td:first-child { font-size: 12px; font-weight: bold; }" +
                "#ContractTypeDiv1,#ContractTypeDiv2,#ContractTypeDiv3,#ContractTypeDiv4,#ContractTypeDiv5,#ContractTypeDiv6,#cnameE { border: 1px solid #82abcc; margin-top: 3px; margin-bottom: 5px; }" +
                "#CreateCustomerRight select,#CreateCustomerLeft select,#DeleteCustomerLeft select { border: 1px solid #004c8a; background-color: #004c8a; color: #fff; padding: 4px; width: 390px; color: #004c8a; }" +
                "#CreateCustomerRight input { border: 1px solid #82abcc; background-color: #004c8a; color: #fff; padding: 5px; margin-left: 2px; margin-right: 2px; margin-bottom: 10px; width: 113px; font-size: 12px; }" +
                "#ContractsDiv1 { border: 1px solid #004c8a; background-color: #004c8a; color: #ffffff; width: 375px; height: 340px; padding: 5px; margin-top: 3px; margin-bottom: 10px; resize: none; font-size: 16px; font-weight: normal; overflow-y: auto; white-space: pre-wrap; }" +
                "#ContractsDivTable { table-layout: fixed; border-spacing: 0; border-collapse: collapse; font-size: 14px; cursor: default; } " +
                "#CT_Outer { background-color: #004c8a; border: 1px solid #82abcc; width: 97%; margin-bottom: 5px; padding: 5px; cursor: default; }" +
                "#CT_Outer:hover { background-color: #004279;  }" +
                "#CT_Head,#CT_AN,#CT_PR { font-size: 12px; color: #82abcc; padding: 1px; }" +
                "#CT_Head span:last-child,#CT_AN span:last-child,#CT_PR span:last-child { font-size: 14px; color: #fff; }" +
                "#ContractsDelete { margin-bottom: -20px; float: right; cursor: pointer; }" +
                "#DeleteCustomerLeft { padding-left: 30px; padding-right: 25px; padding-top: 15px; padding-bottom: 10px; }" +
                "#ccommE,#ccomm { width: 385px; }" +
                "#ccommE div.jqte,#ccomm div.jqte { height: 455px; }" +
                "#ccommE .jqte_editor,#ccommE .jqte_source,#ccomm .jqte_editor,#ccomm .jqte_source { height: 385px; }" +
        "");            
            
        out.println("" +
                "#CreateContractTypeLeft { width: 570px; height: 475px; padding: 5px; }" +
                "#CreateContractTypeLeft table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; font-size: 14px; cursor: default; width: 550px; } " +
                "#CreateContractTypeLeft table tr:first-child,#CreateContractTypeLeft table tr:first-child + tr + tr,#CreateContractTypeLeftE table tr:first-child { font-size: 12px; font-weight: bold; }" +
                "#CreateContractTypeLeft input { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 255px; padding: 5px; margin-top: 3px; margin-bottom: 10px; }" +
                "#CreateContractTypeLeft select { border: 1px solid #004c8a; background-color: #004c8a; color: #fff; padding: 4px; width: 255px; color: #004c8a; }" +
                "#cotrsnE { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 255px; margin-top: 3px; margin-bottom: 10px; }" +
                "#cotrlnE { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 255px; padding: 6px; cursor: text; }" +
                "#CreateContractTypeLeftE { padding-left: 40px; padding-top: 20px;  } " +
                "#CreateContractTypeLeftE table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; font-size: 14px; cursor: default; width: 400px; }" +
                "#cotrsnD { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 385px; margin-top: 3px; margin-bottom: 10px; }" +
                "#CreateContractTypeLeftE select { border: 1px solid #004c8a; background-color: #004c8a; color: #fff; padding: 4px; width: 385px; color: #004c8a; }" +
                "#mactionsE,#mactions { width: 560px; }" +
                "#mactionsE div.jqte,#mactions div.jqte { height: 395px; }" +
                "#mactionsE .jqte_editor,#mactionsE .jqte_source,#mactions .jqte_editor,#mactions .jqte_source { height: 346px; }" +
        "");            
            
        out.println("" +
                "#CreateServiceEntryLeft { float: right; width: 730px; height: 525px; margin-right: 10px; }" +
                "#CreateServiceEntryRight { float: left; width: 415px; height: 525px; }" +
                "#CreateServiceEntryLeftMH div.jqte { height: 105px; }" +
                "#CreateServiceEntryLeftMH .jqte_editor,#CreateServiceEntryLeftMH .jqte_source { height: 56px; }" +
                "#CreateServiceEntryLeftMC div.jqte { height: 675px; }" +
                "#CreateServiceEntryLeftMC .jqte_editor,#CreateServiceEntryLeftMC .jqte_source { height: 626px; }" +
                "#CreateServiceEntryLeftMF,#CreateServiceEntryLeftMH { display: none; }" +
                "#CreateServiceEntryLeftMF div.jqte { height: 155px; }" +
                "#CreateServiceEntryLeftMF .jqte_editor,#CreateServiceEntryLeftMF .jqte_source { height: 106px; }" +
                
                "#CreateServiceEntryT,#CreateServiceEntryC,#CreateServiceEntryA { margin-left: 15px; }" +
                "#CreateServiceEntryU input,#CreateServiceEntryD input,#CreateServiceEntryS input,#CreateServiceEntryM input { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; padding: 6px; font-size: 13px; padding-left: 13px; width: 367px;  margin-left: 15px; }" +
                "#CreateServiceEntryC select,#CreateServiceEntryT select,#CreateServiceEntryA select { border: 1px solid #004c8a; background-color: #004c8a; color: #fff; padding: 4px; width: 385px; color: #004c8a; }" +
                "#CreateServiceEntryCs,#CreateServiceEntryAs { border: 1px solid #82abcc; width: 385px; }" +
                "#CreateServiceEntryTs { border: 1px solid #82abcc; width: 385px; }" +
                "#CreateServiceEntryAs { height: 28px; }" +
                "#CreateServiceEntryT #CSEDsc,#CreateServiceEntryC #CSEDsc,#CreateServiceEntryA #CSEDsc { margin-bottom: 3px; margin-top: 6px; font-size: 12px; font-weight: bold; }" +
                "#CreateServiceEntryU #CSEDsc,#CreateServiceEntryS #CSEDsc,#CreateServiceEntryD #CSEDsc { margin-bottom: 3px; margin-top: 6px; font-size: 12px; font-weight: bold; margin-left: 15px; }" +
                "#CreateServiceEntryU { margin-top: 13px; }" +
                "#CSEDsc2 { margin-top: 35px; margin-left: 15px; margin-bottom: 6px; font-size: 12px; font-weight: bold; z-index: 5; }" +
                "#CSEDsc3 { font-size: 12px; font-weight: bold; margin-left: 15px; margin-bottom: 3px; margin-top: 5px; color: #82abcc; }" +
                "#InANt { position: absolute; top: 377px; left: 7px; font-size: 12px; font-weight: bold; }" +
                "#InCCt { position: absolute; top: 410px; left: 7px; font-size: 12px; font-weight: bold; }" +
                "#InSubt { position: absolute; top: 442px; left: 6px; font-size: 12px; font-weight: bold; }" +
                "#InAN,#InCC { margin-bottom: 3px; }" +
                "#CSEDsc2 input { position: absolute; left: -5px; margin-top: -1px; width: 10px; }" +
                "#CSEDsc3 input { position: absolute; left: -5px; margin-top: -1px; width: 10px; }" +
                "#CSEDsc3 span {  }" +
                "#CSEDscOverLay { position: absolute; width: 444px; height: 290px; top: 368px; left: 0; z-index: 5; background-color: #004c8a; opacity: 0.5; filter: Aplha(Opacity=50);}" +
                
            ""); 
            
        out.println("" +
                "#ManagedServiceActions { position: absolute; top: 325px; bottom: 65px; left: 245px; right: 410px; border: 2px solid #82abcc; background-color: #004c8a; overflow-y: auto; }" +
                "#ManagedServiceActionsPage { height: 33px; position: absolute; top: 290px; left: 245px; right: 410px; text-align: center; border: 2px solid #82abcc; background-color: #004c8a; }" +
                "#ManagedServiceActionsE { padding: 15px; background-color: #004c8a; border: 1px solid #82abcc; margin-left: 2px; margin-right: 2px; margin-top: 2px; margin-bottom: 2px; }" +
                "#ManagedServiceActionsE:first-child {  }" +
                "#ManagedServiceActionsE:last-child {  }" +
                "#ManagedServiceActionsE:hover { background-color: #004279; }" +
                "#ManagedServiceActionsE table { table-layout: fixed; border-spacing: 0; border-collapse: collapse; font-size: 14px; cursor: default; }" +
                "#ManagedServiceActionsE img { width: 75px; height: 75px; border: 1px solid #82abcc; margin-bottom: -50px; }" +
                "#ManagedServiceActionsH { margin-top: -20px; margin-left: 10px; font-size: 28px; letter-spacing: -2px; }" +
                "#ManagedServiceActionsD { margin-top: 0px; margin-left: 15px; font-size: 12px; }" +
                "#ManagedServiceActionsT { margin-top: 15px; margin-left: 25px; font-size: 16px; }" +
                "#ManagedServiceActionsF { margin-top: 15px; margin-left: 15px; margin-bottom: 5px; font-size: 12px; }" +
                "#EskDscD { color: #82abcc; }" +
                "#EskDscE { color: #ff7777; }" +
                "#ManagedServiceActionsPageSelected { padding: 3px; }" +
            "");
            
        out.println("" +
                "#ManagedServiceInfos { position: absolute; width: 390px; top: 325px; bottom: 65px; right: 10px; border: 2px solid #82abcc; overflow-y: auto; background-color: #004c8a; }" +
                "#ManagedServiceInfosH { position: absolute; width: 370px; top: 290px; height: 13px; right: 10px; border: 2px solid #82abcc; background-color: #004c8a; font-size: 12px; color: #82abcc; padding: 10px; }" +
                "#MSI_Cont { width: 100%; overflow-y: auto; }" +
                "#CustomerInfoEntry { border: 1px solid #82abcc; padding: 5px; height: 35px; background-color: #004c8a; cursor: pointer; margin-bottom: 2px; margin-top: 2px; margin-left: 2px; margin-right: 2px;}" +
                "#CustomerInfoEntry:hover { background-color: #004279; }" +
                "#CustomerInfoEntryHeader { font-size: 18px; letter-spacing: -1px; }" +
                "#CustomerInfoEntryContent { font-size: 12px; font-weight: bold; color: #82abcc; }" +
                "#ShowCustomer #ccommE { border: 1px solid #82abcc; background-color: #004c8a; color: #ffffff; width: 375px; height: 443px; padding: 5px; margin-top: 3px; margin-bottom: 10px; resize: none; font-size: 16px; font-weight: normal; overflow-y: auto; white-space: pre-wrap; }" +
            "");
            
        }

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response, request.getRemoteUser());
        } catch (NamingException ex) {
            Logger.getLogger(ManagedServiceBasics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagedServiceBasics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
    }
}
