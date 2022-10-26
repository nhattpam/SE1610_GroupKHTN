<%-- 
    Document   : feedback
    Created on : Oct 26, 2022, 1:59:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback</title>
    </head>
    <body>
        <form action="AddFeedback" method="POST">
            <li class="bg-white mb-3">
                <div class="form-outline">
                    <input type="hidden" name="uid" value="${uid}">
                    <input type="hidden" name="pid" value="${pid}"> 
                    <textarea type="textarea" class="form-control" id="textAreaExample2" name="feedback"></textarea>
                    <label class="form-label" for="textAreaExample2">Message</label>
                </div>
            </li>
            <button type="input" class="btn btn-info btn-rounded float-end">Send</button>

        </form>
    </body>
</html>
