 /* 
 * Call:
 * <script type="text/javascript">
        $(function() {
            $(document).ready(function() {
                KeyFunctionSidebar();
                KlickFunctionSidebar();
            });
        });
   </script>
 * --------------------------------------------------------------
 */

var Backend;
var DeleteDomainSuffix;
var state = urlPara('s').replace(/%3D/g,'=');
var searchstring = urlPara('searchstring').replace(/%3D/g,'=').replace(/%20/g,' ').replace(/%22/g,'"').replace(/%25/g,'%').replace(/%3C/g,'<').replace(/%3E/g,'>').replace(/%5B/g,'[').replace(/%5C/g,'\\').replace(/%5D/g,']').replace(/%5E/g,'^').replace(/%60/g,'`').replace(/%7B/g,'{').replace(/%7C/g,'|').replace(/%7D/g,'}').replace(/%7E/g,'~').replace(/%7F/g,'').replace(/%28/g,'(').replace(/%29/g,')').replace(/%2B/g,'+');
var suburl = window.location.pathname.split("/")[1];
var FullName;
var UUID;
var UserID;
var UserMail;
var UsrPctrPath;
var UsrPctrLength;
var UserGroups = [];
var UserPerm = [];
var Mailing = [];

function GetUserConfig() {
    $.ajax({
        url: '/gateway/exec/GetUserConfig',
        dataType: 'json',
        crossDomain: true,
        cache: false,
        async: false,
        success: function(json) {
            $.each(json, function() {
                Backend = this.LOCAL_BACKEND;
                $.each(this.DASHBOARD, function() {
                    $('#DashboardLinks').append('<a href="' + $.base64.decode( this.TARGET ) + '" class="twitter"><span>' + $.base64.decode( this.TITLE ) + '</span><br></br><span class="sub-grid">' + $.base64.decode( this.DESC ) + '</span></a>');
                });
                $.each(this.USER_CONFIG, function() {
                    if (this.KEY == "DeleteDomainSuffix") {
                        DeleteDomainSuffix = this.ACTION;
                    }
                });
                $('p.login_username').html($.base64.decode( this.NAME ));
                UUID = $.base64.decode( this.UUID );
                UserID = $.base64.decode( this.UID );
                FullName = $.base64.decode( this.NAME );
                UserMail = $.base64.decode( this.MAIL );
                UsrPctrPath = $.base64.decode( this.PCTR );
                UsrPctrLength = $.base64.decode( this.PCTRL );
                if ( UsrPctrLength != "0" ) {
                    $('#UserProfileConfig').attr('src',UsrPctrPath);
                    $('#UserPictureP').attr('src',UsrPctrPath);
                }
                UserGroups = this.USER_GROUPS;
                UserPerm = this.USER_PERM;
                Mailing = this.MAILING;
            });
        },
        error: function (xhr, thrownError) {
            alert(xhr.status + "::" + thrownError);
        }
    });
}

function Loader() {
    $('#TopMenu').append('<img id="AjaxLoader" src="layout/images/ajax-loader.gif">');
}

function SubLoader() {
    $('#TopMenu').append('<img id="AjaxLoader" src="../layout/images/ajax-loader.gif">');
}

function Base() {
    $("#back-div").append("<a class='back-a' href='./'><img class='back-img' src='layout/images/white/back.png' title='Zur&uuml;ck'/></a>");
}

function SubBase() {
    $("#back-div").append("<a class='back-a' onclick=\"history.back ();\"><img class='back-img' src='../layout/images/white/back.png' title='Zur&uuml;ck'/></a>");
}

function urlParam(name) {
    var results = new RegExp('[\\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
    if(typeof(results) !== 'undefined' && results != null) { return results[1]; } else { return 0; }
}

function urlPara(name){
    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");  
    var regexS = "[\\?&]"+name+"=([^&#]*)";
    var regex = new RegExp( regexS );  
    var results = regex.exec( window.location.href ); 
    if( results == null )
        return "";  
    else
        return results[1];
}

function ChangeTitle() {
    document.title = $.base64.decode( urlPara('c') ) + '@' + $.base64.decode( urlPara('h') ) + ' - kVASy' + decodeURI('%C2%AE') + ' System Control';
}

function KeyFunctionSidebar(uid) {
    var b64uid = $.base64.encode( uid );
    $.Shortcuts.add({
        type: 'down',
        mask: 'b',
        handler: function() {
            if ($("#SidebarBottom").is(":hidden")) {
                $('#SidebarBottomSmall').animate({marginBottom: "870px"},350).css('zIndex',25);
                $('#SidebarBottom').animate({height:'toggle'},350, function() {
                    $('#SidebarBottomContent').fadeIn(100);
                }).css('zIndex',25);
            } else {
                $('#SidebarBottomContent').fadeOut(100);
                $('#SidebarBottom').animate({height:'toggle'},350).css('zIndex',10);
                $('#SidebarBottomSmall').animate({marginBottom: "0px"},350).css('zIndex',10);
            }
        }
    }).start();
}

function KlickFunctionSidebar(uid) {
    var b64uid = $.base64.encode( uid );
    $('#SidebarSmall').click(function() {
        if ($("#Sidebar").is(":hidden")) {
            $('#SidebarSmall').animate({marginRight: "400px"},350).css('zIndex',30);
            $('#Sidebar').animate({width:'toggle'},350, function() {
                $('#SidebarContent').fadeIn(100);
            }).css('zIndex',30);
            SearchHosts( b64uid + 'Jhdu8K');
        } else {
            $('#SidebarContent').fadeOut(100);
            $('#Sidebar').animate({width:'toggle'},350).css('zIndex',30);
            $('#SidebarSmall').animate({marginRight: "0px"},350).css('zIndex',30);
        }
    });
    $('#SidebarBottomSmall').dblclick(function() {
        if ($("#SidebarBottom").is(":hidden")) {
            $('#SidebarBottomSmall').animate({marginBottom: "870px"},350).css('zIndex',25);
            $('#SidebarBottom').animate({height:'toggle'},350, function() {
                $('#SidebarBottomContent').fadeIn(100);
            }).css('zIndex',25);
        } else {
            $('#SidebarBottomContent').fadeOut(100);
            $('#SidebarBottom').animate({height:'toggle'},350).css('zIndex',10);
            $('#SidebarBottomSmall').animate({marginBottom: "0px"},350).css('zIndex',10);
        }
    });
}

function StyleSidebar(uid) {
    var b64uid = $.base64.encode( uid );
    $('#SidebarSearch').append('<div id="Title">Suchen</div><div id="SubTitle">Nichts ausgew&auml;hlt!</div><form id="SearchForm" method="GET"><input id="SearchInput" name="searchstring" type="text" onclick="DeleteVal();"><img onclick="FormSubmit();" id="SearchImgInput" src="layout/images/search.png" /></form>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFHost" onclick="SearchHosts(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="layout/images/server.png"><span>Hosts</span></div>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFService" onclick="SearchServices(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="layout/images/services.png"><span>Services</span></div>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFDatabase" onclick="SearchDatabases(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="layout/images/database.png"><span>Datenbanken</span></div>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFMiddleware" onclick="SearchMiddleware(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="layout/images/layers.png"><span>Middleware</span></div>');
}

function SubStyleSidebar(uid) {
    var b64uid = $.base64.encode( uid );
    $('#SidebarSearch').append('<div id="Title">Suchen</div><div id="SubTitle">Nichts ausgew&auml;hlt!</div><form id="SearchForm" method="GET"><input id="SearchInput" name="searchstring" type="text" onclick="DeleteVal();"><img onclick="FormSubmit();" id="SearchImgInput" src="../layout/images/search.png" /></form>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFHost" onclick="SearchHosts(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="../layout/images/server.png"><span>Hosts</span></div>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFService" onclick="SearchServices(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="../layout/images/services.png"><span>Services</span></div>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFDatabase" onclick="SearchDatabases(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="../layout/images/database.png"><span>Datenbanken</span></div>');
    $('#SidebarSearchFilter').append('<div class="DivSearchFilter" id="SFMiddleware" onclick="SearchMiddleware(\'' + b64uid + 'Ljd84K\');"><img id="SearchImg" src="../layout/images/layers.png"><span>Middleware</span></div>');
}

function DeleteVal() {
    $('input#SearchInput').val('');
}

function FormSubmit() {
    $('form#SearchForm').submit();
}

function SearchHosts(uid) {
    $('form#SearchForm').attr('action', '/' + suburl + '/hosts/');
    $('#SubTitle').html('.. nach Hosts');
    $('input#SearchInput').val('Hostname');
    $('#SFService').removeClass('BgBlue');
    $('#SFCustomer').removeClass('BgBlue');
    $('#SFHost').addClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SFMiddleware').removeClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdEhvc3RzHj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.hosts, function( item ) {
                        return {
                            label: item.NAME + ' (' + item.CUST_VAL + ') auf ' + item.NODE,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchServices(uid) {
    $('form#SearchForm').attr('action', '/' + suburl + '/services/');
    $('#SubTitle').html('.. nach Services');
    $('input#SearchInput').val('Servicename');
    $('#SFHost').removeClass('BgBlue');
    $('#SFCustomer').removeClass('BgBlue');
    $('#SFService').addClass('BgBlue');
    $('#SFMiddleware').removeClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdFNlcnZpY2VzHj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.services, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchDatabases(uid) {
    $('form#SearchForm').attr('action', '/' + suburl + '/database/');
    $('#SubTitle').html('.. nach Datenbanken');
    $('input#SearchInput').val('SID');
    $('#SFHost').removeClass('BgBlue');
    $('#SFCustomer').removeClass('BgBlue');
    $('#SFService').removeClass('BgBlue');
    $('#SFMiddleware').removeClass('BgBlue');
    $('#SFDatabase').addClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdERhdGFiYXNlcw==Hj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.databases, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchMiddleware(uid) {
    $('form#SearchForm').attr('action', '/' + suburl + '/middleware/');
    $('#SubTitle').html('.. nach Middleware Instanzen');
    $('input#SearchInput').val('Type/Port');
    $('#SFHost').removeClass('BgBlue');
    $('#SFCustomer').removeClass('BgBlue');
    $('#SFService').removeClass('BgBlue');
    $('#SFMiddleware').addClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdE1pZGRsZXdhcmU=Hj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.middleware, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchHostgroups(uid) {
    $('form#SearchForm').attr('action', 'services4.jsp');
    $('#SubTitle').html('.. nach Hostgruppen');
    $('input#SearchInput').val('Name');
    $('#SFHost').removeClass('BgBlue');
    $('#SFService').removeClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SFMiddleware').addClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdEhvc3Rncm91cHM=Hj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.databases, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchServicesSearch(uid,content) {
    $('form#SearchForm').attr('action', '/' + suburl + '/services/');
    $('#SubTitle').html('.. nach Services');
    $('input#SearchInput').val(content);
    $('#SFHost').removeClass('BgBlue');
    $('#SFService').addClass('BgBlue');
    $('#SFMiddleware').removeClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdFNlcnZpY2VzHj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.services, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchHostsSearch(uid,content) {
    $('form#SearchForm').attr('action', '/' + suburl + '/hosts/');
    $('#SubTitle').html('.. nach Hosts');
    $('input#SearchInput').val(content);
    $('#SFService').removeClass('BgBlue');
    $('#SFHost').addClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SFMiddleware').removeClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdEhvc3RzHj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.hosts, function( item ) {
                        return {
                            label: item.NAME + ' (' + item.CUST_VAL + ') auf ' + item.NODE,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchDatabasesSearch(uid,content) {
    $('form#SearchForm').attr('action', '/' + suburl + '/database/');
    $('#SubTitle').html('.. nach Datenbanken');
    $('input#SearchInput').val(content);
    $('#SFHost').removeClass('BgBlue');
    $('#SFService').removeClass('BgBlue');
    $('#SFMiddleware').removeClass('BgBlue');
    $('#SFDatabase').addClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdERhdGFiYXNlcw==Hj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.databases, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function SearchMiddlewareSearch(uid,content) {
    $('form#SearchForm').attr('action', '/' + suburl + '/middleware/');
    $('#SubTitle').html('.. nach Middleware Instanzen');
    $('input#SearchInput').val(content);
    $('#SFHost').removeClass('BgBlue');
    $('#SFService').removeClass('BgBlue');
    $('#SFMiddleware').addClass('BgBlue');
    $('#SFDatabase').removeClass('BgBlue');
    $('#SearchInput').autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: 'http://' + Backend + '/proxy/json/?e=1&m=TGlzdE1pZGRsZXdhcmU=Hj86Hz&u=' + uid,
                dataType: 'json',
                cache: false,
                data: {                    
                    searchstring: request.term
                },
                success: function( data ) {
                    response( $.map( data.middleware, function( item ) {
                        return {
                            label: item.HOST +  ' (' + item.NODE + ') - ' + item.NAME,
                            value: item.NAME
                        }
                    }));
                }
            });
        },
        minLength: 1
    });
}

function AddLink() {
    $('#AddLink').html('<div id="AddLinkDialog" title="F&uuml;ge einen weiteren Link zum Dashboard hinzu!">\n\
    <table id="AddLinkTable">\n\
        <tr>\n\
            <td>Titel:</td>\n\
            <td><input type=text id="DaBTitle"/></td>\n\
        </tr>\n\
        <tr>\n\
            <td>Beschreibung:</td>\n\
            <td><input type=text id="DaBDesc"/></td>\n\
        </tr>\n\
        <tr>\n\
            <td>URL Ziel:</td>\n\
            <td><input type=text id="DaBTarget"/></td>\n\
        </tr>\n\
    </table>\n\
</div>');
    $('#AddLinkDialog').dialog({
	autoOpen: true,
	height: 210,
	width: 600,
	draggable: false,
	resizable: false,
	modal: true,
	buttons: { 
            EINTRAGEN: function() { 
                $.ajax({
                    url: '/gateway/exec/AddDashboardLink?uuid=' + $.base64.encode( UUID ) + '&title=' + $.base64.encode( $('#DaBTitle').val() ) + '&desc=' + $.base64.encode( $('#DaBDesc').val() ) + '&target=' + $.base64.encode( $('#DaBTarget').val() ),
                    crossDomain: true,
                    success: function(json) {
                        if (json.ADD == "1") {
                            DialogMailComplete("#UserProfileSuccess","Dashboard Link hinzugef&uuml;gt","Dashboard Link wurde erfolgreich hinzugef&uuml;gt.");
                        } else {
                            DialogMailComplete("#UserProfileSuccess","+++ Fehler beim hinzuf&uuml;gen des Dashboard Links +++","<font color=red>Der Dashboard Link konnte NICHT hinzugef&uuml;gt werden.</font>");
                        }
                    },
                    error: function (xhr, thrownError) {
                        alert(xhr.status + "::" + thrownError);
                    },
                    dataType: 'json',
                    cache: false
                });
		$(this).dialog('close');
		$('#AddLinkDialog').remove();
                //location.reload();
            },
            ABBRECHEN: function() {
                $(this).dialog('close');
		$('#AddLinkDialog').remove();
            }
	}
    });
}

function LoadBasic(uid) {
    $.ajax({
        url: 'http://' + Backend + '/repo/json/?e=1&m=SW5zZXJ0RGFzaGJvYXJkQWxsKd8Hfg&u=' + uid + '',
        crossDomain: true,
        success: DialogSuccess("#1","Die Basiseinstellungen für das Dashboard wurden erfolgreich gesetzt."),
        dataType: 'json',
        cache: false
    });
}

function DialogSuccess(id,message) {
    $(id).append('<div id="SuccessDialog" title="Aktion Erfolgreich durchgef&uuml;hrt."><p><span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>' + message + '</p></div>');
    $('#SuccessDialog').dialog({
        autoOpen: true,
        height: 200,
        width: 600,
        draggable: false,
        resizable: false,
        modal: false,
        buttons: { 
            OK: function() {
                $(this).dialog('close');
                $('#SuccessDialog').remove();
            }
        }
    });
}

function DeleteBasic(uid) {
    $.ajax({
        url: 'http://' + Backend + '/repo/json/?e=1&m=RGVsZXRlRGFzaGJvYXJkQWxsJkl8Hd&u=' + uid + '',
        crossDomain: true,
        success: DialogSuccess("#2","Die Standardeinstellungen für das Dashboard wurden erfolgreich gesetzt."),
        dataType: 'json',
        cache: false
    });
}

function DeleteBasicConfig(uid) {
    $.ajax({
        url: 'http://' + Backend + '/repo/json/?e=1&m=RGVsZXRlUmVwb0FsbA==Jhdu8d&u=' + uid + '',
        crossDomain: true,
        success: DialogSuccess("#3","Alle Einstellungen wurden erfolgreich zur&uuml;ckgesetzt!"),
        dataType: 'json',
        cache: false
    });
}

function AddConfig(uid,mdl,key,val1,val2,val3) {
    var b64mdl = $.base64.encode( mdl );
    var b64key = $.base64.encode( key );
    var b64val1 = $.base64.encode( val1 );
    var b64val2 = $.base64.encode( val2 );
    var b64val3 = $.base64.encode( val3 );
    $.ajax({
        url: 'http://' + Backend + '/repo/json/?e=1&m=SW5zZXJ0VXBkYXRlQ29uZmlnHkl8Ui&u=' + uid + '&m2=' + b64mdl + 'Jkl8Hd&k=' + b64key + 'Jkl8Hd&v1=' + b64val1 + 'Jkl8Hd&v2=' + b64val2 + 'Jkl8Hd&v3=' + b64val3 + 'Jkl8Hd',
        crossDomain: true,
        success: DialogSuccess(".Config","Konfiguration wurde ge&auml;ndert."),
        dataType: 'json',
        cache: false
    });
}

function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}

function PrintTS() {
    var currentTime = new Date()
    var hours = currentTime.getHours()
    var minutes = currentTime.getMinutes()
    var seconds = currentTime.getSeconds()
    if (minutes < 10){
        minutes = "0" + minutes
    }
    if (seconds < 10){
        seconds = "0" + seconds
    }
    return(hours + ":" + minutes + ":" + seconds)
}

function OpenWindow(target,mode) {
    window.open(target,mode);
}

function MailTest() {
    $('#MailForm').html('<div id="MailFormDialog" title="Testmail mit Gateway Backend versenden.">\n\
        <table id="MailFormTable">\n\
            <tr><td>Von:</td><td><input id="from" type=text /></td></tr>\n\
            <tr><td>An:</td><td><input id="to" type=text /></td></tr>\n\
            <tr><td>Cc:</td><td><input id="cc" type=text /></td></tr>\n\
            <tr><td>Betreff:</td><td><input id="subject" type=text /></td></tr>\n\
            <tr><td colspan=2><textarea id="text"></textarea></td></tr>\n\
        </table>\n\
    </div>');
    $('#text').html('\n\
\n\
\n\
Mit freundlichen Gr&uuml;&szlig;en\n\
\n\
' + FullName);
    $('#subject').val('[WARTUNG] ');
    $('#MailFormDialog').dialog({
	autoOpen: true,
	height: 600,
	width: 900,
	draggable: false,
	resizable: false,
	modal: true,
	buttons: { 
            SENDEN: function() {
                $.ajax({
                    url: '/gateway/exec/SendHtmlMail?to=' + $.base64.encode( $('#to').val() ) + '&cc=' + $.base64.encode( $('#cc').val() ) + '&from=' + $.base64.encode( $('#from').val() ) + '&subject=' + $.base64.encode( $('#subject').val() ) + '&text=' + $.base64.encode( $('#text').val() ),
                    crossDomain: true,
                    success: function(json) {
                        if (json.SEND == "1") {
                            DialogMailComplete("#MailSendSuccess","Mail Versandt erfolgreich.","Die Mail wurde erfolgreich an " + json.TO + " gesendet.");
                        } else {
                            DialogMailComplete("#MailSendSuccess","+++ Fehler beim Mail Versandt +++","<font color=red>Die Mail konnte NICHT gesendet werden.</font>");
                        }
                    },
                    error: function (xhr, thrownError) {
                        alert(xhr.status + "::" + thrownError);
                    },
                    dataType: 'json',
                    cache: false
                });
		$(this).dialog('close');
		$('#MailFormDialog').remove();
            },
            ABBRECHEN: function() {
                $(this).dialog('close');
		$('#MailFormDialog').remove();
            }
	}
    });
}

function DialogMailComplete(id,title,message) {
    $(id).html('<div id="SuccessDialog" title="' + title + '"><p><span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>' + message + '</p></div>');
    $('#SuccessDialog').dialog({
        autoOpen: true,
        height: 200,
        width: 600,
        draggable: false,
        resizable: false,
        modal: false,
        buttons: { 
            OK: function() {
                $(this).dialog('close');
                $('#SuccessDialog').remove();
                
                //location.reload();
            }
        }
    });
}

var dateFormat = function () {
	var	token = /d{1,4}|m{1,4}|yy(?:yy)?|([HhMsTt])\1?|[LloSZ]|"[^"]*"|'[^']*'/g,
		timezone = /\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g,
		timezoneClip = /[^-+\dA-Z]/g,
		pad = function (val, len) {
			val = String(val);
			len = len || 2;
			while (val.length < len) val = "0" + val;
			return val;
		};

	// Regexes and supporting functions are cached through closure
	return function (date, mask, utc) {
		var dF = dateFormat;

		// You can't provide utc if you skip other args (use the "UTC:" mask prefix)
		if (arguments.length == 1 && Object.prototype.toString.call(date) == "[object String]" && !/\d/.test(date)) {
			mask = date;
			date = undefined;
		}

		// Passing date through Date applies Date.parse, if necessary
		date = date ? new Date(date) : new Date;
		if (isNaN(date)) throw SyntaxError("invalid date");

		mask = String(dF.masks[mask] || mask || dF.masks["default"]);

		// Allow setting the utc argument via the mask
		if (mask.slice(0, 4) == "UTC:") {
			mask = mask.slice(4);
			utc = true;
		}

		var	_ = utc ? "getUTC" : "get",
			d = date[_ + "Date"](),
			D = date[_ + "Day"](),
			m = date[_ + "Month"](),
			y = date[_ + "FullYear"](),
			H = date[_ + "Hours"](),
			M = date[_ + "Minutes"](),
			s = date[_ + "Seconds"](),
			L = date[_ + "Milliseconds"](),
			o = utc ? 0 : date.getTimezoneOffset(),
			flags = {
				d:    d,
				dd:   pad(d),
				ddd:  dF.i18n.dayNames[D],
				dddd: dF.i18n.dayNames[D + 7],
				m:    m + 1,
				mm:   pad(m + 1),
				mmm:  dF.i18n.monthNames[m],
				mmmm: dF.i18n.monthNames[m + 12],
				yy:   String(y).slice(2),
				yyyy: y,
				h:    H % 12 || 12,
				hh:   pad(H % 12 || 12),
				H:    H,
				HH:   pad(H),
				M:    M,
				MM:   pad(M),
				s:    s,
				ss:   pad(s),
				l:    pad(L, 3),
				L:    pad(L > 99 ? Math.round(L / 10) : L),
				t:    H < 12 ? "a"  : "p",
				tt:   H < 12 ? "am" : "pm",
				T:    H < 12 ? "A"  : "P",
				TT:   H < 12 ? "AM" : "PM",
				Z:    utc ? "UTC" : (String(date).match(timezone) || [""]).pop().replace(timezoneClip, ""),
				o:    (o > 0 ? "-" : "+") + pad(Math.floor(Math.abs(o) / 60) * 100 + Math.abs(o) % 60, 4),
				S:    ["th", "st", "nd", "rd"][d % 10 > 3 ? 0 : (d % 100 - d % 10 != 10) * d % 10]
			};

		return mask.replace(token, function ($0) {
			return $0 in flags ? flags[$0] : $0.slice(1, $0.length - 1);
		});
	};
}();

// Some common format strings
dateFormat.masks = {
	"default":      "ddd mmm dd yyyy HH:MM:ss",
	shortDate:      "m/d/yy",
	mediumDate:     "mmm d, yyyy",
	longDate:       "mmmm d, yyyy",
	fullDate:       "dddd, mmmm d, yyyy",
	shortTime:      "h:MM TT",
	mediumTime:     "h:MM:ss TT",
	longTime:       "h:MM:ss TT Z",
	isoDate:        "yyyy-mm-dd",
	isoTime:        "HH:MM:ss",
	isoDateTime:    "yyyy-mm-dd'T'HH:MM:ss",
	isoUtcDateTime: "UTC:yyyy-mm-dd'T'HH:MM:ss'Z'"
};

// Internationalization strings
dateFormat.i18n = {
	dayNames: [
		"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
		"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
	],
	monthNames: [
		"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
		"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
	]
};

// For convenience...
Date.prototype.format = function (mask, utc) {
	return dateFormat(this, mask, utc);
};

