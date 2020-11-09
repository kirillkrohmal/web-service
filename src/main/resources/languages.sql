CREATE TABLE languages
(
    id serial NOT NULL,
    name character varying(2000),
    description character varying(2000),
    rating integer NOT NULL,
    CONSTRAINT languages_pkey PRIMARY KEY (id)
);


INSERT INTO languages VALUES (1, 'Java', 'Java language', 1);
INSERT INTO languages VALUES (2, 'JavaScript', 'JavaScript language', 2);
INSERT INTO languages VALUES (3, 'CSharp', 'C# language', 3);
INSERT INTO languages VALUES (4, 'Cpp', 'C++ language', 4);
INSERT INTO languages VALUES (5, 'Python', 'Python language', 5);