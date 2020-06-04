pipeline{
    agent any
    tools {
        maven 'jenkins-maven'
    }
    stages{
        stage('Test'){
            steps{
                script {
                        if(GIT_BRANCH == 'develop'){
                            echo 'testing development...'
                            sh 'mvn test -P dev'
                        }
                        if(GIT_BRANCH == 'integration'){
                            echo 'testing integration...'
                            sh 'mvn test -P integration'
                        }
                        if(GIT_BRANCH == 'master'){
                            echo 'testing prod...'
                            sh 'mvn test -P prod'
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