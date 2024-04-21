pipeline {
    agent any
    tools {
        // Update Maven tool installation name to match the one in Jenkins
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/L00179076/DisruptiveDevOps']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    sh 'docker build -t riya652/devops:springboot-images-new1 .'
                }
            }
        }
        stage('Push image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'riya652', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u riya652 -p ${dockerhubpwd}'
                    }
                    sh 'docker push riya652/devops:springboot-images-new1'
                }
            }
        }
    }
}

