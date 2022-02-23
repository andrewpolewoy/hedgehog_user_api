\c "edu"

CREATE TABLE IF NOT EXISTS user_api.users
(
    id integer NOT NULL,
    first_name text NOT NULL,
    last_name text NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER TABLE user_api.users
    OWNER to postgres;

COMMENT ON COLUMN user_api.users.id IS 'Идентификатор';
COMMENT ON COLUMN user_api.users.first_name IS 'Имя';
COMMENT ON COLUMN user_api.users.last_name IS 'Фамилия';




