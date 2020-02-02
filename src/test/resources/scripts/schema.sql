CREATE TABLE EMPLOYEES (
    employee_id bigint NOT NULL,
    commission double precision,
    created_on timestamp without time zone NOT NULL,
    email character varying(255),
    first_name character varying(255),
    hire_date date,
    job_title character varying(255),
    last_name character varying(255),
    phone character varying(255),
    salary double precision,
    updated_at timestamp without time zone NOT NULL,
    department_id bigint,
    manager_id bigint
);

CREATE TABLE JOBS (
    job_id bigint NOT NULL,
    job_title character varying(255),
    max_salary double precision,
    min_salary double precision
);


CREATE TABLE LOCATIONS
(
    location_id bigint NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    postal_code character varying(255) COLLATE pg_catalog."default",
    state_province character varying(255) COLLATE pg_catalog."default",
    street_address character varying(255) COLLATE pg_catalog."default",
    country_id bigint,
    CONSTRAINT locations_pkey PRIMARY KEY (location_id),
    CONSTRAINT fkqkdn2dl5vjl7ogslbs6g01hsu FOREIGN KEY (country_id)
        REFERENCES public.countries (country_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
CREATE TABLE COUNTRIES
(
    country_id bigint NOT NULL,
    country_name character varying(255) COLLATE pg_catalog."default",
    region_id bigint,
    CONSTRAINT countries_pkey PRIMARY KEY (country_id),
    CONSTRAINT fkr1fmqmei20mceuddty8cympx FOREIGN KEY (region_id)
        REFERENCES public.regions (region_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)