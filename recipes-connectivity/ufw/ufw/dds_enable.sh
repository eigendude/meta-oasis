#!/bin/sh
if [ "$#" -ne 0 ]; then
    echo "Usage: dds_enable.sh" >&2
    exit 2
fi
exec /lib/ufw/oasis-dds enable
