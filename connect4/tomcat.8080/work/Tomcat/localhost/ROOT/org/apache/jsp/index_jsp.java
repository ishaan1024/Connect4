/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.23
 * Generated at: 2021-08-18 14:19:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<HTML>\r\n");
      out.write("    <HEAD>\r\n");
      out.write("        <TITLE>Connect 4 by Ishaan</TITLE>\r\n");
      out.write("        <STYLE>\r\n");
      out.write("            #content{\r\n");
      out.write("                width:708px;\r\n");
      out.write("                height: 800px;\r\n");
      out.write("                margin-top: 0px;\r\n");
      out.write("                margin:auto;\r\n");
      out.write("                background:blue;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            #menu{\r\n");
      out.write("                margin-top: 0px;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                height: 70px;\r\n");
      out.write("                background:red;\r\n");
      out.write("                text-align:center;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            #leaderboard{\r\n");
      out.write("                float: left;\r\n");
      out.write("            }\r\n");
      out.write("            label {\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                width: 50px;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("            }\r\n");
      out.write("            input[type=\"text\"] {\r\n");
      out.write("                margin-top: 0px;\r\n");
      out.write("                margin-left: 5px;\r\n");
      out.write("                width:100px;\r\n");
      out.write("            }\r\n");
      out.write("            input[type=\"hidden\"] {\r\n");
      out.write("                margin-top: 0px;\r\n");
      out.write("                margin-left: 5px;\r\n");
      out.write("                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;\r\n");
      out.write("                color: gold;\r\n");
      out.write("                width:20px;\r\n");
      out.write("            }\r\n");
      out.write("            .center{\r\n");
      out.write("                width: 60%;\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin-left: auto;\r\n");
      out.write("                margin-right: auto;\r\n");
      out.write("            }\r\n");
      out.write("            .menuWriting{\r\n");
      out.write("                margin-top: 0px;\r\n");
      out.write("                height: 10px;\r\n");
      out.write("                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;\r\n");
      out.write("                color: gold;\r\n");
      out.write("            }\r\n");
      out.write("            .leaderboardWriting{\r\n");
      out.write("                margin-top: 0px;\r\n");
      out.write("                font-size: 20px;\r\n");
      out.write("                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </STYLE>\r\n");
      out.write("    </HEAD>\r\n");
      out.write("        <BODY id =\"body\">\r\n");
      out.write("            <p id=\"leaderboard\" class=\"leaderboardWriting\">Leaderboard: </p>\r\n");
      out.write("            <DIV id = \"content\">\r\n");
      out.write("                <img src=\"https://i1.wp.com/baytekentlive.wpengine.com/wp-content/uploads/2017/06/connect4logo.png?resize=352%2C102&ssl=1\" height = \"120\" class=\"center\">\r\n");
      out.write("                <DIV ID = \"menu\">\r\n");
      out.write("                    <p class=\"menuWriting\">Player1, which column would you like to play in?</p>\r\n");
      out.write("                    <form method=\"post\" action=\"hello\">\r\n");
      out.write("                            <input type = \"hidden\" name=\"player\" class = \"menuWriting\"  value = \"%Player%\">\r\n");
      out.write("                           <label for=\"column\" class=\"menuWriting\">Column:</label>\r\n");
      out.write("                           <input type=\"number\" max=\"7\" min=\"1\" name=\"column\">\r\n");
      out.write("                           <input type=\"submit\" value=\"Submit\">\r\n");
      out.write("                     </form>\r\n");
      out.write("\r\n");
      out.write("                </DIV>\r\n");
      out.write("                <canvas id=\"myCanvas\" width=\"708\" height=\"615\"></canvas>\r\n");
      out.write("            </DIV>\r\n");
      out.write("            <SCRIPT>\r\n");
      out.write("                var width =708;\r\n");
      out.write("                var height=615;\r\n");
      out.write("                var counter_width=100;\r\n");
      out.write("                var counter_height=100;\r\n");
      out.write("                var cols=width/counter_width;\r\n");
      out.write("                var rows = height/counter_height;\r\n");
      out.write("                var img = document.createElement(\"img\");\r\n");
      out.write("                var canvas = document.getElementById(\"myCanvas\");\r\n");
      out.write("                var ctx = canvas.getContext(\"2d\");\r\n");
      out.write("                ctx.clearRect(0,0,width,height);\r\n");
      out.write("                for(i = 0;i<=7;i++){\r\n");
      out.write("                    ctx.beginPath();\r\n");
      out.write("                    ctx.lineWidth = \"5\"\r\n");
      out.write("                    ctx.strokeStyle = \"darkBlue\";\r\n");
      out.write("                    ctx.rect(i*100, 0, 5, height-15);\r\n");
      out.write("                    ctx.stroke();\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("                ctx.beginPath();\r\n");
      out.write("                ctx.lineWidth = \"5\"\r\n");
      out.write("                ctx.strokeStyle = \"darkBlue\";\r\n");
      out.write("                ctx.rect(0, height-15, width-3, 5);\r\n");
      out.write("                ctx.stroke();\r\n");
      out.write("                var win = 0;\r\n");
      out.write("                var name;\r\n");
      out.write("                </SCRIPT>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </BODY>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </HTML>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}