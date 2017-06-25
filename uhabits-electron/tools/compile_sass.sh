#!/bin/bash
exe() { echo "$@" ; "$@" || exit 1; }

echo $(which sass)
sass -v

for input in src/main/sass/*; do
    output=$(basename $input)
    output=build/app/${output/\.scss/.css}
    exe sass $input $output -C -I build/app/node_modules
done
