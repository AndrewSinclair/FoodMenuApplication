FROM postgres
ENV POSTGRES_USER foodapp
ENV POSTGRES_PASSWORD foodapp
ENV POSTGRES_DB foodapp
COPY 00_schema.sql /docker-entrypoint-initdb.d/
COPY 01_import-test-data.sql /docker-entrypoint-initdb.d/
