<%@page import="cse.maven.sample.exception.InvalidNicPropException"%>
<%@page import="cse.maven.sample.NicProp"%>
<%@page import="cse.maven.sample.NIC_interpreter"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NIC Interpreter</title>
<h1>NIC interpretation results</h1>

<h3>Result of NIC interpretation is</h3>
<%
	String nic = request.getParameter("nic");
		
	NIC_interpreter nicCalculator = new NIC_interpreter();
	
	try {
		NicProp nicProp = nicCalculator.createNicProp(nic);
		Date nicDate = nicCalculator.calculateDate(nicProp);
                out.println("Date of Birth: "+nicDate);
                out.println("\nGender: "+nicCalculator.getGender(nicProp));
                out.println("\nIsVoter: " + nicCalculator.isVoter(nicProp));
	} catch (InvalidNicPropException ex) {
		out.println(ex.getMessage());
	}	
%>
</head>
<body>

</body>
</html>