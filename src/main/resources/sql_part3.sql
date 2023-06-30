SELECT lecture.name, first_name, last_name
FROM teacher
         INNER JOIN lecture ON lecture.id = teacher.lecture_id
ORDER BY lecture_date;

SELECT first_name, last_name, COUNT (lecture.teacher_id)
FROM teacher
         LEFT JOIN lecture ON teacher.id = lecture.teacher_id
GROUP BY first_name, last_name;

SELECT lecture_date, name
FROM lecture
         INNER JOIN teacher ON teacher.id = lecture.teacher_id
WHERE teacher.id = 3
ORDER BY lecture_date;

SELECT course.name,
       COUNT(DISTINCT lecture.id) AS lecture_count,
       COUNT(DISTINCT teacher.id) AS teacher_count,
       COUNT(DISTINCT students.id) AS student_count,
       COUNT(DISTINCT homework.id) AS homework_count,
       COUNT(DISTINCT additionals.id) AS additionals_count
FROM course
         FULL JOIN lecture ON course.id = lecture.course_id
         FULL JOIN teacher ON teacher.course_id = course.id
         FULL JOIN students ON students.course_id = course.id
         FULL JOIN homework ON homework.lecture_id = lecture.id
         FULL JOIN additionals ON additionals.lecture_id = lecture.id
GROUP BY course.name;

SELECT to_char(lecture_date, 'Month') AS month_name,
       COUNT(to_char(lecture_date, 'Month')) AS number_of_lecture
FROM lecture
GROUP BY month_name;

SELECT name_data, data_count
FROM (SELECT char 'homework' AS name_data, COUNT(id) AS data_count FROM homework) as hw
UNION
SELECT char'addition material' AS name_data, COUNT(id) AS data_count FROM additionals
ORDER BY data_count DESC LIMIT 1;