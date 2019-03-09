FROM node:latest
VOLUME . /app
WORKDIR /app
RUN SASS_BINARY_SITE=http://npm.taobao.org/mirrors/node-sass npm install --registry=https://registry.npm.taobao.org
ENTRYPOINT npm run serve
