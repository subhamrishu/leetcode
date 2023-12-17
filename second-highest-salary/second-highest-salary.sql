# Write your MySQL query statement below
# SELECT Salary as SecondHighestSalary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1;
Select 
(Select Distinct salary from employee order by salary desc limit 1 offset 1) as SecondHighestSalary;