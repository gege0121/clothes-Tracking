
ALTER TABLE roles ALTER COLUMN allowed_read DROP DEFAULT;
ALTER TABLE roles ALTER allowed_read TYPE bool USING allowed_read::boolean;
ALTER TABLE roles ALTER COLUMN allowed_read SET DEFAULT FALSE;

ALTER TABLE roles ALTER COLUMN allowed_create DROP DEFAULT;
ALTER TABLE roles ALTER allowed_create TYPE bool USING allowed_create::boolean;
ALTER TABLE roles ALTER COLUMN allowed_create SET DEFAULT FALSE;

ALTER TABLE roles ALTER COLUMN allowed_delete DROP DEFAULT;
ALTER TABLE roles ALTER allowed_delete TYPE bool USING allowed_delete::boolean;
ALTER TABLE roles ALTER COLUMN allowed_delete SET DEFAULT FALSE;

ALTER TABLE roles ALTER COLUMN allowed_update DROP DEFAULT;
ALTER TABLE roles ALTER allowed_update TYPE bool USING allowed_update::boolean;
ALTER TABLE roles ALTER COLUMN allowed_update SET DEFAULT FALSE;