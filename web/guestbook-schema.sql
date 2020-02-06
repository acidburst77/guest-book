CREATE TABLE public.posts (
    id integer NOT NULL DEFAULT nextval('posts_id_seq'::regclass),
    txt character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT posts_pkey PRIMARY KEY (id)
)