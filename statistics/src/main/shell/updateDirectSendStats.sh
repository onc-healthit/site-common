#!/bin/sh

PRIVATEKEY=/Users/chris/.ssh/direct.sitenv.org-ubuntu
POSTGRES_HOME=/Applications/Postgres.app/Contents/MacOS/bin

FILEOUTPUT=/Users/chris
NOW=$(date +"%F")
FILENAME="directSend-$NOW.log"

FILEPATH=$FILEOUTPUT/$FILENAME

ssh -i $PRIVATEKEY ubuntu@direct.sitenv.org 'bash -s' < retrieveDirectSendStats.sh > $FILEPATH;

$POSTGRES_HOME/psql site_statistics LifeRaySys <<EOF
TRUNCATE direct_send;
COPY direct_send(directsend_count,directsend_date,directsend_email,directsend_domain) FROM '$FILEPATH' WITH DELIMITER ',' CSV;
UPDATE direct_send SET directsend_domain = UPPER(directsend_domain)
EOF