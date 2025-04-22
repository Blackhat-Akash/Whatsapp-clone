# Build stage
FROM node:18 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build  # Assumes Angular is configured for production

# Run stage (Nginx)
FROM nginx:alpine
COPY --from=build /app/dist/your-angular-app /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
