--
-- JBoss, Home of Professional Open Source
-- Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- This script initializes the database by creating tables and inserting data
-- Use only for a proof of concept

-- You can use this file to load seed data into the database using SQL statements
insert into MemberBasic (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212')
insert into MemberBasic (id, name, email, phone_number) values (10, 'James Noures', 'James@mailinator.com', '2125551213')
insert into MemberBasic (id, name, email, phone_number) values (20, 'Jake Noures', 'Jake@mailinator.com', '2125551214')




INSERT INTO DEPT(deptId,dname,location) VALUES(1,'IT','Sydney')
INSERT INTO DEPT(deptId,dname,location) VALUES(2,'HR','Melbourne')

INSERT INTO Emp (empId,country,gender,hiredate,name,photo,salary,version,dept_deptId) VALUES (101,1,'m',{ts '2014-07-17 18:47:52.69'},'Saleh Noures',null,8000,0,1)
INSERT INTO Emp (empId,country,gender,hiredate,name,photo,salary,version,dept_deptId) VALUES (102,1,'m',{ts '2014-08-17 18:47:52.69'},'Greg James',null,7000,0,1)
INSERT INTO Emp (empId,country,gender,hiredate,name,photo,salary,version,dept_deptId) VALUES (103,1,'f',{ts '2015-06-17 18:47:52.69'},'Sarah Rob',null,5000,0,2)

INSERT INTO DEPT_Emp(DEPT_deptId,emps_empId) VALUES(1,101)
INSERT INTO DEPT_Emp(DEPT_deptId,emps_empId) VALUES(1,102)
INSERT INTO DEPT_Emp(DEPT_deptId,emps_empId) VALUES(2,103)
