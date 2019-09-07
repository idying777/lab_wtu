# build stage
FROM node:latest as build-stage
WORKDIR /app
COPY package*.json ./
RUN SASS_BINARY_SITE=http://npm.taobao.org/mirrors/node-sass npm install --registry=https://registry.npm.taobao.org
COPY . .
RUN npm run production-build

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
