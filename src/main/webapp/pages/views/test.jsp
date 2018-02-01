<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Page</title>
</head>
<body>
Test1 Page!!!<br/>
remote ip :  <%=request.getHeader("X-real-ip") %> <br/>
nginx server ip : <%=request.getRemoteAddr()%><br/>
		AuthType: <%=request.getAuthType()%><br/>
		ContextPath: <%=request.getContextPath()%><br/>
		LocalAddr: <%=request.getLocalAddr()%><br/>
		LocalName: <%=request.getLocalName()%><br/>
		getLocalPort: <%=request.getLocalPort()%><br/>
		Method: <%=request.getMethod()%><br/>
		PathInfo: <%=request.getPathInfo()%><br/>
		PathTranslated: <%=request.getPathTranslated()%><br/>
		Protocol: <%=request.getProtocol()%><br/>
		QueryString: <%=request.getQueryString()%><br/>
		RemoteAddr: <%=request.getRemoteAddr()%><br/>
		RemoteHost: <%=request.getRemoteHost()%><br/>
		RemotePort: <%=request.getRemotePort()%><br/>
		RemoteUser: <%=request.getRemoteUser()%><br/>
		RequestedSessionId: <%=request.getRequestedSessionId()%><br/>
		RequestURI: <%=request.getRequestURI()%><br/>
		Scheme: <%=request.getScheme()%><br/>
		ServerName: <%=request.getServerName()%><br/>
		ServerPort: <%=request.getServerPort()%><br/>
		ServletPath: <%=request.getServletPath()%><br/>
		RequestURL: <%=request.getRequestURL().toString()%><br/>
</body>
</html>