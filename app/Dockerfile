FROM node:latest

WORKDIR /app
COPY package*.json ./

RUN npm ci

COPY . .

CMD ['npm','run','production-build']
