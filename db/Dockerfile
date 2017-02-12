FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_DB postgres
COPY schema.sql /docker-entrypoint-initdb.d/
COPY import-test-data.sql /docker-entrypoint-initdb.d/
