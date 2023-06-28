CREATE TABLE public.course
(
    id serial NOT NULL,
    name text,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.course
    OWNER to postgres;

INSERT INTO public.course(
    name)
VALUES ('Java');

INSERT INTO public.course(
    name)
VALUES ('Java');

INSERT INTO public.course(
    name)
VALUES ('Python');

INSERT INTO public.course(
    name)
VALUES ('Fronted');

DELETE FROM public.course
WHERE name = 'Java';

SELECT * FROM course

    INSERT INTO public.course(
    name)
VALUES ('Java');

UPDATE public.course
SET id = 1
WHERE id = 4;

CREATE TABLE IF NOT EXISTS public.students
(
    id integer NOT NULL DEFAULT nextval('students_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    CONSTRAINT students_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.students
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.students
(
    id integer NOT NULL DEFAULT nextval('students_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    course_id integer NOT NULL DEFAULT nextval('students_course_id_seq'::regclass),
    CONSTRAINT students_pkey PRIMARY KEY (id),
    CONSTRAINT course_id FOREIGN KEY (course_id)
    REFERENCES public.course (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.students
    OWNER to postgres;

INSERT INTO public.students(
    name)
VALUES ('Student1');

UPDATE public.students
SET course_id=8
WHERE id=7;

INSERT INTO public.students(
    name, course_id)
VALUES ('Student1', 8);

INSERT INTO public.students(
    name, course_id)
VALUES ('Student3', 2);

CREATE TABLE public.teacher
(
    id serial NOT NULL,
    name text,
    course_id serial,
    CONSTRAINT course_id FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.teacher
    OWNER to postgres;

INSERT INTO public.teacher(
    name, course_id)
VALUES ('Teacher', 1);

INSERT INTO public.teacher(
    name, course_id)
VALUES ('Teacher2', 1);

UPDATE public.teacher
SET course_id=2
WHERE id = 1;

SELECT * FROM teacher

CREATE TABLE public.lecture
(
    id serial NOT NULL,
    name text,
    description text,
    lecture_date date,
    course_id serial,
    PRIMARY KEY (id),
    CONSTRAINT course_id FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.lecture
    OWNER to postgres;

INSERT INTO public.lecture(
    name, description, lecture_date, course_id)
VALUES ('Lecture1', 'Intro', '2023-06-28', 1);

CREATE TABLE public.homework
(
    id serial NOT NULL,
    task text,
    lecture_id serial,
    PRIMARY KEY (id),
    CONSTRAINT lecture_id FOREIGN KEY (lecture_id)
        REFERENCES public.lecture (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.homework
    OWNER to postgres;

INSERT INTO public.homework(
    task, lecture_id)
VALUES ('Homework', 1);

CREATE TABLE public.additionals
(
    id serial NOT NULL,
    name text,
    lecture_id serial,
    PRIMARY KEY (id),
    CONSTRAINT lecture_id FOREIGN KEY (lecture_id)
        REFERENCES public.lecture (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.additionals
    OWNER to postgres;

INSERT INTO public.additionals(
    name, lecture_id)
VALUES ('Additional1', 1);