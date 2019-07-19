# Kubernetes workshop

## Kubernetes sources

https://kubernetes.io/docs/concepts/overview/what-is-kubernetes/
https://kubernetes.io/docs/concepts/workloads/pods/pod-overview/

## Basics

The tutorial covers:
- [Pod](./pod.yaml)
- [Service](./service.yaml)
- [Ingress](./ingress.yaml)
- [Deployments](./deployment.yaml)

> Use the [documentation](https://kubernetes.io/docs/concepts/overview/what-is-kubernetes/) to learn about the each object.


## Commands used in the tutorial

List of commands used in the tutorial in chronological order. (Some of them are used more than once.)

```
kubectl get all
kubectl create -f pod.yaml
kubectl describe pod kuard
kubectl logs kuard
kubectl get pod kuard -o wide
kubectl get pod kuard -o yaml
kubectl get pod kuard -o json
kubectl get pod kuard -o jsonpath='{.kind}'
kubectl port-forward pod/kuard 8088:8080
kubectl create -f service.yaml
kubectl get all
kubectl describe svc kuard
kubectl port-forward svc/kuard 8081:80
kubectl port-forward pod/kuard 8088:8080
kubectl replace -f pod.yaml
kubectl edit pod kuard
kubectl describe pod kuard
kubectl get -n staging secret/tls-admin-api-staging-socifi-com -o yaml
kubectl create -f ingress.yaml
kubectl get ingress
kubectl get pod,ingress,svc
kubectl logs -n ingress --since=5m -f pod/cert-manager-756d6d885d-5m9r5
kubectl create -f deployment.yaml
kubectl get pod -o wide
kubectl get ingress,svc,pod,deploy
kubectl create -f pod.yaml
kubectl create -f service.yaml
kubectl create -f ingress.yaml
kubectl get all
kubectl get pod,svc,ingress
kubectl delete -f pod.yaml
kubectl create -f deployment.yaml
kubectl get all
```

# Helm


## Github as a helm repository

https://hackernoon.com/using-a-private-github-repo-as-helm-chart-repo-https-access-95629b2af27c