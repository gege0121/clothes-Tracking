CREATE TABLE customers_roles (
    customer_id    INTEGER NOT NULL,
    role_id    INTEGER NOT NULL
);

ALTER TABLE customers_roles
    ADD CONSTRAINT customers_fk FOREIGN KEY ( customer_id )
        REFERENCES customers ( id );

ALTER TABLE customers_roles
    ADD CONSTRAINT roles_fk FOREIGN KEY ( role_id )
        REFERENCES roles ( id );