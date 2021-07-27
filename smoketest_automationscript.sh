
if [ $SmokeTest = "Yes" ];
then
    if [ ! -f /var/lib/jenkins/smoketest ];
    then
        mkdir -p /var/lib/jenkins/smoketest
    fi
    if [ $DEPLOY_ENV = "qa1" ];
    then
        status=`curl -u $USERNAME:$PASSWORD  http://localhost:8080/job/smoketestqa1/lastBuild/api/json|jq .building`
       # curl -u $USERNAME:$PASSWORD  http://localhost:8080/job/smoketestqa1/lastBuild/api/json
        if [ $status = "true" ];
        then
            echo 600 > /var/lib/jenkins/smoketest/delaysecondsqa1 
        else
            curl -d "token=my-token&DEPLOY_ENV=$DEPLOY_ENV" -i -X POST "http://$USERNAME:$PASSWORD@localhost:8080/job/smoketestqa1/buildWithParameters"
        fi
    else
        status =`curl -u $USERNAME:$PASSWORD  http://localhost:8080/job/smoketestqa2/lastBuild/api/json|jq .building`
        if [ $status = "true" ];
        then
            echo 600 > /var/lib/jenkins/smoketest/delaysecondsqa2 
        else
            curl -d "token=my-token&DEPLOY_ENV=$DEPLOY_ENV" -i -X POST "http://$USERNAME:$PASSWORD@localhost:8080/job/smoketestqa2/buildWithParameters"
        fi    
        
    fi
fi

