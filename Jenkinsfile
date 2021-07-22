pipeline {
  agent { label 'master' }
  stages {
    stage('test') {   
      steps {     
        script{
          def var1 = load "example.groovy"
          var1.test()
        }
      }
    }
    
    }
}
