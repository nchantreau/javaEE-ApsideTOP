FROM postgres:latest

ENV POSTGRES_DB data
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD password

ADD sql/*.sql /docker-entrypoint-initdb.d/