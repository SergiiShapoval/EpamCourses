<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
Mark countries that you have visited before:
<form action="foreachtest.jsp" method="post">
    <select multiple="multiple" name="countries">
        <option value="USA">USA</option>
        <option value="Canada">Canada</option>
        <option value="Italy">Italy</option>
        <option value="Spain">Spain</option>
        <option value="Germany">Germany</option>
        <option value="Norway">Norway</option>
        <option value="France">France</option>
        <option value="Switzerland">Switzerland</option>
    </select>
    <input type="submit" value="see all listed">
</form>
</body>
</html>
