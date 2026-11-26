#!/bin/sh
if [ "$#" -ne 0 ]; then
    echo "Usage: dds_disable.sh" >&2
    exit 2
fi
exec /lib/ufw/oasis-dds disable
