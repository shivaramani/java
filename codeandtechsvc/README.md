##Running a java spring booot application in Kubernetes

- Create a sample java spring boot application
- dockerize the application
- Build & push the app to docker registry
- Install docker, minikube, Virtualbox
- Configure Kubernetes objects (kubectl create deployment, service, get pods, minikube dashboard, minikube service


## create sample docker app using 
- Follow steps to create a sampl application 

- can create a Web spring boot app from - https://start.spring.io/  or use a sample from below
  ex: https://spring.io/guides/gs/spring-boot-docker/
  
- modify the prefix to "shivaramani" (or your docker name). otherwise you will not be able to push to your image/repository

## Build, push the app

- $ mvn package && java -jar target/codeandtech-0.1.0.jar
- $ mvn install dockerfile:build
- $ docker login
- $ docker push shivaramani/codeandtech
 - The above would have pushed to the docker hub. ex: https://hub.docker.com/r/shivaramani/codeandtech/


## Install minikube

- install minikube
	$ curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.25.0/minikube-linux-amd64 && chmod +x minikube && sudo mv minikube /usr/local/bin/
- install virtual box
	$ apt install virtualbox
- start minikube
	$ virtualbox startvm ubuservloc
	$ minikube start --vm-driver=virtualbox
-  to run the kubernetes dashboard
	# http://192.168.99.100:30000/#!/overview?namespace=default

	$ minikube dashboard

## Deploy the app using Kubernetes - NOTE this can be done through HELM also 

- # create deployment.yml
- # make sure to modify the labels app, containers name, image etc accordingly

	$ kubectl create -f deployment.yml 
	
	# describe service
	$ kubectl describe deployment codeandtech

	# NOTE if you gget the error - The connection to the server 192.168.99.100:8443 was refused - did you specify the right host or port? make sure to run the minikube start as mentioned above and see if the "kubectl is now configured to use the cluster" as part of the response

	$ kubectl get pods
	$ kubectl create -f service.yml
	$ kubectl describe service codeandtech
	
	# to access the service
	$ minikube service codeandtech


	This would open your browser and point it, for example, to http://192.168.99.100:31039. Port 31029 is the NodePort we requested and the IP address is the address of our minikube cluster. We can now access the service routes:

	curl http://192.168.99.100:31039/

