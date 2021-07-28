pipeline {
  agent { label 'master' }
  stages {
         stage("smoketest") {   
             when {
                expression { DEPLOY_ENV ==~ '(qa1|qa2)'}
             }  
              steps { 
                 checkout scm: [$class: 'GitSCM',
                 branches: [[name: 'main']],
                 userRemoteConfigs: [[url: 'https://github.com/sreedhar-devops/clonetest.git']]]    
                 script{
                    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'credsfordownsteamjob', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                        sh 'chmod 777 smoketest_automationscript.sh'
                        sh './smoketest_automationscript.sh' 
                    } 
                  }
             }
         }    
   }
}
