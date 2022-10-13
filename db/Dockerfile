FROM mysql:5.7.25

ENV MYSQL_ROOT_PASSWORD="root"
ENV MYSQL_DATABASE="mydb"

ADD db_setup.sql docker-entrypoint-initdb.d/db_setup.sql