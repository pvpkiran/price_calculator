DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS prices;

DROP SEQUENCE IF EXISTS product_seq;
DROP SEQUENCE IF EXISTS brand_seq;
DROP SEQUENCE IF EXISTS prices_seq;

CREATE SEQUENCE product_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE brand_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE prices_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;


CREATE TABLE product
(
    id           bigint NOT NULL DEFAULT NEXTVAL('product_seq'),
    product_id   bigint NOT NULL,
    product_name character varying(255),
    CONSTRAINT product_pk_id PRIMARY KEY (id)
);

CREATE TABLE brand
(
    id         bigint NOT NULL DEFAULT NEXTVAL('brand_seq'),
    brand_id   bigint NOT NULL,
    brand_name character varying(255),
    CONSTRAINT brand_pk_id PRIMARY KEY (id)
);

CREATE TABLE prices
(
    id         bigint         NOT NULL DEFAULT NEXTVAL('prices_seq'),
    price_list bigint         NOT NULL,
    priority   bigint         NOT NULL,
    price      decimal(10, 2) NOT NULL,
    curr       character varying(3),
    start_date timestamp without time zone,
    end_date   timestamp without time zone,
    brand_id bigint NOT NULL,
    product_id bigint NOT NULL,
    CONSTRAINT prices_pk_id PRIMARY KEY (id),
    CONSTRAINT prices_product_fk_id foreign key (product_id) references product,
    CONSTRAINT prices_brand_fk_id foreign key (brand_id) references brand
);