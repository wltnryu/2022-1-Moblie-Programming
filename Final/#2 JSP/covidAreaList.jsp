<%@page contentType="application/json; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.json.simple.JSONObject"%> 
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%> 
<%@page import="org.json.simple.parser.ParseException"%> 
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>

<%
// String url ="http://sc1.swu.ac.kr/~merman/covid19list.jsp"; // ?searchparas={ "area":"서울", "date":"20220505" };

request.setCharacterEncoding("utf-8");
String sSearchParas = URLDecoder.decode(request.getParameter("searchparas"),"UTF-8");

try {
JSONParser jsonParser = new JSONParser(); //JSON데이터를 넣어 JSON Object 로 만들어 준다. JSONObject jsonObject = (JSONObject)
jsonParser.parse(sSearchParas);

out.println("("+ jsonObject.toString() +")"); //JSON name으로 추출
out.println("area==>"+jsonObject.get("area")); 
out.println("date==>"+jsonObject.get("date"));

} catch (ParseException e) {
    // TODO Auto-generated catch block e.printStackTrace();
    } finally {
    } %>
<%@ include file="makeAreaData.jsp" %>