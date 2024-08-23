pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials' // ID kredensial yang telah disimpan
    }
    stages {
        stage('Login to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        echo "Logged in to Docker Hub"
                    }
                }
            }
        }
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
