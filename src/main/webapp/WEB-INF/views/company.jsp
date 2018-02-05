<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app='companyApp'>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="/SpringMvcJpaJBoss/static/resources/js/company.js"></script>
    <title>Company</title>
    <title>Company</title>
    <style>
        th, td {

            border-collapse: collapse;
            padding: 5px;
        }

        table.striped {
            width: 90%;
            border: 1px solid grey;
            border-collapse: collapse;
            padding: 5px;
        }

        table.striped tr:nth-child(odd) {
            background-color: #f1f1f1;
        }

        table.striped tr:nth-child(even) {
            background-color: #ffffff;
        }

        span.header3 {
            text-indent: 50px;
            font-size: 1.1em;
            margin: 10px 10px 10px 10px;
            margin-left: 5px;
        }

        div.smallPane {
            width: 250;
            border-style: solid;
            border-width: 1px;
            background-color: #f1f1f1;
            padding: 10px;
        }

        div.main {
            margin: auto;
            margin-top: 150px;
            width: 40%;
            border: 1px solid gray;
            border-radius: 25px;
            background: linear-gradient(-90deg, white, #f1f1f1);
            padding: 10px;
        }

    </style>
</head>
<body>

<div ng-controller='deptsEmpsMainController' class='main'>

    <table class='striped'>
        <tr>
            <th>Dept Id</th>
            <th>Dept Name</th>
            <th>Dept Location</th>
        </tr>
        <tr ng-repeat="dept in depts | orderBy : 'deptId'" ng-click='listDeptEmps(dept.deptId)'>
            <td>{{ dept.deptId }}</td>
            <td>{{ dept.dname }}</td>
            <td>{{ dept.location }}</td>
        </tr>
    </table>

    <br><br>
    <input type='checkbox' ng-model="showAddEmp"> Show Add Employee
    <div>
        <div class='smallPane' ng-show='showAddEmp'>
            <span class='header3'>Add New Employee:</span>
            <form ng-submit="submitForm()">
                <table>
                    <tr>
                        <td><label for="eName">Name: </label></td>
                        <td><input type='text' name='eName' id='eName' ng-model='emp.name'></td>
                    </tr>
                    <tr>
                        <td><label for="eSalary">Salary: </label></td>
                        <td><input type='number' name='eSalary' id='eSalary' ng-model='emp.salary'></td>
                    </tr>
                    <tr>
                        <td><label for="eHiredate">Hire date: </label></td>
                        <td><input type='date' name='eHiredate' id='eHiredate' ng-model='emp.hiredate'></td>
                    </tr>
                    <tr>
                        <td><label for="eGender">Sex: </label></td>
                        <td><select name='sex' id='sex' ng-model='emp.gender'>
                            <option value='m'>Male</option>
                            <option value='f'>Female</option>
                        </select> <br></td>
                    </tr>
                    <tr>
                        <td><label for="eDeptId">DeptId: </label></td>
                        <td><input type='text' name='eDeptId' id='eDeptId' ng-model='emp.deptId'></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type='submit' value='Add'></td>
                    </tr>
                </table>
            </form>
            <pre>emp = {{ emp | json }}</pre>
        </div>

        <br><br>

        <div>
            <table class='striped'>
                <tr>
                    <th>Emp Id</th>
                    <th>Emp Name</th>
                    <th>Salary</th>
                    <th>Hire date</th>
                    <th>Gender</th>
                    <th></th>
                </tr>
                <tr ng-repeat="emp in emps | orderBy : 'empId'">
                    <td>{{ emp.empId }}</td>
                    <td>{{ emp.name }}</td>
                    <td>{{ emp.salary }}</td>
                    <td>{{ emp.hiredate | date : 'dd/MM/yyyy' }}</td>
                    <td>{{ emp.gender == 'm' ? 'Male' : 'Female' }}</td>
                    <td><span ng-click="deleteEMP(emp.empId)" style="color:red">X</span></td>
                </tr>
            </table>
        </div>

    </div>

</div>

<br>


</body>
</html>