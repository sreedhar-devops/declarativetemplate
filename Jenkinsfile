pipeline {
  agent { label 'master' }
  stages {
    stage('test') {   
      steps {     
        script{
          pipeline = load 'example.groovy'
          pipeline.test()
        }
      }
    }
    
    }
}
