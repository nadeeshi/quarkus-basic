docker build -t wisdom-db .
docker run -d --rm -p 5430:5432 --name wisdom-pg wisdom-db