<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:if test="${not empty message }">
	<br><br>${message}
	<c:remove var="message"/>
</c:if>