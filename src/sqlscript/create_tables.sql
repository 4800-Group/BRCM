
CREATE SEQUENCE public.activity_activity_id_seq;

CREATE TABLE public.activity (
                activity_id INTEGER NOT NULL DEFAULT nextval('public.activity_activity_id_seq'),
                name VARCHAR NOT NULL,
                current_price REAL NOT NULL,
                CONSTRAINT activity_id PRIMARY KEY (activity_id)
);


ALTER SEQUENCE public.activity_activity_id_seq OWNED BY public.activity.activity_id;

CREATE TABLE public.historical_price (
                historical_price_id INTEGER NOT NULL,
                date DATE NOT NULL,
                price REAL NOT NULL,
                activity_id INTEGER NOT NULL,
                CONSTRAINT historical_price_id PRIMARY KEY (historical_price_id)
);


CREATE TABLE public.customer (
                bronco_id VARCHAR NOT NULL,
                discount REAL NOT NULL,
                dob DATE NOT NULL,
                first_name VARCHAR NOT NULL,
                last_name VARCHAR NOT NULL,
                phone VARCHAR NOT NULL,
                department VARCHAR,
                office VARCHAR,
                research VARCHAR,
                enter_date VARCHAR,
                grad_date VARCHAR,
                major VARCHAR,
                minor VARCHAR,
                CONSTRAINT bronco_id PRIMARY KEY (bronco_id)
);


CREATE TABLE public.address (
                address_id INTEGER NOT NULL,
                bronco_id VARCHAR NOT NULL,
                number INTEGER NOT NULL,
                city VARCHAR NOT NULL,
                state VARCHAR NOT NULL,
                zip_code INTEGER NOT NULL,
                street VARCHAR NOT NULL,
                CONSTRAINT address_id PRIMARY KEY (address_id)
);


CREATE SEQUENCE public.visit_visit_id_seq;

CREATE TABLE public.visit (
                visit_id INTEGER NOT NULL DEFAULT nextval('public.visit_visit_id_seq'),
                time TIMESTAMP NOT NULL,
                bronco_id VARCHAR NOT NULL,
                CONSTRAINT visit_id PRIMARY KEY (visit_id)
);


ALTER SEQUENCE public.visit_visit_id_seq OWNED BY public.visit.visit_id;

CREATE SEQUENCE public.visit_activity_visit_activity_id_seq;

CREATE TABLE public.visit_activity (
                visit_activity_id INTEGER NOT NULL DEFAULT nextval('public.visit_activity_visit_activity_id_seq'),
                time TIMESTAMP NOT NULL,
                visit_id INTEGER NOT NULL,
                activity_id INTEGER NOT NULL,
                CONSTRAINT visit_activity_id PRIMARY KEY (visit_activity_id)
);


ALTER SEQUENCE public.visit_activity_visit_activity_id_seq OWNED BY public.visit_activity.visit_activity_id;

ALTER TABLE public.visit_activity ADD CONSTRAINT activity_visit_activity_fk
FOREIGN KEY (activity_id)
REFERENCES public.activity (activity_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.historical_price ADD CONSTRAINT activity_historical_price_fk
FOREIGN KEY (activity_id)
REFERENCES public.activity (activity_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visit ADD CONSTRAINT customer_visit_fk
FOREIGN KEY (bronco_id)
REFERENCES public.customer (bronco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.address ADD CONSTRAINT customer_address_fk
FOREIGN KEY (bronco_id)
REFERENCES public.customer (bronco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visit_activity ADD CONSTRAINT visit_visit_activity_fk
FOREIGN KEY (visit_id)
REFERENCES public.visit (visit_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;