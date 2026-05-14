#!/bin/sh

if [ -z "$DB_DATASOURCE" ]; then
  echo "Database name is mandatory!"
  exit 1
fi

if [ -z "$DB_USERNAME" ]; then
  echo "Database username is mandatory!"
  exit 1
fi

if [ -z "$DB_PASSWORD" ]; then
  echo "Database password is mandatory!"
  exit 1
fi

exec java -Dspring.datasource.url="${DB_DATASOURCE}" -Dspring.datasource.username="${DB_USERNAME}" -Dspring.datasource.password="${DB_PASSWORD}" -jar app.jar