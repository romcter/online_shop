1. Run docker-compose up -d                                                              
2. Wait until all containers have started (check with docker logs -f <container_name>)   
3. Start the spring boot application                                                     
4. Go to the kibana UI (http://localhost:5601)                                           
5. Go to Stack Management -> Index Patterns -> Create index pattern                      
6. Add the index with pattern "spring-boot-elk-logs-*"                                   
7. Select the timestamp field and finish                                                 
8. Go to Kibana -> Discover                                                              
9. Now you're able to see the logs