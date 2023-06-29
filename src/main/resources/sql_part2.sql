SELECT * FROM students ORDER BY last_name

SELECT name, number_of_additional FROM lecture WHERE lecture_date < '2023-01-01' ORDER BY lecture_date;

SELECT * FROM lecture ORDER BY lecture_date, number_of_hw DESC LIMIT 1;

SELECT resource_type, COUNT (resource_type) FROM additionals GROUP BY resource_type;

SELECT * FROM teacher WHERE (last_name >= 'A' AND last_name < 'N') OR (last_name >= 'А' AND last_name < 'Н');

SELECT first_name, last_name, COUNT (course_id)
FROM students
GROUP BY first_name, last_name
ORDER BY last_name;