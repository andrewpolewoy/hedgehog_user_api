CREATE USER "postgres" WITH PASSWORD 'postgres';

CREATE DATABASE "edu" WITH OWNER = "postgres";

\c "edu"

CREATE SCHEMA user_api AUTHORIZATION "postgres";
COMMENT ON SCHEMA security IS 'Схема для хранения зарегистрированных пользователей';



CREATE USER "security_app_user" WITH PASSWORD 'B0OuQ1#wTdV$';

CREATE DATABASE "security_demo" WITH OWNER = "security_app_user";

\c "security_demo"

CREATE SCHEMA security AUTHORIZATION "security_app_user";
COMMENT ON SCHEMA security IS 'Схема для хранения метаинформации чувствительной для взлома';


    CREATE SCHEMA user_api
        AUTHORIZATION postgres;