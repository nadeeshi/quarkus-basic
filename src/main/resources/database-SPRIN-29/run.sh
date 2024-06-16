
#start scripts for docker image with database
# this will expose the db on an abnormal port, we can customize it if needed
# To access the maximum number of OS systems available, best way to install db using docker, without installed it into our machines
# when run this script, you can ensure it start up
# we can use docker ps command to view it or we can see container running in docker desktop
docker build -t wisdom-db .
docker run -d --rm -p 5430:5432 --name wisdom-pg wisdom-db