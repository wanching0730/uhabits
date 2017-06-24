#!/bin/bash
gradle as || exit
build/app/node_modules/.bin/electron build/app
