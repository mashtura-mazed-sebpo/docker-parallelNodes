# docker-parallelNodes

![parallel_run_chrome](https://user-images.githubusercontent.com/71812190/174052246-fca20a1c-5ff3-492c-a035-9a71aa97aee9.PNG)


![seesion](https://user-images.githubusercontent.com/71812190/174052263-251e2575-1f18-454a-89f2-c603936f39e3.PNG)

````
version: "3"
services:
  chrome:
    image: selenium/node-chrome:4.2.0-20220527
    shm_size: 2gb
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
      - SE_NODE_MAX_INSTANCES=5
      - SE_NODE_MAX_SESSIONS=8

  selenium-hub:
    image: selenium/hub:4.2.0-20220527
    container_name: selenium-hub
    ports:
      - "4442:4442"
      - "4443:4443"
      - "4444:4444"
      - "4445:4445"


````


**SE_NODE_MAX_INSTANCES=4 --> change this numbers to test**

**SE_NODE_MAX_SESSIONS=4  --> change this numbers to test**
