CREATE TABLE product (
	id serial4 NOT NULL,
	description varchar(500) NULL,
	price numeric(10, 2) NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);
