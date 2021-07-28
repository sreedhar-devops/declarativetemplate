pipeline {
  agent { label 'master' }
  stages {
         stage("smoketest") {   
             when {
                expression { DEPLOY_ENV ==~ '(qa1|qa2)'}
             }  
              steps { 
                dir("smokeautomation") { 
                  checkout scm: [$class: 'GitSCM',
                  branches: [[name: 'main']],
                  userRemoteConfigs: [[url: 'https://github.com/sreedhar-devops/clonetest.git']]]
                 }   
                 withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'credsfordownsteamjob', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                                      sh 'chmod 777 ./smokeautomation/smoketest_automationscript.sh; ./smokeautomation/smoketest_automationscript.sh' 
                 } 
              }
         }    
   }
}
