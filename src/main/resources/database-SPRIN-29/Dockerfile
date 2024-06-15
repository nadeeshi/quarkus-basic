
# We are using postgress database for RDBMS
# Docker image will populate database with following schemas and data

FROM postgres
ENV POSTGRES_DB wisdom_pet
ENV POSTGRES_PASSWORD postgres
COPY 1-schema.sql /docker-entrypoint-initdb.d/
COPY 2-data.sql /docker-entrypoint-initdb.d/
EXPOSE 5432