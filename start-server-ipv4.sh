sh stop-server.sh
#下载最新代码
git pull origin master
#打包编译
mvn clean package install
#启动服务
nohup java  -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -jar qiding-jiaguo-eureka/target/qiding-jiaguo-eureka-0.0.1-SNAPSHOT.jar > log/qiding-jiaguo-eureka.log &
nohup java  -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -jar qiding-jiaguo-zipkin/target/qiding-jiaguo-zipkin-0.0.1-SNAPSHOT.jar > log/qiding-jiaguo-zipkin.log &
nohup java  -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -jar qiding-jiaguo-gateway/target/qiding-jiaguo-gateway-0.0.1-SNAPSHOT.jar > log/qiding-jiaguo-gateway.log &
nohup java  -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -jar qiding-jiaguo-cache/target/qiding-jiaguo-cache-0.0.1-SNAPSHOT.jar > log/qiding-jiaguo-cache.log  &
nohup java  -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -jar qiding-jiaguo-user/target/qiding-jiaguo-user-0.0.1-SNAPSHOT.jar > log/qiding-jiaguo-user.log &
nohup java  -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true -jar qiding-jiaguo-file/target/qiding-jiaguo-file-0.0.1-SNAPSHOT.jar > log/qiding-jiaguo-file.log &
