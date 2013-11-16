/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siv.web;

/**
 *
 * @author sbaresel
 */
public class Html {
    
    static public String openHtmlAndHead(String mod) {
        String replace ="<!DOCTYPE html>\n<html>\n    <head>\n";
        return replace;
    }
    
    static public String closeHeadOpenBody(String mod) {
        String replace ="    </head>\n    <body>\n";
        return replace;
    }
    
    static public String closeBodyCloseHtml(String mod) {
        String replace ="    </body>\n</html>";
        return replace;
    }
    
    static public String includeMeta(String mod) {
        String replace ="    <link rel='shortcut icon' href='layout/images/favicon.ico' type='image/vnd.microsoft.icon' />\n";
        replace+="    <meta name='author' content='Steffen Baresel'>\n";
	replace+="    <meta name='description' content='kVASy(R) System Control'>\n";
	replace+="    <meta name='keywords' content='kVASy, System Control, kVASy System Control'>\n";
	replace+="    <meta name='language' content='it'>\n";
	replace+="    <meta name='charset' content='utf-8'>\n";
        return replace;
    }
    
    static public String includeJs(String mod) {
        String replace = "    <script type='text/javascript' src='script/jquery-1.8.2.min.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/jquery-ui-1.9.0.custom.min.js'></script>\n";
        if ("Index".equals(mod)) {
    	replace+="    <script type='text/javascript' src='script/jquery.cookie.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/highcharts.js'></script>\n";
	replace+="    <script type='text/javascript' src='script/exporting.js'></script>\n";
	replace+="    <script type='text/javascript' src='script/data.js'></script>\n";
	replace+="    <script type='text/javascript' src='script/jquery.searchFilter.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/jquery.selectmenu.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/timepicker.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/jquery.shortcuts.min.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/kVASySystemControl/kSCbasic.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/kVASySystemControl/kSCindex.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/kVASySystemControl/kSCbase64.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/kVASySystemControl/kSCliveticker.js'></script>\n";
        replace+="    <script type='text/javascript' src='script/kVASySystemControl/kSCtaov.js'></script>\n";
        }
        return replace;
    }
    
    static public String includeCss(String mod) {
        String replace = "    <link rel='stylesheet' href='layout/kSCbasic.css' />\n";
        if ("Index".equals(mod)) {
        replace+="    <link rel='stylesheet' href='layout/kSCliveticker.css' />\n";
        replace+="    <link rel='stylesheet' href='layout/kSCsidebar.css' />\n";
        replace+="    <link rel='stylesheet' href='layout/kSCtaov.css' />\n";
	replace+="    <link rel='stylesheet' href='layout/searchFilter.css' />\n";
        }
        replace+="    <!-- Personal Computer -> 1024x768 -->\n";
        replace+="    <link rel='stylesheet' media='screen and (max-width: 1214px)' href='layout/metro.1024.css' />\n";
        replace+="    <link rel='stylesheet' media='screen and (max-width: 1214px)' href='layout/jquery-ui-1.9.0.custom.css' />\n";
        replace+="    <!-- Personal Computer -> 1280x1024 -->\n";
        replace+="    <link rel='stylesheet' media='screen and (min-width: 1215px) and (max-width: 1529px) and (min-device-width: 1281px)' href='layout/metro.1280.css' />\n";
        replace+="    <link rel='stylesheet' media='screen and (min-width: 1215px) and (max-width: 1529px) and (min-device-width: 1281px)' href='layout/jquery-ui-1.9.0.custom.css' />\n";
        replace+="    <!-- Personal Computer -> 1650x1050 -->\n";
        replace+="    <link rel='stylesheet' media='screen and (min-width: 1530px) and (max-width: 1849px) and (min-device-width: 1281px)' href='layout/metro.css' />\n";
        replace+="    <link rel='stylesheet' media='screen and (min-width: 1530px) and (max-width: 1849px) and (min-device-width: 1281px)' href='layout/jquery-ui-1.9.0.custom.css' />\n";
        replace+="    <!-- Personal Computer -> 1920x1080 -->\n";
        replace+="    <link rel='stylesheet' media='screen and (min-width: 1850px) and (min-device-width: 1281px)' href='layout/metro.1920.css' />\n";
        replace+="    <link rel='stylesheet' media='screen and (min-width: 1850px) and (min-device-width: 1281px)' href='layout/jquery-ui-1.9.0.custom.css' />\n";
        return replace;
    }
    
    static public String printTopMenu(String mod) {
        String replace = "        <div id='TopMenu'></div>\n";
        replace+="        <span id='top'>\n";
        replace+="            <p class='title'><font class='kvasy'>kVASy&reg;</font> System Control</p><div id='logo-div'><img class='logo' src='layout/images/logo_backgroundblue_whitetext.png' title='SIV.AG'/></div>\n";
        replace+="            <p class='subtitle'>Monitoring quite simple!</p>";
        replace+="        </span>\n";
        replace+="        <div id='UserMenu'><table cellpadding=0 cellspacing=0 border=0><tr><td><span class='UserDesc' style='float: left;'>User</span><span style='float: left; margin-top: -1px;' class='ui-icon ui-icon-triangle-1-s'></span></td><td width='10'></td><td colspan=3><span class='UserDesc' style='float: left;'>Session</span><span style='float: left; margin-top: -1px;' class='ui-icon ui-icon-triangle-1-s'></span></td></tr><tr valign=middle><td><p class='login_username'></p></td><td width='10'></td><td><p class='login_shortname'><a href='logout'>Abmelden</a><p></td></tr></table><div id='Liveticker'></div></div>\n";
        return replace;
    }
    
    static public String printSidebars(String mod) {
        String replace = "        <div id='SidebarSmall'>\n";
        replace+="            <div id='LivetickerSidebar'></div>\n";
        replace+="        </div>\n";
        replace+="        <div id='Sidebar'>\n";
        replace+="            <div id='SidebarContent'>\n";
        replace+="                <section id='SidebarSearch'></section>\n";
        replace+="                <section id='SidebarSearchFilter'></section>\n";
        replace+="                <section id='SidebarLiveticker'></section>\n";
        replace+="                <section id='SidebarSubmenu'></section>\n";
        replace+="            </div>\n";
        replace+="        </div>\n";
        replace+="        <div id='SidebarBottomSmall'>\n";
        replace+="            <div id='SlimTaov'></div>\n";
        replace+="        </div>\n";
        replace+="        <div id='SidebarBottom'>\n";
        replace+="            <div id='SidebarBottomContent'>\n";
        replace+="                <table id='TPie' cellpadding='0' cellspacing='0' border='0'>\n";
        replace+="                    <tr>\n";
        replace+="                        <td>\n";
        replace+="                            <div id='HeaderHostPie'>Host Status &Uuml;bersicht</div>\n";
        replace+="                            <div id='HostPie'></div>\n";
        replace+="                        </td>\n";
        replace+="                        <td>\n";
        replace+="                            <div id='HostPer'></div>\n";
        replace+="                        </td>\n";
        replace+="                        <td>\n";
        replace+="                            <div id='HeadComments'>Letzte Kommentare</div>\n";
        replace+="                            <div id='Comments'></div>\n";
        replace+="                            <div id='FooterComments'></div>\n";
        replace+="                        </td>\n";
        replace+="                        <td>\n";
        replace+="                            <div id='HeaderServicePie'>Service Status &Uuml;bersicht (ONLINE Hosts)</div>\n";
        replace+="                            <div id='ServicePie'></div>\n";
        replace+="                        </td>\n";
        replace+="                        <td>\n";
        replace+="                            <div id='ServicePer'></div>\n";
        replace+="                        </td>\n";
        replace+="                    </tr>\n";
        replace+="                </table>\n";
        replace+="                <br>\n";
        replace+="                <div id='HeadDivShowCritical'>Aktuelle Probleme</div>\n";
        replace+="                <div id='DivShowCritical'></div>\n";
        replace+="                <div id='FooterDivShowCritical'></div>\n";
        replace+="            </div>\n";
        replace+="        </div>\n";
        return replace;
    }
}
