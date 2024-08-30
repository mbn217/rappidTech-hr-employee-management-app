#!/bin/bash
# wait-for-mysql.sh

set -e

host="$1"
shift
cmd="$@"

until mysql -h "$host" -u "root" -p"root" -e 'SELECT 1'; do
  >&2 echo "MySQL is unavailable - sleeping"
  sleep 5
done

>&2 echo "MySQL is up - executing command"
exec $cmd
