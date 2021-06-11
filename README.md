docker-machine create -d virtualbox vm1

docker-machine ssh vm1

docker-machine ssh vm1 "..."

eval $(docker-machine env vm1)

eval $(docker-machine env -u)
