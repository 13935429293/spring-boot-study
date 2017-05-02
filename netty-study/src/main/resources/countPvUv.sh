#!/bin/bash
for i in seq 1 7; do
dates=$(date -d "$i days ago" +%Y-%m-%d)

less 'info_2017-' + $data + '*' | grep 'hotelId = -1' -c
done