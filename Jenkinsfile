pipeline{
    agent any
    tools {
        maven 'jenkins-maven'
    }
    stages{
        stage('Test'){
            steps{
                echo 'testing...'
                    sh 'mvn test -P prod'
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