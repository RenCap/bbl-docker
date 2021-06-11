# Stage 1 : Build Angular app
FROM node:14.17.0-alpine as node-bbl-docker-app
WORKDIR /usr/src/app
ENV ENVIRONMENT=production
ENV API_URL="http://localhost:8080"
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

# Stage 2 : Set up the server
FROM nginx:1.21.0-alpine
COPY --from=node-bbl-docker-app /usr/src/app/dist/app /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
