<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Sign Out"/>
        </form>
        <h1>Recorders</h1><br>
        <c:forEach items="${recorders}" var="recorder">
            Id: ${recorder.getId()}<br>
            Record limit: ${recorder.getRecordCurrent()}/${recorder.getRecordLimit()}<br>
            Memory total: ${recorder.getMemoryCurrent()}/${recorder.getMemoryTotal()}<br>
            <form action="/recorder/${recorder.getId()}" method="get">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input type="submit" value="Select"/></div>
            </form>
            <form action="/recorderDelete" method="post">
                <input type="hidden" name="recorderId" value="${recorder.getId()}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input type="submit" value="Delete"/></div>
            </form>
            <br>
        </c:forEach>
        <hr>
        <h2>Add Recorder</h2>
        <form action="/recorderAdd" method="post">
            Record limit: <input type="number" name="recordLimit"/>
            Memory total: <input type="number" name="memoryTotal"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Add"/></div>
        </form>
    </body>
</html>
