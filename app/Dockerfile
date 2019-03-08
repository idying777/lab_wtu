FROM node:latest

WORKDIR /app
COPY package*.json ./

RUN npm ci --registry=https://registry.npm.taobao.org

COPY . .

CMD ['npm','run','production-build']
