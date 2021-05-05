## Example project for monitoring a spring boot application with Prometheus and Grafana

Just a regular Spring boot application with 2 classes for creating custom metrics with Micrometer.  
(one to create your custom metrics and one to schedule a job)

2 dependencies got added in the ```pom.xml```, one for Spring actuator and one for Micrometer.  
in our ```application.properties``` we added:
```
management.endpoints.web.exposure.include=prometheus
management.endpoint.health.show-details=always
management.metrics.tags.application= monitoringdemo
```
to enable our Prometheus endpoint and show details about the application health. 

### To run it yourself :

The prometheus.yml file under resources needs to be mounted into the Prometheus docker image you want to use like : 

```
docker run -d -p 9090:9090 -v ~/<PATH_TO_PROMETHEUS.YML_FOLDER>/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
```   
</br>

Keep in mind that you'll need to change the local IP to your own in the .yml file, when you want to monitor your application.
</br>
``` yml
    static_configs:
      - targets: ['192.168.0.23(change this to your IP):8080']
```


Afterwards you can access the Prometheus webUI on ```localhost:9090```. 
</br></br>
To run Grafana run: 

```
docker run -d -p 3000:3000 grafana/grafana
```

Grafana can be accessed on ```localhost:3000```.  
Username and password are both "admin" when you log in for the first time.  

[To find more information on how to set up Grafana I will refer to Ordina's techblog.](https://ordina-jworks.github.io/monitoring/2020/11/16/monitoring-spring-prometheus-grafana.html#setup-grafana)
