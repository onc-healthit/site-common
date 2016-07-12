#!/usr/bin/bash

grep "Successfully spooled mail.*from.*@.*for.*\[provider1@direct.sitenv.org\]" /usr/local/share/direct/james-2.3.2/apps/james/logs/smtpserver-*log | awk '{split($10, a, "@"); print substr($1,64,10) ","  $10 "," a[2] }' | sort | uniq -c | sed -e 's/^ *//;s/ /,/'