<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Spring MVC FORM</title>
    </head>
        <body>
            <h1> Submitted Student Information</h1>
            <table>
                <tr>
                    <td> Name</td>
                  <td> ${name}</td>
                </tr>
                 <tr>
                    <td> Age</td>
                  <td> ${age}</td>
                </tr>
                 <tr>
                    <td> Id</td>
                  <td> ${id}</td>
                </tr>
            </table>
        </body>
    </html>

