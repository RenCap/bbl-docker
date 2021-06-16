# Stage 1 : Build Angular app
FROM node:14.17.0-alpine as node-bbl-docker-app
WORKDIR /usr/src/app
ENV API_URL="http://localhost:8080"
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

# Stage 2 : Set up the server
FROM nginx:1.21.0-alpine
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=node-bbl-docker-app /usr/src/app/dist/app /usr/share/nginx/html

COPY ./entrypoint.sh /
RUN chmod +x entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]
