<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action="/recorders" method="get">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="To Recorders"/></div>
        </form>
        <h1>Recorder</h1><br>
        Id: ${recorder.getId()}<br>
        Record limit: ${recorder.getRecordCurrent()}/${recorder.getRecordLimit()}<br>
        Memory total: ${recorder.getMemoryCurrent()}/${recorder.getMemoryTotal()}<br>
        <br>
        <h2>Records</h2><br>
        <c:forEach items="${records}" var="record">
            Id: ${record.getId()}<br>
            Data: ${record.getData()}<br>
            Number: ${record.getNumber()}<br>
            Size: ${record.getSize()}<br>
            <form action="/recordDelete" method="post">
                <input type="hidden" name="recorderId" value="${recorder.getId()}" />
                <input type="hidden" name="recordId" value="${record.getId()}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input type="submit" value="Delete"/></div>
            </form>
            <br>
        </c:forEach>
        <hr>
        <h2>Add Record</h2>
        <form action="/recordAdd" method="post">
            Data: <input type="text" name="data"/>
            Number: <input type="number" name="number"/>
            <input type="hidden" name="recorderId" value="${recorder.getId()}" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Add"/></div>
        </form>
    </body>
</html>