<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>

    <c:if test="${not empty userProfile}">
        <h2>User Information</h2>
        <p>User ID: ${userProfile.id}</p>
        <p>Username: ${userProfile.username}</p>
        <p>Full Name: ${userProfile.fullName}</p>

        <h2>User Media</h2>
        <c:forEach items="${userMediaList}" var="userMedia">
            <div>
                <img src="${userMedia.imageUrl}" alt="User Media">
                <p>${userMedia.caption}</p>
            </div>
        </c:forEach>
    </c:if>
</body>
</html>
