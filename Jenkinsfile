pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build Maven') {
            steps {
                tool name: 'maven', type: 'maven'
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
