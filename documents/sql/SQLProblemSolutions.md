# SQL Problem Solutions

## 184. Department Highest Salary (Medium)

- https://leetcode.com/problems/department-highest-salary/
- Oracle & With As & Exists

```
with s1 as(
    select t.departmentId, max(t.salary) max_salary
      from Employee t
      group by t.departmentId
), s2 as(
    select *
        from Employee t
        where exists(
          select 1 
            from s1 c
            where c.departmentId = t.departmentId
              and c.max_salary = t.salary)
)

select (select c.name from Department c where c.id = t.departmentId) Department,
       t.name Employee,
       t.Salary
  from s2 t
```
