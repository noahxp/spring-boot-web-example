<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page isErrorPage="true" %>

<html>
<body>
<h1>
internal server 500 @_@"
</h1>
</body>
</html>

<%
    String remoteAddr = (request.getHeader("HTTP_X_FORWARDED_FOR")==null?request.getRemoteAddr():request.getHeader("HTTP_X_FORWARDED_FOR"));
    if (remoteAddr.equals("127.0.0.1")  || remoteAddr.equals("0:0:0:0:0:0:0:1")){
%>

<div style="text-align:left;">
    <hr>
    <pre><%
        if (exception!=null){  // jsp error
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            exception.printStackTrace(pw);
            String errorStack = sw.getBuffer().toString();
            out.println(errorStack);
        } else if (request.getAttribute("exceptionStack")!=null){  // strtus 's error , cann't use <s:property value="%{exceptionStack}"/> ,because jsp can't get s tag object
            out.println(request.getAttribute("exceptionStack"));
        }
    %>
		</pre>
</div>
<%
        }
%>