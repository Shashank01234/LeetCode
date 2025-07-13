SELECT
  'Low Salary' AS Category,
  SUM(income < 20000) AS accounts_count
FROM Accounts
UNION ALL
SELECT
  'Average Salary' AS Category,
  SUM(income >= 20000 AND income <= 50000) AS accounts_count
FROM Accounts
UNION ALL
SELECT
  'High Salary' AS Category,
  SUM(income > 50000) AS accounts_count
FROM Accounts;

