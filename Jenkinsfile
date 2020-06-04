pipeline{
    agent any
    tools {
        maven 'jenkins-maven'
    }
    stages{
        stage('Test'){
            steps{
                script {
                        echo 'testing...'
                        sh 'mvn test -P prod'
                        if(GIT_BRANCH == 'integration'){
                            echo 'testing integration...'
                            sh 'mvn test -P integration'
                        }
                    }
                }
            }
        stage('Build'){
            steps{
                echo 'build...'
                sh 'mvn -DskipTests clean install -P prod'
            }
        }
        stage('Deploy'){
            steps{
                script {
                    if(GIT_BRANCH == 'master'){
                        echo 'deploying...'
                    }
                }
            }
        }

    }
}