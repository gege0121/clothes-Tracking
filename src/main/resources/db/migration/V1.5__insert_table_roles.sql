CREATE TABLE roles (
    id                   SERIAL NOT NULL,
    name                 VARCHAR(30) not null unique,
    allowed_resource     VARCHAR(200),
    allowed_read         VARCHAR(1) not null default 'N',
    allowed_create       VARCHAR(1) not null default 'N',
    allowed_update       VARCHAR(1) not null default 'N',
    allowed_delete       VARCHAR(1) not null default 'N'
);

ALTER TABLE roles ADD CONSTRAINT role_pk PRIMARY KEY ( id );

CREATE TABLE users_roles (
    user_id    INTEGER NOT NULL,
    role_id    INTEGER NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT users_fk FOREIGN KEY ( user_id )
        REFERENCES customers ( id );

ALTER TABLE users_roles
    ADD CONSTRAINT roles_fk FOREIGN KEY ( role_id )
        REFERENCES roles ( id );