java_pids=(`jps -l |grep qiding |awk '{ print $1 }'`)
echo "kill -9 ${java_pids[*]}"
kill -9  ${java_pids[*]}

