<%-- 
    Document   : logout
    Created on : 25/03/2011, 15:11:45
    Author     : imobFort
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
request.getSession().invalidate();
response.sendRedirect("geral?acao=monitor.Index");
%> 
