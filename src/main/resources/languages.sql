CREATE TABLE languages
(
    id serial NOT NULL,
    name character varying(2000),
    description character varying(2000),
    rating integer NOT NULL,
    CONSTRAINT languages_pkey PRIMARY KEY (id)
);
