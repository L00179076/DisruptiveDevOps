pipeline {
    agent any
    tools {
        maven 'maven_3_5_0'
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
                    sh 'docker build -t javatechie/maven-demo .'
                }
            }
        }
        stage('Push image to Hub') {
    steps {
        script {
            withCredentials([usernamePassword(credentialsId: 'riya652', usernameVariable: 'dockerhubuser', password: 'N/cjZZjbBsD;8e6' passwordVariable: 'dockerhubpwd')]) {
                sh "docker login -u ${dockerhubuser} -p ${dockerhubpwd}"
            }
            sh 'docker push javatechie/maven-demo'
        }
    }
}

    }
}
