CREATE TABLE clothes (
    id             SERIAL  NOT NULL PRIMARY KEY,
    type     VARCHAR(150),
    color       VARCHAR(150),
    size          VARCHAR(30),
    tag      VARCHAR(150),
--     image
     customer_id  INTEGER
);

-- ALTER TABLE clothes ADD CONSTRAINT clothes_pk PRIMARY KEY ( id );


CREATE TABLE customer (
    id             SERIAL  NOT NULL PRIMARY KEY,
    name    VARCHAR(150),
    age       INTEGER,
    sex    VARCHAR(30),
    height        INTEGER,
    weight        INTEGER,
    primer      INTEGER
);
-- ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( id );

CREATE TABLE history (
    id          SERIAL  NOT NULL PRIMARY KEY,
    cus_id       INTEGER,
    date     DATE NOT NULL DEFAULT CURRENT_DATE,
    temperature      VARCHAR(150),
    clothes_id    INTEGER,
    history_id    INTEGER
);
-- ALTER TABLE history ADD CONSTRAINT history_pk PRIMARY KEY ( id );


ALTER TABLE clothes
    ADD CONSTRAINT clothes_customer_fk FOREIGN KEY ( customer_id)
        REFERENCES customer ( id );

ALTER TABLE history
    ADD CONSTRAINT history_clothes_fk FOREIGN KEY ( clothes_id )
        REFERENCES clothes ( id );
