cd src/infra/

kubectl apply -f mongo-configmap.yml
kubectl apply -f mongo-stateful.yml
kubectl apply -f mongo-service.yml
kubectl apply -f mongo-secrets.yml
kubectl apply -f redis-configmap.yml
kubectl apply -f redis-stateful.yml
kubectl apply -f redis-service.yml
kubectl apply -f employees-configmap.yml
kubectl apply -f employees-deployment.yml
kubectl apply -f employees-service.yml