#下载最新代码
git pull origin master
#打包编译
mvn clean package install
#启动服务
nohup java   -jar qiding-jiaguo-eureka/target/qiding-jiaguo-eureka-0.0.1-SNAPSHOT.jar &
nohup java   -jar qiding-jiaguo-zipkin/target/qiding-jiaguo-zipkin-0.0.1-SNAPSHOT.jar &
nohup java   -jar qiding-jiaguo-gateway/target/qiding-jiaguo-gateway-0.0.1-SNAPSHOT.jar &
nohup java   -jar qiding-jiaguo-cache/target/qiding-jiaguo-cache-0.0.1-SNAPSHOT.jar &
nohup java   -jar qiding-jiaguo-user/target/qiding-jiaguo-user-0.0.1-SNAPSHOT.jar &
